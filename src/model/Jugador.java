package model;

import java.io.Serializable;

public abstract class Jugador implements Serializable {
    String nombre;
    Posicion posicionJugador;
    Equipo equipoJugador;
    Double precioCompra, precioVenta;
    /**
     * Crea una instancia de un jugador
     * @param pNombre
     * @param pPosicion
     * @param pPrecioCompra
     * @param pEquipoJugador
     */
    public Jugador(String pNombre, String pPosicion, double pPrecioCompra, Equipo pEquipoJugador){
        this.nombre = pNombre;
        this.precioCompra = pPrecioCompra;
        this.precioVenta = pPrecioCompra * 0.97;
        this.equipoJugador = pEquipoJugador;
        switch (pPosicion) {
            case "arquero":
                this.posicionJugador = Posicion.ARQUERO;
                break;
            case "delantero":
                this.posicionJugador = Posicion.DELANTERO;
            case "medio":
                this.posicionJugador = Posicion.MEDIO;
            case "defensa":
                this.posicionJugador = Posicion.DEFENSA;
            default:
                break;
        }
    }
    /**
     * retorna el nombre del jugador
     * @return
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * retorna la posicion del jugador
     * @return
     */
    public Posicion getPosicionJugador() {
        return posicionJugador;
    }
    /**
     * retorna el precio de compra del jugador
     * @return
     */
    public Double getPrecioCompra() {
        return precioCompra;
    }
    /**
     * retorna el precio de la venta del jugador
     * es el 97% del precio de compra
     * @return
     */
    public Double getPrecioVenta() {
        return precioVenta;
    }
}
