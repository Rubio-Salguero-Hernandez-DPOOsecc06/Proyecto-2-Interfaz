package model;

import java.io.Serializable;

public class RendimientoJugador implements Serializable {
    private int minutosJugados, minutoEntrada, minutoSalida, golesAnotados, 
    penaltisAnotados, autogoles, asistencias, penaltisErrados, golesRecibidos, 
    penaltisDetenidos, tarjetasAmarillas, tarjetasRojas;

    public RendimientoJugador(int pMinutosJugados, int pMinutoEntrada, int pMinutoSalida,
    int pGolesAnotados, int pPenaltisAnotados, int pAutogoles, int pAsistencias, int pPenaltisErrados,
    int pGolesRecibidos, int pPenaltisDetenidos, int pTarjetasAmarillas, int pTarjetasRojas){
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

    public int getGolesRecibidos() {
        return golesRecibidos;
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

    public int getPenaltisDetenidos() {
        return penaltisDetenidos;
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
}
