package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Equipo implements Serializable {
    String nombreEquipo;

    /**
     * Constructor del equipo
     * @param pNombreEquipo
     */
    public Equipo(String pNombreEquipo){
        this.nombreEquipo = pNombreEquipo;
    }

    /**
     * Retorna el nombre del equipo
     * @return
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

}
