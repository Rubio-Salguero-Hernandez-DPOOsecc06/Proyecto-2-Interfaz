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

    public int getAsistencias() {
        return asistencias;
    }

    public int getAutogoles() {
        return autogoles;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public int getMinutoEntrada() {
        return minutoEntrada;
    }

    public int getMinutoSalida() {
        return minutoSalida;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public int getPenaltisAnotados() {
        return penaltisAnotados;
    }

    public int getPenaltisErrados() {
        return penaltisErrados;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    public int getGolesRecibidos() {
        return golesRecibidos;
    }

    public int getPenaltisDetenidos() {
        return penaltisDetenidos;
    }

    public JugadorReal getJugador() {
        return jugador;
    }
}
