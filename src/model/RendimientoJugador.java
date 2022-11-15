package model;

import java.io.Serializable;

public class RendimientoJugador implements Serializable {
    private int minutosJugados, minutoEntrada, minutoSalida, golesAnotados, 
    penaltisAnotados, autogoles, asistencias, penaltisErrados, golesRecibidos, penaltisDetenidos, tarjetasAmarillas, tarjetasRojas;
    private JugadorReal jugador;

    public RendimientoJugador(int pMinutosJugados, int pMinutoEntrada, int pMinutoSalida,
    int pGolesAnotados, int pPenaltisAnotados, int pAutogoles, int pAsistencias, int pPenaltisErrados,
    int pTarjetasAmarillas, int pTarjetasRojas, int pGolesRecibidos,int pPenaltisDetenidos, JugadorReal pJugador){
        this.minutosJugados = pMinutosJugados;
        this.minutoEntrada = pMinutoEntrada;
        this.minutoSalida = pMinutoSalida;
        this.golesAnotados = pGolesAnotados;
        this.penaltisAnotados = pPenaltisAnotados;
        this.autogoles = pAutogoles;
        this.asistencias = pAsistencias;
        this.penaltisErrados = pPenaltisErrados;
        this.golesRecibidos = pGolesRecibidos;
        this.penaltisDetenidos = pPenaltisDetenidos;
        this.tarjetasAmarillas = pTarjetasAmarillas;
        this.tarjetasRojas = pTarjetasRojas;
        this.jugador = pJugador;
    }

    
    /** 
     * @return int
     */
    public int getAsistencias() {
        return asistencias;
    }

    
    /** 
     * @return int
     */
    public int getAutogoles() {
        return autogoles;
    }

    
    /** 
     * @return int
     */
    public int getGolesAnotados() {
        return golesAnotados;
    }

    
    /** 
     * @return int
     */
    public int getMinutoEntrada() {
        return minutoEntrada;
    }

    
    /** 
     * @return int
     */
    public int getMinutoSalida() {
        return minutoSalida;
    }

    
    /** 
     * @return int
     */
    public int getMinutosJugados() {
        return minutosJugados;
    }

    
    /** 
     * @return int
     */
    public int getPenaltisAnotados() {
        return penaltisAnotados;
    }

    
    /** 
     * @return int
     */
    public int getPenaltisErrados() {
        return penaltisErrados;
    }

    
    /** 
     * @return int
     */
    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    
    /** 
     * @return int
     */
    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    
    /** 
     * @return int
     */
    public int getGolesRecibidos() {
        return golesRecibidos;
    }

    
    /** 
     * @return int
     */
    public int getPenaltisDetenidos() {
        return penaltisDetenidos;
    }

    
    /** 
     * @return JugadorReal
     */
    public JugadorReal getJugador() {
        return jugador;
    }
}
