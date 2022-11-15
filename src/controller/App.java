package controller;

import java.util.ArrayList;

import model.*;

public class App {
    private static Administrador administrador = new Administrador("admin", "admin");
    private ArrayList<TemporadaReal> temporadas = new ArrayList<>();
    private ArrayList<TemporadaFantasia> temporadasFantasia = new ArrayList<>();
    public Menu menuApp;
    
    /**
     * Crea una instancia de aplicacion
     */
    public App(){
    	
        //menuApp.mostrarMenuPrincipal();
    }
    
    /**
     * retorna el Menu
     * @return
     */
    
    public Menu getMenu() {
    	return this.menuApp;
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
     * Agrega una temporada a la lista de temporadas de fantasia
     * @param pTemporada
     */
    public void agregarTemporadaFantasia(TemporadaFantasia pTemporada){
        this.temporadasFantasia.add(pTemporada);
    }
    /**
     * Retorna la lista de temporadas
     * @return
     */
    public ArrayList<TemporadaReal> getTemporadas() {
        return temporadas;
    }

    public ArrayList<TemporadaFantasia> getTemporadasFantasia() {
        return temporadasFantasia;
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

    public TemporadaFantasia temporadaFantasiaActiva(){
        TemporadaFantasia temporadaActiva = null;
        for(TemporadaFantasia temporada: getTemporadasFantasia()){
            if(temporada.getNumeroTemporada() == (getTemporadas().size())){
                temporadaActiva = temporada;
            }
        }
        return temporadaActiva;
    }
    
    public static void main(String[] args) throws Exception {
        App aplicacion = new App();
        Persistencia.recuperarTemporadaReal(aplicacion);
        Persistencia.recuperarTemporadaFantasia(aplicacion);
        if(aplicacion.getTemporadas().size() == 0){
            System.out.println("\nNo existen temporadas credas aun\n");
        }
        else{
            System.out.println("Existen " +aplicacion.getTemporadas().size()+ " temporadas creadas");
        }
        Menu menuApp = new Menu(aplicacion);
        menuApp.mostrarMenuPrincipal();
    }
}
