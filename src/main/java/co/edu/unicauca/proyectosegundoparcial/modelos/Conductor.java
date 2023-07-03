package co.edu.unicauca.proyectosegundoparcial.modelos;

import java.util.Calendar;

public class Conductor extends Persona {
    private EnumAreaTrabajo areaTrabaja;

    public Conductor(String noIdentificacion, String nombres, String apellidos, int anio, int mes, int dia, EnumAreaTrabajo areaTrabaja) {
        super(noIdentificacion, nombres, apellidos, anio, mes, dia);
        this.areaTrabaja = areaTrabaja;
    }

    public EnumAreaTrabajo getAreaTrabaja() {
        return areaTrabaja;
    }

    public void setAreaTrabaja(EnumAreaTrabajo areaTrabaja) {
        this.areaTrabaja = areaTrabaja;
    }
}
