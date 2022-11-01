package model;

import java.util.ArrayList;
import java.util.Scanner;

public class EquipoFantasia extends Equipo{

    JugadorFantasiaArquero arqueroTitular, arqueroSustituto;
    ArrayList<JugadorFantasiaDefensivo> defensasTitulares = new ArrayList<>();
    ArrayList<JugadorFantasia> delanterosTitulares = new ArrayList<>(), mediosTitulares = new ArrayList<>();
    JugadorFantasiaDefensivo defensaSustituto;
    JugadorFantasia delanteroSustituto, medioSustituto;
    ArrayList<JugadorFantasia> jugadores = new ArrayList<>();
    
    public EquipoFantasia(String pNombreEquipo){
        super(pNombreEquipo);
    }

    @Override
    public String getNombreEquipo() {
        return super.getNombreEquipo();
    }
    
    /**
     * Retorna al arquero titular
     * @return
     */
    public JugadorFantasiaArquero getArqueroTitular() {
        return arqueroTitular;
    }
    
    /**
     * Retorna al arquero sustituto
     * @return
     */
    public JugadorFantasiaArquero getArqueroSustituto() {
        return arqueroSustituto;
    }
    
    /**
     * Retorna al defensa sustituto
     * @return
     */
    public JugadorFantasiaDefensivo getDefensaSustituto() {
        return defensaSustituto;
    }
    
    /**
     * Retorna al delantero sustituto
     * @return
     */
    public JugadorFantasia getDelanteroSustituto() {
        return delanteroSustituto;
    }
    
    /**
     * Retorna al medio campista sustituto
     * @return
     */
    public JugadorFantasia getMedioSustituto() {
        return medioSustituto;
    }
    
    /**
     * Retorna la lista de los defensas titutlares
     * @return
     */
    public ArrayList<JugadorFantasiaDefensivo> getDefensasTitutlares() {
        return defensasTitulares;
    }
    
    /**
     * Retorna la lista de los delanteros titulares
     * @return
     */
    public ArrayList<JugadorFantasia> getDelanterosTitutlares() {
        return delanterosTitulares;
    }
    
    /**
     * Retorna la lista de los medio campistas titutlares
     * @return
     */
    public ArrayList<JugadorFantasia> getMediosTitulares() {
        return mediosTitulares;
    }
    
    /**
     * Agrega un delantero a los delanteros titulares
     * @param pDelantero
     */
    public void agregarDelanteroTitular(JugadorFantasia pDelantero){
        this.delanterosTitulares.add(pDelantero);
    }
    
    /**
     * Agrega un medio campista a los medio campistas titulares
     * @param pMedio
     */
    public void agregarMedioTitular(JugadorFantasia pMedio){
        this.mediosTitulares.add(pMedio);
    }
    
    /**
     * Agrega un defensa a los defensas titulares
     * @param pDefensa
     */
    public void agregarDefensaTitular(JugadorFantasiaDefensivo pDefensa){
        this.defensasTitulares.add(pDefensa);
    }
    
    /**
     * Asigna un arquero como titular
     * @param pArqueroTitular
     */
    public void setArqueroTitular(JugadorFantasiaArquero pArqueroTitular) {
        this.arqueroTitular = pArqueroTitular;
    }
    
    /**
     * Asigna un arquero como sustituto
     * @param pArqueroSustituto
     */
    public void setArqueroSustituto(JugadorFantasiaArquero pArqueroSustituto) {
        this.arqueroSustituto = pArqueroSustituto;
    }
    
    /**
     * Asigna un defensa como sustituto
     * @param pDefensaSustituto
     */
    public void setDefensaSustituto(JugadorFantasiaDefensivo pDefensaSustituto) {
        this.defensaSustituto = pDefensaSustituto;
    }
    
    /**
     * Asigna un medio campista como sustituto
     * @param pMedioSustituto
     */
    public void setMedioSustituto(JugadorFantasia pMedioSustituto) {
        this.medioSustituto = pMedioSustituto;
    }
    
    /**
     * Asigna un delantero como sustituto
     * @param pDelanteroSustituto
     */
    public void setDelanteroSustituto(JugadorFantasia pDelanteroSustituto) {
        this.delanteroSustituto = pDelanteroSustituto;
    }
    
    /**
     * Verifica si el jugador ingresado por parametro ya existe en el equipo
     * @param pJugador
     * @return
     */
    public boolean verificarDisponibilidad(JugadorFantasia pJugador){
        boolean disponible = true;
        for(JugadorFantasia jugador: this.jugadores){
            if(jugador.getNombre().equals(pJugador.getNombre())){
                return false;
            }
        }
        return disponible;
    }
    
    /**
     * Retorna la lista de los 15 jugadores del equipo
     * @return
     */
    public ArrayList<JugadorFantasia> getJugadores() {
        return jugadores;
    }
    
    /**
     * Agrega un jugador a la lista de jugadores del equipo
     * @param pJugador
     */
    public void agregarJugador(JugadorFantasia pJugador){
        this.jugadores.add(pJugador);
    }

    /**
     * Cambia al arquero titular por el sustituto
     * @param pArquero
     */
    public void cambiarArquero(JugadorFantasiaArquero pArquero){
        JugadorFantasiaArquero sustituo = getArqueroSustituto();
        if(sustituo.getNombre().equals(pArquero.getNombre())){
            System.out.println("Escoge a tu arquero titular");
        }
        else{
            setArqueroSustituto(pArquero);
            setArqueroTitular(sustituo);
        }
    }

    /**
     * Cambia a un defensa titular por el defensa sustituto
     * @param pDefensa
     */
    public void cambiarDefensa(JugadorFantasiaDefensivo pDefensa){
        JugadorFantasiaDefensivo sustituto = getDefensaSustituto();
        int indiceJugador = -1;
        if(pDefensa.getNombre().equals(sustituto.getNombre())){
            System.out.println("Tienes que escoger un titular");
        }
        else{
            for (int i = 0; i < this.defensasTitulares.size(); i++) {
                JugadorFantasiaDefensivo defensa = this.defensasTitulares.get(i);
                if(defensa.getNombre().equals(pDefensa.getNombre())){
                    indiceJugador = i;
                }
            }
            setDefensaSustituto(this.defensasTitulares.get(indiceJugador));
            this.defensasTitulares.remove(indiceJugador);
            this.defensasTitulares.add(sustituto);
        }
    }

    /**
     * Cambia a un delantero titular por el delantero sustituto
     * @param pDelantero
     */
    public void cambiarDelantero(JugadorFantasia pDelantero){
        JugadorFantasia sustituto = getDelanteroSustituto();
        int indiceJugador = -1;
        if(pDelantero.getNombre().equals(sustituto.getNombre())){
            System.out.println("Tienes que esocoger un titular");
        }
        else{
            for (int i = 0; i < this.delanterosTitulares.size(); i++) {
                JugadorFantasia delantero = this.delanterosTitulares.get(i);
                if(delantero.getNombre().equals(pDelantero.getNombre())){
                    indiceJugador = i;
                }
            }
            setDelanteroSustituto(this.delanterosTitulares.get(indiceJugador));
            this.delanterosTitulares.remove(indiceJugador);
            this.delanterosTitulares.add(sustituto);
        }
    }

    /**
     * Cambia a un medio campista titular por el medio campista sustituto
     * @param pMedio
     */
    public void cambiarMedio(JugadorFantasia pMedio){
        JugadorFantasia sustituto = getMedioSustituto();
        int indiceJugador = -1;
        if(pMedio.getNombre().equals(sustituto.getNombre())){
            System.out.println("Tienes que esocoger un titular");
        }
        else{
            for (int i = 0; i < this.mediosTitulares.size(); i++) {
                JugadorFantasia medio = this.mediosTitulares.get(i);
                if(medio.getNombre().equals(pMedio.getNombre())){
                    indiceJugador = i;
                }
            }
            setMedioSustituto(this.mediosTitulares.get(indiceJugador));
            this.mediosTitulares.remove(indiceJugador);
            this.mediosTitulares.add(sustituto);
        }
    }

    /**
     * Permite al participante escoger un jugador especifico entre sus jugadores con la misma posicion
     * @param pJugadores
     * @param pEntrada
     * @return
     */
    public JugadorFantasia elegirJugadorPosicion(ArrayList<JugadorFantasia> pJugadores, Scanner pEntrada){
        JugadorFantasia jugadorBuscado = null;
        for (int i = 0; i < pJugadores.size(); i++) {

            System.out.println((i+1) + ". " + pJugadores.get(i).getNombre());
        }
        System.out.println("\nQue jugador deseas reemplzar?");
        int opcion = Integer.parseInt(pEntrada.nextLine());
        jugadorBuscado = pJugadores.get((opcion-1));
        return jugadorBuscado;
        }

    public ArrayList<JugadorFantasia> buscarJugador(Posicion pPosicion){
        ArrayList<JugadorFantasia> jugadoresPosicion = new ArrayList<>();
        for(JugadorFantasia jugador: this.jugadores){
            if(jugador.getPosicionJugador().equals(pPosicion)){
                jugadoresPosicion.add(jugador);
            }
        }
        return jugadoresPosicion;
    }
    
    /**
     * Imprime como se ve la alineacion actual del equipo
     */
    public void verEquipoFantasia(){
        System.out.println("============================================");
        System.out.println("Nombre del equipo: " + getNombreEquipo());
        System.out.println("============================================");
        System.out.println("\nArquero Titular: " + getArqueroTitular().getNombre());
        for(JugadorFantasia delantero:delanterosTitulares){
            System.out.println("\nDelantero Titular: " + delantero.getNombre());
        }
        for(JugadorFantasia medio: getMediosTitulares()){
            System.out.println("\nMedio Campista Titular: " + medio.getNombre());
        }
        for(JugadorFantasiaDefensivo defensa: getDefensasTitutlares()){
            System.out.println("\nDefensa Titular: " + defensa.getNombre());
        }
        System.out.println("\nArquero Sustituto: " + getArqueroSustituto().getNombre());
        System.out.println("\nDelantero Sustituto: " + getDelanteroSustituto().getNombre());
        System.out.println("\nMedio Campista Sustituto: " + getMedioSustituto().getNombre());
        System.out.println("\nDefensa Sustituto: " + getDefensaSustituto().getNombre() + "\n");
    }
}
