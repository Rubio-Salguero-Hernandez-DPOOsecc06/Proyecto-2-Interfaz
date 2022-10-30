package controller;

import java.util.ArrayList;

import model.*;

public class App {
    private static Administrador administrador = new Administrador("admin", "admin");
    private ArrayList<TemporadaReal> temporadas = new ArrayList<>();
    private Menu menuApp = new Menu();

    /**
     * Crea una instancia de aplicacion
     */
    public App(){
    }

    /**
     * retorna el menu de la app 
     * @return
     */
    public Menu getMenuApp() {
        return menuApp;
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
    

    public static void main(String[] args) throws Exception {
        App aplicacion = new App();
        Menu menuApp = aplicacion.getMenuApp();
        Persistencia.recuperarTemporadaReal(aplicacion);
        menuApp.mostrarMenuPrincipal();
    }
}
