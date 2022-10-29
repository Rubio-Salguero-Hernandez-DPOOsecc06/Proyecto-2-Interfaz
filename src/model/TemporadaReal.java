package model;

import java.util.ArrayList;

public class TemporadaReal {
    int numeroTemporada;
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
    
}

