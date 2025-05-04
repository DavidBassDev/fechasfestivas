package fechasfestivas.api.core.servicios;

import fechasfestivas.api.dominio.entidades.Festivo;

import java.util.List;

public interface IFestivoServicio {

    public List<Festivo> listar();
    public List<Festivo> buscar(String nombre);
    public Festivo obtener(int id);
    public Festivo agregar(Festivo nuevoFestivo);

    

    // aca iria el metodo si consultan una fecha, consultar si es festivo o no

}
