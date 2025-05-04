package fechasfestivas.api.core.servicios;
import fechasfestivas.api.dominio.entidades.Tipo;

import java.util.List;


public interface ITipoServicio {
    public List<Tipo> listar();

    public List<Tipo> buscar(String tipo);
 

    

}
