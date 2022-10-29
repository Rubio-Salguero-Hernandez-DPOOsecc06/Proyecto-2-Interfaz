package controller;

import model.*;

public class App {
    private Participante ParticipanteActivo;
    private Menu menuApp = new Menu();

    public App(){
    }
    /**
     * asigna un participante a la aplicacion
     * @param pParticipanteActivo
     */
    public void setParticipanteActivo(Participante pParticipanteActivo) {
        ParticipanteActivo = pParticipanteActivo;
    }

    /**
     * retorna el participante activo de la aplicacion
     * @return
     */
    public Participante getParticipanteActivo() {
        return ParticipanteActivo;
    }

    /**
     * retorna el menu de la app 
     * @return
     */
    public Menu getMenuApp() {
        return menuApp;
    }

    public static void main(String[] args) throws Exception {

        App aplicacion = new App();
        Menu menuApp = aplicacion.getMenuApp();
        menuApp.mostrarMenuPrincipal();
    }
}
