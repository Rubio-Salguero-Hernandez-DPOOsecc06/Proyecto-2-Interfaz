package model;

public class JugadorFantasia extends JugadorReal {

    private int minutosJugados, golesAnotados, penaltisAnotados,
    autogoles, asistencias, penaltisErrados, tarjetasAmarillas, tarjetasRojas;

    /**
     * Constructor
     * @param pNombre
     * @param pPosicion
     * @param pPrecioCompra
     * @param pEquipoJugador
     */
    public JugadorFantasia(String pNombre, Posicion pPosicion, double pPrecioCompra, Equipo pEquipoJugador){
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
    /**
     * Retorna la cantidad total de asistencias
     * @return
     */
    public int getAsistencias() {
        return asistencias;
    }
    /**
     * Retorna la cantidad total de autogoles
     * @return
     */
    public int getAutogoles() {
        return autogoles;
    }
    /**
     * Retorna la cantidad total de goles anotados
     * @return
     */
    public int getGolesAnotados() {
        return golesAnotados;
    }
    /**
     * Retorna la cantidad total de minutos jugados
     * @return
     */
    public int getMinutosJugados() {
        return minutosJugados;
    }
    /**
     * Retorna la cantidad de penaltis anotados
     * @return
     */
    public int getPenaltisAnotados() {
        return penaltisAnotados;
    }
    /**
     * retorna la cantidad total de penaltis errados
     * @return
     */
    public int getPenaltisErrados() {
        return penaltisErrados;
    }
    /**
     * Retorna la cantidad total de tarjetas Amarillas
     * @return
     */
    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }
    /**
     * Retorna la cantidad total de tarjetas Rojas
     * @return
     */
    public int getTarjetasRojas() {
        return tarjetasRojas;
    }
}
