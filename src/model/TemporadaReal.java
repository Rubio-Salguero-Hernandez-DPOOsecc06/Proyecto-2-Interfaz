package model;

import java.io.Serializable;
import java.util.ArrayList;

public class TemporadaReal implements Serializable, Temporada {
    private int numeroTemporada;
    private ArrayList<EquipoReal> equiposDeTemporada = new ArrayList<>(); 
    private ArrayList<Fecha> fechasTemporada = new ArrayList<>();

    /**
     * Constructor
     */
    public TemporadaReal(){
    }

    @Override
    public int getNumeroTemporada() {
        return numeroTemporada;
    }
    public ArrayList<Fecha> getFechasTemporada() {
        return fechasTemporada;
    }

    @Override
    public void setNumeroTemporada(int pNumeroTemporada) {
        this.numeroTemporada = pNumeroTemporada;
    }
    /**
     * Agrega un nuevo equipo real a la temporada
     * @param pNuevoEquipo
     */
    public void agregarEquipo(EquipoReal pNuevoEquipo){
        this.equiposDeTemporada.add(pNuevoEquipo);
    }
    /**
     * Revisa y busca si el equipo solicitado existe en la lista de equipos de la temporada
     * @param pNombreEquipo
     * @return
     */
    public EquipoReal buscarEquipo(String pNombreEquipo){
        EquipoReal equipoBuscado = null;
        for(EquipoReal equipo: this.equiposDeTemporada){
            if(equipo.getNombreEquipo().equals(pNombreEquipo)){
                equipoBuscado = equipo;
            }
        }
        return equipoBuscado;
    }
    /**
     * Agrega una nueva fecha a a la temporada
     * @param pNuevaFecha
     */
    public void agregarFecha(Fecha pNuevaFecha){
        this.fechasTemporada.add(pNuevaFecha);
    }
    /**
     * Busca si existe una fecha dentro de la temporada
     * @param pNumeroFecha
     * @return
     */
    public Fecha buscarFecha(int pNumeroFecha){
        Fecha fechaBuscada = null;
        for(Fecha fecha: this.fechasTemporada){
            if(fecha.getNumeroFecha() == pNumeroFecha){
                fechaBuscada = fecha;
            }
        }
        return fechaBuscada;
    } 

    /**
     * Retorna una lista con los equipos que juegan esta temporada
     * @return
     */
    public ArrayList<EquipoReal> getEquiposDeTemporada() {
        return equiposDeTemporada;
    }

    public void mostrarCronogramaTemporada(){
        for(Fecha fecha: this.fechasTemporada){
            System.out.println("\n=====================================================================");
            System.out.println("Para la fecha " + fecha.getNumeroFecha() + " El cronograma es el siguiente:");
            System.out.println("=====================================================================\n");
            fecha.mostrarCronogramaFecha();
        }
    }
}

