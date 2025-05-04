package fechasfestivas.api.presentacion.controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fechasfestivas.api.dominio.entidades.*;
import fechasfestivas.api.core.servicios.*;
import java.util.List;


@RestController
@RequestMapping("/api/festivos")
public class FestivoControlador {
    @Autowired
    private IFestivoServicio servicio;
    


    @RequestMapping(value ="/listar", method=RequestMethod.GET)
    public List<Festivo> listar() {
        return servicio.listar();
    };


}
