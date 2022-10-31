package model;

import java.io.Serializable;

public abstract class Equipo implements Serializable {
    String nombreEquipo;

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
