package fechasfestivas.api.infraestructura.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import fechasfestivas.api.dominio.entidades.*;
import java.util.List;


//aca le damos que es tipo Festivo, llave primaria es Integer
@Repository
public interface IFestivoRepositorio extends JpaRepository <Festivo,Integer>{

    @Query("SELECT f FROM Festivo f WHERE f.nombre LIKE '%' || ?1 || '%'")
    public List<Festivo> buscar(String nombre);

    

}
