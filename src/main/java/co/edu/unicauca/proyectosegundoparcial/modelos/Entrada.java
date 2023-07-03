package co.edu.unicauca.proyectosegundoparcial.modelos;

import java.util.Calendar;

public class Entrada {
    private Calendar fechaEntrada;
    private int hora;
    private Bahia objBahia;
    private Vehiculo objVehiculo;
    private Conductor objConductor;

    public Entrada(int hora, int anio, int mes, int dia, Bahia objBahia, Vehiculo objVehiculo, Conductor objConductor) {
        fechaEntrada =  Calendar.getInstance();   
        fechaEntrada.set(anio, mes, dia); 
        this.hora = hora;
        this.objBahia = objBahia;
        this.objVehiculo = objVehiculo;
        this.objConductor = objConductor;
    }
    
    public Calendar getFechaEntrada() {
        return fechaEntrada;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public Bahia getObjBahia() {
        return objBahia;
    }

    public void setObjBahia(Bahia objBahia) {
        this.objBahia = objBahia;
    }

    public Vehiculo getObjVehiculo() {
        return objVehiculo;
    }

    public void setObjVehiculo(Vehiculo objVehiculo) {
        this.objVehiculo = objVehiculo;
    }

    public Conductor getObjConductor() {
        return objConductor;
    }

    public void setObjConductor(Conductor objConductor) {
        this.objConductor = objConductor;
    }
}
