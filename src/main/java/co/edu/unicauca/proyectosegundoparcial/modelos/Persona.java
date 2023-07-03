package co.edu.unicauca.proyectosegundoparcial.modelos;
import java.util.Calendar;

public class Persona {
    private String noIdentificacion;
    private String nombres;
    private String apellidos;
    private Calendar fechaNac;

    public Persona(String noIdentificacion, String nombres, String apellidos, int anio, int mes, int dia) {
        this.noIdentificacion = noIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        fechaNac =  Calendar.getInstance();    
        fechaNac.set(anio, mes, dia); 
    }

    public Calendar getFechaNac() {
        return fechaNac;
    }
    
    public String getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(String noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
