package fechasfestivas.api.aplicacion.servicios;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fechasfestivas.api.aplicacion.servicios.FestivoServicio;

public class ServicioFechas {

    // diasQue deben pasar despues del 15 de marzo es decir domingo de ramos: var
    // dias
    public static Date getInicioSemanaSanta(int año) {

        int a = año % 19;
        int b = año % 4;
        int c = año % 7;
        int d = (19 * a + 24) % 30;

        int dias = d + (2 * b + 4 * c + 6 * d + 5) % 7;

        int dia = dias + 15;
        int mes = 3;
        return new Date(año - 1900, mes - 1, dia + 7);

    }

    public static Date agregarDias(Date fecha, int diasParaSumar) {

        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.DATE, diasParaSumar);
        return calendario.getTime();

    }

    public static Date getSiguienteLunes(Date fecha) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
        calendario.setTime(fecha);
        // SI DIA SEMANA COINCIDE NO SE MUEVE
        if (diaSemana != Calendar.MONDAY) {

            if (diaSemana > Calendar.MONDAY) {
                fecha = agregarDias(fecha, 9 - diaSemana);
            } else {
                fecha = agregarDias(fecha, 1);
            }

        }
        return fecha;
    }

   
    

}
