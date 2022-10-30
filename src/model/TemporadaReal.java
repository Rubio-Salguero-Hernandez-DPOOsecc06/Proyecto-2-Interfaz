package model;

import java.io.Serializable;
import java.util.ArrayList;

public class TemporadaReal implements Serializable {
    private int numeroTemporada;
    ArrayList<EquipoReal> equiposDeTemporada = new ArrayList<>(); 

    public TemporadaReal(){
    }

    /**
     * Agrega un equipo a la lista de equipos de la temporada
     * @param pNuevoEquipo
     */
    public void agregarEquipo(EquipoReal pNuevoEquipo){
        equiposDeTemporada.add(pNuevoEquipo);
    }
    /**
     * retorna el numero de la temporada
     * @return
     */
    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    /**
     * agrega un numero de temporada
     * @param numeroTemporada
     */
    public void setNumeroTemporada(int numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }
    
}

