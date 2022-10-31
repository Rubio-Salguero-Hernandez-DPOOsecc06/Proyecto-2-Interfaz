package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Fecha implements Serializable{
    int numeroFecha;
    ArrayList<PartidoReal> cronogramaPartidosFecha = new ArrayList<>();

    /**
     * Constructor
     * @param pNumeroFecha
     */
    public Fecha(int pNumeroFecha){
        this.numeroFecha = pNumeroFecha;
    }
    /**
     * retorna el numero de la fecha
     * @return
     */
    public int getNumeroFecha() {
        return numeroFecha;
    }
    /**
     * Agrega un nuevo partido al cronograma de la fecha
     * @param pNuevoPartido
     */
    public void agregarPartido(PartidoReal pNuevoPartido){
        this.cronogramaPartidosFecha.add(pNuevoPartido);
    }
}
