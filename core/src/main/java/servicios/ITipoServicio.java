package fechasfestivas.api.core.servicios;
import fechasfestivas.api.dominio.entidades.Tipo;

import java.util.List;


public interface ITipoServicio {
    public List<Tipo> listar();
 
    public Tipo obtener(int id);
 
    public List<Tipo> buscar(String nombreTipo);
 
    public Tipo agregar(Tipo tipoNuevo);
 
    public Tipo modificar(Tipo tipo);
 
    public boolean eliminar(int id);

    

}
