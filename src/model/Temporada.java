package model;

import java.io.Serializable;

public abstract class Temporada implements Serializable{

    int numeroTemporada;
    /**
     * retorna el numero de temporada
     * @return
     */
    public int getNumeroTemporada(){
        return numeroTemporada;
    }
    /**
     * Establece el numero de la temporada
     * @param pNumeroTemporada
     */
    public void setNumeroTemporada(int pNumeroTemporada){
        setNumeroTemporada(pNumeroTemporada);
    }
}
