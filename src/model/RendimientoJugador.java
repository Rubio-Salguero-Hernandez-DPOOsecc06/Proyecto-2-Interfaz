package model;

import java.io.Serializable;

public class RendimientoJugador implements Serializable {
    private int minutosJugados, minutoEntrada, minutoSalida, golesAnotados, 
    penaltisAnotados, autogoles, asistencias, penaltisErrados, golesRecibidos, penaltisDetenidos, tarjetasAmarillas, tarjetasRojas;
    private JugadorReal jugador;

    /**
     * Constructor
     * @param pMinutosJugados
     * @param pMinutoEntrada
     * @param pMinutoSalida
     * @param pGolesAnotados
     * @param pPenaltisAnotados
     * @param pAutogoles
     * @param pAsistencias
     * @param pPenaltisErrados
     * @param pTarjetasAmarillas
     * @param pTarjetasRojas
     * @param pGolesRecibidos
     * @param pPenaltisDetenidos
     * @param pJugador
     */
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
     * Retorna la cantidad de asistencias
     * @return
     */
    public int getAsistencias() {
        return asistencias;
    }
    /**
     * Retorna la cantidad de autogoles
     * @return
     */
    public int getAutogoles() {
        return autogoles;
    }
    /**
     * Retorna la cantidad de goles anotados
     * @return
     */
    public int getGolesAnotados() {
        return golesAnotados;
    }
    /**
     * Retorna el minuto de entrada del jugador
     * @return
     */
    public int getMinutoEntrada() {
        return minutoEntrada;
    }
    /**
     * Retorna el minuto en el que salio el jugador en caso de que haya sido sustitutido
     * @return
     */
    public int getMinutoSalida() {
        return minutoSalida;
    }
    /**
     * Retorna la cantidad de minutos jugados 
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
     * Retorna la cantidad de penaltis errados
     * @return
     */
    public int getPenaltisErrados() {
        return penaltisErrados;
    }
    /**
     * Retorna la cantidad de tarjetas amarillas
     * @return
     */
    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }
    /**
     * Retorna la cantidad de tarjetas rojas
     * @return
     */
    public int getTarjetasRojas() {
        return tarjetasRojas;
    }
    /**
     * Retorna la cantidad de goles recibidos
     * @return
     */
    public int getGolesRecibidos() {
        return golesRecibidos;
    }
    /**
     * Retorna la cantidad de penaltis detenidos
     * @return
     */
    public int getPenaltisDetenidos() {
        return penaltisDetenidos;
    }
    /**
     * Retorna el jugador asociado al rendimiento
     * @return
     */
    public JugadorReal getJugador() {
        return jugador;
    }
}
