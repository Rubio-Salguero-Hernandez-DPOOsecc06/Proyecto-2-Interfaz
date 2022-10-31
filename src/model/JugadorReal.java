package model;

public class JugadorReal extends Jugador {
    
    public JugadorReal(String pNombre, String pPosicion, double pPrecioCompra, Equipo pEquipoJugador){
        super(pNombre, pPosicion, pPrecioCompra, pEquipoJugador);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public Posicion getPosicionJugador() {
        return super.getPosicionJugador();
    }

    @Override
    public Double getPrecioCompra() {
        return super.getPrecioCompra();
    }

    @Override
    public Double getPrecioVenta() {
        return super.getPrecioVenta();
    }


    
}
