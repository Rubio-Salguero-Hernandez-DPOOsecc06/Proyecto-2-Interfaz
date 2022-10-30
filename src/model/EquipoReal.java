package model;

import java.io.Serializable;

public class EquipoReal implements Serializable {
    String nombre;

    public EquipoReal(String pNombreEquipo){
        this.nombre = pNombreEquipo;
    }
}
