package model;

public class JugadorReal extends Jugador {
    /**
     * Constructor
     * @param pNombre
     * @param pPosicion
     * @param pPrecioCompra
     * @param pEquipoJugador
     */
    public JugadorReal(String pNombre, Posicion pPosicion, double pPrecioCompra, Equipo pEquipoJugador){
        super(pNombre, pPosicion, pPrecioCompra, pEquipoJugador);
    }

    
    /** 
     * @return String
     */
    @Override
    public String getNombre() {
        return super.getNombre();
    }

    
    /** 
     * @return Posicion
     */
    @Override
    public Posicion getPosicionJugador() {
        return super.getPosicionJugador();
    }

    
    /** 
     * @return Double
     */
    @Override
    public Double getPrecioCompra() {
        return super.getPrecioCompra();
    }

    
    /** 
     * @return Double
     */
    @Override
    public Double getPrecioVenta() {
        return super.getPrecioVenta();
    }

    

    
}
