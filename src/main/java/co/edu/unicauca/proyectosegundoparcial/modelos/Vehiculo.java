package co.edu.unicauca.proyectosegundoparcial.modelos;

public class Vehiculo {
    private String placa;
    private EnumTipoVehiculo tipo;

    public Vehiculo(String placa, EnumTipoVehiculo tipo) {
        this.placa = placa;
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public EnumTipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoVehiculo tipo) {
        this.tipo = tipo;
    }
}
