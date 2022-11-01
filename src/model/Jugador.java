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
    public Jugador(String pNombre, Posicion pPosicion, double pPrecioCompra, Equipo pEquipoJugador){
        this.nombre = pNombre;
        this.precioCompra = pPrecioCompra;
        this.precioVenta = pPrecioCompra * 0.97;
        this.equipoJugador = pEquipoJugador;
        this.posicionJugador = pPosicion;
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
