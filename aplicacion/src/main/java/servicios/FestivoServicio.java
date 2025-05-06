package fechasfestivas.api.aplicacion.servicios;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import fechasfestivas.api.aplicacion.servicios.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import fechasfestivas.api.dominio.entidades.*;
import fechasfestivas.api.core.servicios.*;
import fechasfestivas.api.infraestructura.repositorios.*;

@Service
public class FestivoServicio implements IFestivoServicio {

    @Autowired
    private IFestivoRepositorio repositorio;

    public List<Festivo> listar() {
        return repositorio.findAll();
    }

    public List<Festivo> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    public Festivo obtener(int id) {
        return repositorio.findById(id).orElse(null);
    }

    public Festivo agregar(Festivo nuevoFestivo) {
        nuevoFestivo.setId(0);
        return repositorio.save(nuevoFestivo);
    };

    public Festivo modificar(Festivo festivo) {
        if (repositorio.findById(festivo.getId()).isEmpty()) {
            return null;
        } else {
            return repositorio.save(festivo);
        }
    };

    public boolean eliminar(int id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    };

    // Metodo para traer los dias festivos, segun el año
    public List<Date> listaDiasFestivos(int año) {
        Date fecha;
        ServicioFechas servicio = new ServicioFechas();
        List<Festivo> listaFestivos = listar();
        List<Date> nuevaLista = new ArrayList<>();

        for (Festivo festivo : listaFestivos) {
            int tipoFestivo = festivo.getTipo().getId();
            Date domingoRamos = ServicioFechas.getInicioSemanaSanta(año);
            switch (tipoFestivo) {
                case 1:
                    // solo agrega el año y a la lista
                    fecha = new Date(año - 1900, festivo.getMes() - 1, festivo.getDia());
                    nuevaLista.add(fecha);

                    break;

                case 2:
                    fecha = new Date(año - 1900, festivo.getMes() - 1, festivo.getDia());
                    fecha = servicio.getSiguienteLunes(fecha);
                    nuevaLista.add(fecha);
                    break;

                case 3:
                    fecha = new Date(año - 1900, festivo.getMes() - 1, festivo.getDia());
                    fecha = servicio.agregarDias(domingoRamos, festivo.getDiasPascua());

                    nuevaLista.add(fecha);
                    break;

                case 4:

                    fecha = servicio.getSiguienteLunes(servicio.agregarDias(domingoRamos, festivo.getDiasPascua()));
                    nuevaLista.add(fecha);
                    break;
            }

        }
        return nuevaLista;

    }

    public String comprobacionFestivo(Date fechaEntrada) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fechaEntrada);
        int año = calendario.get(Calendar.YEAR);

        String esFestivo = "No es festivo";
        List<Date> listaFestivos = listaDiasFestivos(año);

        for (Date fecha : listaFestivos) {
            // limpio las entradas, hay difernecias de segundos
            Calendar fechaFestiva = Calendar.getInstance();
            fechaFestiva.setTime(fecha);
            fechaFestiva.set(Calendar.HOUR_OF_DAY, 0);
            fechaFestiva.set(Calendar.MINUTE, 0);
            fechaFestiva.set(Calendar.SECOND, 0);
            fechaFestiva.set(Calendar.MILLISECOND, 0);
            Calendar fechaEntradaCalendario = Calendar.getInstance();
            fechaEntradaCalendario.setTime(fechaEntrada);
            fechaEntradaCalendario.set(Calendar.HOUR_OF_DAY, 0);
            fechaEntradaCalendario.set(Calendar.MINUTE, 0);
            fechaEntradaCalendario.set(Calendar.SECOND, 0);
            fechaEntradaCalendario.set(Calendar.MILLISECOND, 0);

            if (fechaFestiva.equals(fechaEntradaCalendario)) {
                esFestivo = "Es festivo";
                break;
            }
        }

        return esFestivo;

    }

}
