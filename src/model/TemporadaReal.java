package model;

import java.io.Serializable;
import java.util.ArrayList;

public class TemporadaReal implements Serializable, Temporada {
    private int numeroTemporada;
    private ArrayList<EquipoReal> equiposDeTemporada = new ArrayList<>(); 

    public TemporadaReal(){
    }

    @Override
    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    @Override
    public void setNumeroTemporada(int pNumeroTemporada) {
        this.numeroTemporada = pNumeroTemporada;
    }

    public void agregarEquipo(EquipoReal pNuevoEquipo){
        this.equiposDeTemporada.add(pNuevoEquipo);
    }

    public EquipoReal buscarEquipo(String pNombreEquipo){
        EquipoReal equipoBuscado = null;
        for(EquipoReal equipo: equiposDeTemporada){
            if(equipo.getNombreEquipo().equals(pNombreEquipo)){
                equipoBuscado = equipo;
            }
        }
        return equipoBuscado;
    }

    
}

