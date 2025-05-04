package fechasfestivas.api.presentacion.controladores;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import fechasfestivas.api.dominio.entidades.*;

import fechasfestivas.api.core.servicios.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos")
public class TipoControlador {
    @Autowired
    ITipoServicio servicio;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Tipo> listar() {
        return servicio.listar();
    };

    @GetMapping("/obtener/{id}")
    public Tipo obtener(@PathVariable int id) {
        return servicio.obtener(id);

    }

    @GetMapping("/buscar/{nombre}")
    public List<Tipo> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @PostMapping("/agregar")
    public Tipo agregar(@RequestBody Tipo nuevoTipo) {

        return servicio.agregar(nuevoTipo);
    };

}
