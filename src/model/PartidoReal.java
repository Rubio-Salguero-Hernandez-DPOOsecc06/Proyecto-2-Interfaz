package model;

import java.io.Serializable;

public class PartidoReal implements Serializable {

    private EquipoReal EquipoLocal, EquipoVisitante;
    private String dia, hora;
    /**
     * Constructor
     * @param pLocal
     * @param pVisitante
     * @param pDia
     * @param pHora
     */
    public PartidoReal(EquipoReal pLocal, EquipoReal pVisitante, String pDia, String pHora){
        this.EquipoLocal = pLocal;
        this.EquipoVisitante = pVisitante;
        this.dia = pDia;
        this.hora = pHora;
    }
    /**
     * Retorna el dia del partido
     * @return
     */
    public String getDia() {
        return dia;
    }
    /**
     * Retorna la hora del partido
     * @return
     */
    public String getHora() {
        return hora;
    }
    /**
     * Retorna el equipo que juega como local
     * @return
     */
    public EquipoReal getEquipoLocal() {
        return EquipoLocal;
    }
    /**
     * Retorna el equipo que juega como visitante
     * @return
     */
    public EquipoReal getEquipoVisitante() {
        return EquipoVisitante;
    }
}   

