package fechasfestivas.api.infraestructura.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.Query;
import fechasfestivas.api.dominio.entidades.*;
import java.util.List;

@Repository
public interface ITipoRepositorio extends JpaRepository <Tipo, Integer> {


    @Query("SELECT t FROM Tipo t WHERE t.tipo LIKE '%' || ?1 || '%'")
    public List<Tipo> buscar(String tipo);




    

}
