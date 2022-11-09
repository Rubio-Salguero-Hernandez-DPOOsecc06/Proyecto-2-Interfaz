package model;

import java.util.ArrayList;

public class TemporadaFantasia extends Temporada{
    ArrayList<EquipoFantasia> equiposTemporada = new ArrayList<>();

    public TemporadaFantasia(){
    }

    @Override
    public int getNumeroTemporada() {
        return this.numeroTemporada;
    }

    @Override
    public void setNumeroTemporada(int pNumeroTemporada) {
        this.numeroTemporada = pNumeroTemporada;
    }
    
    public ArrayList<EquipoFantasia> getEquiposTemporada() {
        return equiposTemporada;
    }

    public void agregarEquipo(EquipoFantasia pEquipo){
        this.equiposTemporada.add(pEquipo);
    }
}
