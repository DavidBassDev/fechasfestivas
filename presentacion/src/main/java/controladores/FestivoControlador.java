package fechasfestivas.api.presentacion.controladores;
import org.springframework.web.bind.annotation.*;


import org.springframework.beans.factory.annotation.Autowired;

import fechasfestivas.api.dominio.entidades.*;
import fechasfestivas.api.core.servicios.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/festivos")
public class FestivoControlador {
    @Autowired
    private IFestivoServicio servicio;
    


    @RequestMapping(value ="/listar", method=RequestMethod.GET)
    public List<Festivo> listar() {
        return servicio.listar();
    };

    @GetMapping("/obtener/{id}")
    public Festivo obtener(@PathVariable int id){
        return servicio.obtener(id);
        
    }

    @GetMapping("/buscar/{nombre}")
    public List<Festivo> buscar(@PathVariable String nombre){
        return servicio.buscar(nombre);
    }

    @PostMapping("/agregar")
    public Festivo agregar(@RequestBody Festivo nuevoFestivo) {
        
        return servicio.agregar(nuevoFestivo);
    };


    


}
