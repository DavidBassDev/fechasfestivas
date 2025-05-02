package fechasfestivas.api.aplicacion.servicios;
import fechasfestivas.api.dominio.*;
import fechasfestivas.api.core.servicios;
import fechasfestivas.api.infraestructura.repositorios.ITipoRepositorio;
import org.springframework.stereotype.Service;

import entidades.Tipo;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Service
public class TipoServicio implements ITipoRepositorio{

    @Autowired
    private ITipoRepositorio repositorio;

    public List<Tipo> listar() {

        return repositorio.findAll();
    }
 
    public Tipo obtener(int id) {

        return repositorio.findById(id).isEmpty()? null : repositorio.findById(id).get(); //pregunta si esta vacio, si es asi returna null, si no la funcion findbyId
    }
 
    public List<Tipo> buscar(String nombreTipo) {

        return repositorio.buscar(nombreTipo);
    }
 
    public Tipo agregar(Tipo tipoNuevo) {
        tipoNuevo.setId(0);
        return repositorio.add(tipoNuevo);
    }
 
    public Tipo modificar(Tipo tipo) {
        if(
            repositorio.findById(tipo.getId()).isEmpty() 
        ) {return null;} else {
        return repositorio.save(tipo);}

    }
 
    public boolean eliminar(int id) {
        try {
            repositorio.deleteById(id);
            return true;
               }  catch (Exception ex) {return false;}
    }

}
