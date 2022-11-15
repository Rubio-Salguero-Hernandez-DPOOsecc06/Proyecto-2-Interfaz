package model;

import java.io.Serializable;
import java.util.ArrayList;


public class MarcadorPartidoReal implements Serializable {
    private int golesLocal, golesVisitante;
    private ArrayList<RendimientoJugador> rendimientoLocal = new ArrayList<>(), 
                                  rendimientoVisitante = new ArrayList<>();
    private EquipoReal ganador = null;


    public MarcadorPartidoReal(){
    }

    
    /** 
     * @param pGanador
     */
    public void setGanador(EquipoReal pGanador) {
        this.ganador = pGanador;
    }

    
    /** 
     * @return EquipoReal
     */
    public EquipoReal getGanador() {
        return ganador;
    }

    
    /** 
     * @return int
     */
    public int getGolesLocal() {
        return golesLocal;
    }

    
    /** 
     * @return int
     */
    public int getGolesVisitante() {
        return golesVisitante;
    }

    
    /** 
     * @param pGol
     */
    public void agregarGolLocal(int pGol){
        this.golesLocal += pGol;
    }

    
    /** 
     * @param pGol
     */
    public void agregarGolVisitante(int pGol){
        this.golesVisitante += pGol;
    }

    
    /** 
     * @param pRendimiento
     */
    public void agregarRendimientoLocal(RendimientoJugador pRendimiento){
        this.rendimientoLocal.add(pRendimiento);
    }

    
    /** 
     * @param pRendimiento
     */
    public void agregarRendimientoVisitante(RendimientoJugador pRendimiento){
        this.rendimientoVisitante.add(pRendimiento);
    }

    public void imprimirRendimientosLocal(){
        System.out.println("\n==================================");
        System.out.println("EQUIPO LOCAL");
        System.out.println("==================================");
        System.out.println("\nPara los arqueros: ");
        for(RendimientoJugador rendimiento: this.rendimientoLocal){
            if(rendimiento.getJugador().getPosicionJugador().equals(Posicion.ARQUERO)){
                System.out.println("\n===============================");
                System.out.println("Nombre: " + rendimiento.getJugador().getNombre());
                System.out.println("minutosJugados: " + rendimiento.getMinutosJugados());
                System.out.println("minutoEntrada: " + rendimiento.getMinutoEntrada());
                System.out.println("minutoSalida: " + rendimiento.getMinutoSalida());
                System.out.println("golesAnotados: " + rendimiento.getGolesAnotados());
                System.out.println("penaltisAnotados: " + rendimiento.getPenaltisAnotados());
                System.out.println("autogoles: " + rendimiento.getAutogoles());
                System.out.println("asistencias: " + rendimiento.getAsistencias());
                System.out.println("penaltisErrados: " + rendimiento.getPenaltisErrados());
                System.out.println("tarjetasAmarillas: " + rendimiento.getTarjetasAmarillas());
                System.out.println("tarjetasRojas: " + rendimiento.getTarjetasRojas());
                System.out.println("Goles recibidos: " + rendimiento.getGolesRecibidos());
                System.out.println("Penaltis detenidos: " + rendimiento.getPenaltisDetenidos());
            }
        }
        System.out.println("\nPara los defensas: ");
        for(RendimientoJugador rendimiento: this.rendimientoLocal){
            if(rendimiento.getJugador().getPosicionJugador().equals(Posicion.DEFENSA)){
                System.out.println("\n===============================");
                System.out.println("Nombre: " + rendimiento.getJugador().getNombre());
                System.out.println("minutosJugados: " + rendimiento.getMinutosJugados());
                System.out.println("minutoEntrada: " + rendimiento.getMinutoEntrada());
                System.out.println("minutoSalida: " + rendimiento.getMinutoSalida());
                System.out.println("golesAnotados: " + rendimiento.getGolesAnotados());
                System.out.println("penaltisAnotados: " + rendimiento.getPenaltisAnotados());
                System.out.println("autogoles: " + rendimiento.getAutogoles());
                System.out.println("asistencias: " + rendimiento.getAsistencias());
                System.out.println("penaltisErrados: " + rendimiento.getPenaltisErrados());
                System.out.println("tarjetasAmarillas: " + rendimiento.getTarjetasAmarillas());
                System.out.println("tarjetasRojas: " + rendimiento.getTarjetasRojas());
                System.out.println("Goles recibidos: " + rendimiento.getGolesRecibidos());
            }
        }
        System.out.println("\nPara delanteros y medios");
        for(RendimientoJugador rendimiento: this.rendimientoLocal){
            Posicion posicion = rendimiento.getJugador().getPosicionJugador();
            if(posicion.equals(Posicion.MEDIO) || posicion.equals(Posicion.DELANTERO)){
                System.out.println("\n===============================");
                System.out.println("Nombre: " + rendimiento.getJugador().getNombre());
                System.out.println("Posicion: " + rendimiento.getJugador().getPosicionJugador());
                System.out.println("minutosJugados: " + rendimiento.getMinutosJugados());
                System.out.println("minutoEntrada: " + rendimiento.getMinutoEntrada());
                System.out.println("minutoSalida: " + rendimiento.getMinutoSalida());
                System.out.println("golesAnotados: " + rendimiento.getGolesAnotados());
                System.out.println("penaltisAnotados: " + rendimiento.getPenaltisAnotados());
                System.out.println("autogoles: " + rendimiento.getAutogoles());
                System.out.println("asistencias: " + rendimiento.getAsistencias());
                System.out.println("penaltisErrados: " + rendimiento.getPenaltisErrados());
                System.out.println("tarjetasAmarillas: " + rendimiento.getTarjetasAmarillas());
                System.out.println("tarjetasRojas: " + rendimiento.getTarjetasRojas());
            }
        }
    }

    public void imprimirRendimientosVisitante(){
        System.out.println("==================================");
        System.out.println("EQUIPO VISITANTE");
        System.out.println("==================================");
        System.out.println("\nPara los arqueros: ");
        for(RendimientoJugador rendimiento: this.rendimientoVisitante){
            if(rendimiento.getJugador().getPosicionJugador().equals(Posicion.ARQUERO)){
                System.out.println("\n===============================");
                System.out.println("Nombre: " + rendimiento.getJugador().getNombre());
                System.out.println("minutosJugados: " + rendimiento.getMinutosJugados());
                System.out.println("minutoEntrada: " + rendimiento.getMinutoEntrada());
                System.out.println("minutoSalida: " + rendimiento.getMinutoSalida());
                System.out.println("golesAnotados: " + rendimiento.getGolesAnotados());
                System.out.println("penaltisAnotados: " + rendimiento.getPenaltisAnotados());
                System.out.println("autogoles: " + rendimiento.getAutogoles());
                System.out.println("asistencias: " + rendimiento.getAsistencias());
                System.out.println("penaltisErrados: " + rendimiento.getPenaltisErrados());
                System.out.println("tarjetasAmarillas: " + rendimiento.getTarjetasAmarillas());
                System.out.println("tarjetasRojas: " + rendimiento.getTarjetasRojas());
                System.out.println("Goles recibidos: " + rendimiento.getGolesRecibidos());
                System.out.println("Penaltis detenidos: " + rendimiento.getPenaltisDetenidos());
            }
        }
        System.out.println("\nPara los defensas: ");
        for(RendimientoJugador rendimiento: this.rendimientoVisitante){
            if(rendimiento.getJugador().getPosicionJugador().equals(Posicion.DEFENSA)){
                System.out.println("\n===============================");
                System.out.println("Nombre: " + rendimiento.getJugador().getNombre());
                System.out.println("minutosJugados: " + rendimiento.getMinutosJugados());
                System.out.println("minutoEntrada: " + rendimiento.getMinutoEntrada());
                System.out.println("minutoSalida: " + rendimiento.getMinutoSalida());
                System.out.println("golesAnotados: " + rendimiento.getGolesAnotados());
                System.out.println("penaltisAnotados: " + rendimiento.getPenaltisAnotados());
                System.out.println("autogoles: " + rendimiento.getAutogoles());
                System.out.println("asistencias: " + rendimiento.getAsistencias());
                System.out.println("penaltisErrados: " + rendimiento.getPenaltisErrados());
                System.out.println("tarjetasAmarillas: " + rendimiento.getTarjetasAmarillas());
                System.out.println("tarjetasRojas: " + rendimiento.getTarjetasRojas());
                System.out.println("Goles recibidos: " + rendimiento.getGolesRecibidos());
            }
        }
        System.out.println("\nPara delanteros y medios");
        for(RendimientoJugador rendimiento: this.rendimientoVisitante){
            Posicion posicion = rendimiento.getJugador().getPosicionJugador();
            if(posicion.equals(Posicion.MEDIO) || posicion.equals(Posicion.DELANTERO)){
                System.out.println("\n===============================");
                System.out.println("Nombre: " + rendimiento.getJugador().getNombre());
                System.out.println("Posicion: " + rendimiento.getJugador().getPosicionJugador());
                System.out.println("minutosJugados: " + rendimiento.getMinutosJugados());
                System.out.println("minutoEntrada: " + rendimiento.getMinutoEntrada());
                System.out.println("minutoSalida: " + rendimiento.getMinutoSalida());
                System.out.println("golesAnotados: " + rendimiento.getGolesAnotados());
                System.out.println("penaltisAnotados: " + rendimiento.getPenaltisAnotados());
                System.out.println("autogoles: " + rendimiento.getAutogoles());
                System.out.println("asistencias: " + rendimiento.getAsistencias());
                System.out.println("penaltisErrados: " + rendimiento.getPenaltisErrados());
                System.out.println("tarjetasAmarillas: " + rendimiento.getTarjetasAmarillas());
                System.out.println("tarjetasRojas: " + rendimiento.getTarjetasRojas());
            }
        }
    }
}
