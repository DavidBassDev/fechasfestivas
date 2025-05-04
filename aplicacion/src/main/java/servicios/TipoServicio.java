package fechasfestivas.api.aplicacion.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fechasfestivas.api.dominio.entidades.*;
import fechasfestivas.api.core.servicios.*;
import fechasfestivas.api.infraestructura.repositorios.*;




 
@Service
public class TipoServicio  implements ITipoServicio{
    @Autowired
    private ITipoRepositorio repositorio;

    public List<Tipo> listar() {

        return repositorio.findAll();
    };
    
    public List<Tipo> buscar(String tipo){
        return repositorio.buscar(tipo);
    }
    
    public Tipo obtener(int id) {

        return repositorio.findById(id).isEmpty() ? null : repositorio.findById(id).get(); // pregunta si esta vacio, si
                                                                                           // es asi returna null, si no
                                                                                           // la funcion findbyId
    };

    

    public Tipo agregar(Tipo nuevoTipo) {
        nuevoTipo.setId(0);
        return repositorio.save(nuevoTipo);
    };

    public Tipo modificar(Tipo tipo) {
        if (repositorio.findById(tipo.getId()).isEmpty()) {
            return null;
        } else {
            return repositorio.save(tipo);
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
