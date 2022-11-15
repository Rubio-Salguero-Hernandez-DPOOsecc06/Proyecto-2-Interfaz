package model;

import java.io.Serializable;

public abstract class Temporada implements Serializable{

    int numeroTemporada;

    
    /** 
     * @return int
     */
    public int getNumeroTemporada(){
        return numeroTemporada;
    }
    
    /** 
     * @param pNumeroTemporada
     */
    public void setNumeroTemporada(int pNumeroTemporada){
        setNumeroTemporada(pNumeroTemporada);
    }
}
