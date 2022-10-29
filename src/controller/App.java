package controller;

import model.*;

public class App {
    private static Administrador administrador = new Administrador("admin", "admin");
    private Menu menuApp = new Menu();

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
    

    public static void main(String[] args) throws Exception {
        App aplicacion = new App();
        Menu menuApp = aplicacion.getMenuApp();
        menuApp.mostrarMenuPrincipal();
    }
}
