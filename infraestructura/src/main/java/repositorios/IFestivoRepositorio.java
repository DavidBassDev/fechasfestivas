package fechasfestivas.api.infraestructura.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import fechasfestivas.api.dominio.entidades.*;
import java.util.List;


//aca le damos que es tipo Festivo, llave primaria es Integer
public interface IFestivoRepositorio extends JpaRepository <Festivo,Integer>{

    @Query("SELECT f FROM FESTIVO f  WHERE f.nombre LIKE '%' || ?1 || '%'")
    public List<Festivo> buscar (String nombreFestivo);

    //LISTA DE FESTIVOS, SEGUN EL TIPO
    @Query("SELECT f FROM FESTIVO f  JOIN TIPO t ON f.TIPO=t WHERE t.id=?1")
    public List<Festivo> buscar (int idTipo);

}
