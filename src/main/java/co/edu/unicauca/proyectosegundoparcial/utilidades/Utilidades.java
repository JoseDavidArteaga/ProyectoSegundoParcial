package co.edu.unicauca.proyectosegundoparcial.utilidades;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Utilidades {
    public static ChronoPeriod calcularEdadEnDiasMeseAnios(Calendar fechaNac)
    {
        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        ChronoLocalDate fechaActual = ChronoLocalDate.from(formatter.parse(hoy.getDayOfMonth()+"/"+hoy.getMonthValue()+"/"+hoy.getYear()));
        ChronoLocalDate fechaNacimiento = ChronoLocalDate.from(formatter.parse(fechaNac.get(Calendar.DAY_OF_MONTH)+"/"+fechaNac.get(Calendar.MONTH)+"/"+fechaNac.get(Calendar.YEAR)));
        ChronoPeriod periodo = ChronoPeriod.between(fechaNacimiento,fechaActual);        
        
        return periodo;
    }
}
