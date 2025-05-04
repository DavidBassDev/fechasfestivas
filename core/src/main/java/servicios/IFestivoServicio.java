package fechasfestivas.api.core.servicios;

import fechasfestivas.api.dominio.entidades.Festivo;

import java.util.List;

public interface IFestivoServicio {

    public List<Festivo> listar();

    

    // aca iria el metodo si consultan una fecha, consultar si es festivo o no

}
