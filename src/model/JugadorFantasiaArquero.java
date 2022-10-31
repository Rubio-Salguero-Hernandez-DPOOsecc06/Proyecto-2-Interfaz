package model;

public class JugadorFantasiaArquero extends JugadorFantasiaDefensivo{

    private int penaltisDetenidos;
    public JugadorFantasiaArquero (String pNombre, Posicion pPosicion, double pPrecioCompra, Equipo pEquipoJugador){
        super(pNombre, pPosicion, pPrecioCompra, pEquipoJugador);
    }
    /**
     * Retorna la cantidad de penaltis detenidos
     * @return
     */
    public int getPenaltisDetenidos() {
        return penaltisDetenidos;
    }
    
}
