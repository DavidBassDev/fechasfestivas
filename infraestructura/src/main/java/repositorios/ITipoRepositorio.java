package fechasfestivas.api.infraestructura.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import fechasfestivas.api.dominio.entidades.*;
import java.util.List;


public interface ITipoRepositorio extends JpaRepository <Tipo, Integer> {


    //LISTA POR NOMBRE DE TIPO
    @Query("SELECT t FROM TIPO t  WHERE t.tipo LIKE '%' || ?1 || '%'")
    public List<Tipo> buscar (String nombreTipo);


    

}
