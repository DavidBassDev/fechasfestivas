package fechasfestivas.api.core.servicios;

import fechasfestivas.api.dominio.entidades.Festivo;

import java.util.List;

public interface IFestivoServicio {

    public List<Festivo> listar();

    public Festivo obtener(int id);

    public List<Festivo> buscar(String nombre);

    public Festivo agregar(Festivo nuevoFestivo);

    public Festivo modificar(Festivo festivo);

    public boolean eliminar(int id);

    // aca iria el metodo si consultan una fecha, consultar si es festivo o no

}
