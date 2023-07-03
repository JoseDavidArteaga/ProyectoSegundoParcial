package co.edu.unicauca.proyectosegundoparcial.modelos;

public class Vigilante extends Persona {
    private EnumZona zonaTrabajo;

    public Vigilante(String noIdentificacion, String nombres, String apellidos, int anio, int mes, int dia, EnumZona zonaTrabajo ) {
        super(noIdentificacion, nombres, apellidos, anio, mes, dia);
        this.zonaTrabajo = zonaTrabajo;
    }

    public EnumZona getZonaTrabajo() {
        return zonaTrabajo;
    }

    public void setZonaTrabajo(EnumZona zonaTrabajo) {
        this.zonaTrabajo = zonaTrabajo;
    }
    
}
