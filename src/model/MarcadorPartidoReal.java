package model;

import java.io.Serializable;
import java.util.ArrayList;

public class MarcadorPartidoReal implements Serializable {
    int golesLocal, golesVisitante;
    ArrayList<RendimientoJugador> rendimientoLocal = new ArrayList<>(), 
                                  rendimientoVisitante = new ArrayList<>();;


    public MarcadorPartidoReal(){
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void agregarGolLocal(int pGol){
        this.golesLocal += pGol;
    }

    public void agregarGolVisitante(int pGol){
        this.golesVisitante += pGol;
    }

    public void agregarRendimientoLocal(RendimientoJugador pRendimiento){
        this.rendimientoLocal.add(pRendimiento);
    }

    public void agregarRendimientoVisitante(RendimientoJugador pRendimiento){
        this.rendimientoVisitante.add(pRendimiento);
    }

}
