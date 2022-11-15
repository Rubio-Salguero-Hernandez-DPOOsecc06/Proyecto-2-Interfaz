package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Jugador implements Serializable {
    String nombre;
    Posicion posicionJugador;
    Equipo equipoJugador;
    Double precioCompra, precioVenta;
    ArrayList<RendimientoJugador> rendimientos = new ArrayList<>();
    
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

    
    /** 
     * @return ArrayList<RendimientoJugador>
     */
    public ArrayList<RendimientoJugador> getRendimientos() {
        return rendimientos;
    }

    
    /** 
     * @param pRendimiento
     */
    public void agregarRendimiento(RendimientoJugador pRendimiento){
        rendimientos.add(pRendimiento);
    }
}
