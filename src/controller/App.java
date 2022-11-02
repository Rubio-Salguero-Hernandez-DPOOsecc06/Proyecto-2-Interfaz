package controller;

import java.util.ArrayList;

import model.*;

public class App {
    private static Administrador administrador = new Administrador("admin", "admin");
    private ArrayList<TemporadaReal> temporadas = new ArrayList<>();

    /**
     * Crea una instancia de aplicacion
     */
    public App(){
    }

    /**
     * retorna el administrador de la aplicacion
     * @return
     */
    public static Administrador getAdministrador() {
        return administrador;
    }

    /**
     * Agrega una temporada a la lista de temporadas reales
     * @param pTemporada
     */
    public void agregarTemporada(TemporadaReal pTemporada){
        this.temporadas.add(pTemporada);
    }
    /**
     * Retorna la lista de temporadas
     * @return
     */
    public ArrayList<TemporadaReal> getTemporadas() {
        return temporadas;
    }

    /**
     * Retorna la ultima temporada creada
     * @return
     */
    public TemporadaReal temporadaActiva(){
        TemporadaReal temporadaActiva = null;
        for(TemporadaReal temporada: getTemporadas()){
            if(temporada.getNumeroTemporada() == (getTemporadas().size())){
                temporadaActiva = temporada;
            }
        }
        return temporadaActiva;
    }
    
    public static void main(String[] args) throws Exception {
        App aplicacion = new App();
        Persistencia.recuperarTemporadaReal(aplicacion);
        Menu menuApp = new Menu(aplicacion);
        menuApp.mostrarMenuPrincipal();
    }
}
