package fechasfestivas.api.aplicacion.servicios;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

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
    };

    public Festivo obtener(int id) {

        return repositorio.findById(id).isEmpty() ? null : repositorio.findById(id).get(); // pregunta si esta vacio, si
                                                                                           // es asi returna null, si no
                                                                                           // la funcion findbyId
    };

    public List<Festivo> buscar(String nombre) {

        return repositorio.buscar(nombre);
    };

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

    // aca iria el metodo si consultan una fecha, consultar si es festivo o no
    // validar tambien en el core, ifestivoservicio

}
