package model;

public class JugadorFantasiaDefensivo extends JugadorFantasia {
    private int golesRecibidos;
    public JugadorFantasiaDefensivo(String pNombre, Posicion pPosicion, double pPrecioCompra, Equipo pEquipoJugador){
        super(pNombre, pPosicion, pPrecioCompra, pEquipoJugador);
    }
    /**
     * Retorna el total de goles recibidos
     * @return
     */
    public int getGolesRecibidos() {
        return golesRecibidos;
    }
}
