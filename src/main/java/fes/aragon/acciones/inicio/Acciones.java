package fes.aragon.acciones.inicio;

public class Acciones {
    private char tipo;
    private int cantidadAcciones;
    private int precioAcciones;
    private int diaTransaccion;

    public Acciones(char tipo, int cantidadAcciones, int precioAcciones, int diaTransaccion) {
        this.tipo = tipo;
        this.cantidadAcciones = cantidadAcciones;
        this.precioAcciones = precioAcciones;
        this.diaTransaccion = diaTransaccion;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getCantidadAcciones() {
        return cantidadAcciones;
    }

    public void setCantidadAcciones(int cantidadAcciones) {
        this.cantidadAcciones = cantidadAcciones;
    }

    public int getPrecioAcciones() {
        return precioAcciones;
    }

    public void setPrecioAcciones(int precioAcciones) {
        this.precioAcciones = precioAcciones;
    }

    public int getDiaTransaccion() {
        return diaTransaccion;
    }

    public void setDiaTransaccion(int diaTransaccion) {
        this.diaTransaccion = diaTransaccion;
    }
}
