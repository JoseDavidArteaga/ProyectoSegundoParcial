package co.edu.unicauca.proyectosegundoparcial.modelos;

public class Bahia {
    private int noBahia;
    private boolean estado;

    public Bahia(int noBahia, boolean estado) {
        this.noBahia = noBahia;
        this.estado = estado;
    }

    public int getNoBahia() {
        return noBahia;
    }

    public void setNoBahia(int noBahia) {
        this.noBahia = noBahia;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
