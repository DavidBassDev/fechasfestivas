package fechasfestivas.api.aplicacion.servicios;

import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;
import fechasfestivas.api.aplicacion.servicios.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import fechasfestivas.api.dominio.entidades.*;
import fechasfestivas.api.core.servicios.*;
import fechasfestivas.api.infraestructura.repositorios.*;





@Service
public class FestivoServicio implements IFestivoServicio {

    @Autowired
    private IFestivoRepositorio repositorio;

     public List<Festivo> listar(){
        return repositorio.findAll();
    }
    @Override
    public List<Festivo> buscar(String nombre){
        return repositorio.buscar(nombre);
    }
    @Override
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

   //se requiere metodo de recibir el año,devuelve una lista construyendo cada festivo de la listaFestivos, segun el tipo de festivo
   public List<Date> listaFestivos (int año) {
    Date fecha;
    ServicioFechas servicio = new ServicioFechas();
     List<Festivo> listaFestivos = listar();
     List<Date> nuevaLista = new ArrayList<>();

     for (Festivo festivo : listaFestivos) {
      int tipoFestivo = festivo.getTipo().getId();
    switch (tipoFestivo){
    case 1:
    //solo agrega el año y a la lista
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

    fecha= servicio.getInicioSemanaSanta(año-1900);

    nuevaLista.add(fecha);
    break;

    case 4: 
    fecha = new Date(año - 1900, festivo.getMes() - 1, festivo.getDia());
    fecha = servicio.getInicioSemanaSanta(año-1900);
    fecha = servicio.getSiguienteLunes(fecha);
    nuevaLista.add(fecha);
    break;
    }
    
    
}
  return nuevaLista;

   }

}
