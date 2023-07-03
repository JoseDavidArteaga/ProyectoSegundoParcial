package co.edu.unicauca.proyectosegundoparcial.modelos;

import java.util.LinkedList;

public class Parqueadero {
    //Atributos
    private String nombre;
    private LinkedList<Bahia> bahias;
    private LinkedList<Entrada> entradas;

    //Constructor
    public Parqueadero(String nombre) {
        this.nombre = nombre;
        this.bahias = new LinkedList();
        this.entradas = new LinkedList();
    }

    //Set y get
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void registrarBahia(int noBahia, boolean estado){
        Bahia objBahia = new Bahia(noBahia, estado);
        this.bahias.add(objBahia);    
    }
    
    public Bahia getBahias(int nroBahia) {
        return bahias.get(nroBahia);
    }
    
    public void agregarEntrada(Entrada objEntrada){
        this.entradas.add(objEntrada);
    }
    
    public LinkedList<Entrada> getEntradas(){
        return this.entradas;
    }

    
    //Otros metodos
    
    public Bahia consultarBahia(int noBahia) {
        Bahia objBahiaEncontrada = null;
        boolean bandera = false;
        for (int i = 0; i < bahias.size() && bandera == false; i++) {
            Bahia objBahiaObtenida = this.bahias.get(i);
            if (objBahiaObtenida.getNoBahia() == noBahia && objBahiaObtenida.getEstado() == false) {
                objBahiaEncontrada = objBahiaObtenida;
                objBahiaEncontrada.setEstado(true);
                bandera = true;
                break;
            }
        }
        return objBahiaEncontrada;
    }
    
    public Entrada consultarEntradaVehiculo(String placa) throws VehiculoNoEncontradoException {
        Entrada objEntradaEncontrada = null;
        boolean bandera = false;
        for (int i = 0; i < entradas.size() && bandera == false; i++) {
            Entrada objEntradaObtenida = this.entradas.get(i);
            if (objEntradaObtenida.getObjVehiculo().getPlaca().equals(placa)) {
                objEntradaEncontrada = objEntradaObtenida;
                bandera = true;
            }
        }  
        if (bandera == false){
            VehiculoNoEncontradoException objExcepcionGenerada = new VehiculoNoEncontradoException("El vehiculo no se encuentra al interior del parqueadero");
            throw objExcepcionGenerada;
        }
        return objEntradaEncontrada;
    }
    
    public int consultarCantidadBahiasOcupadas() {
        int bahiasOcupadas = 0; 
        for (int i = 0; i < bahias.size(); i++) {
            Bahia objBahiaObtenida = this.bahias.get(i);
            if (objBahiaObtenida.getEstado() == true) {
                bahiasOcupadas++;
            }
        }
        return bahiasOcupadas;
    }
    
    //public void listarEntradas(){//LinkedList<Entrada>
    //  
    //} 
}
