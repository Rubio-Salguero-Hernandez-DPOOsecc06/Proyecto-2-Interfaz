package model;

import java.util.ArrayList;
import java.util.Scanner;

public class EquipoFantasia extends Equipo{

    private JugadorFantasiaArquero arqueroTitular, arqueroSustituto;
    private ArrayList<JugadorFantasiaDefensivo> defensasTitulares = new ArrayList<>();
    private ArrayList<JugadorFantasia> delanterosTitulares = new ArrayList<>(), mediosTitulares = new ArrayList<>();
    private JugadorFantasiaDefensivo defensaSustituto;
    private JugadorFantasia delanteroSustituto, medioSustituto;
    private ArrayList<JugadorFantasia> jugadores = new ArrayList<>();
    private JugadorFantasia capitan;
    private int puntosAcumulados = 0;
    
    
    /**
     * Constructor
     * @param pNombreEquipo
     */
    public EquipoFantasia(String pNombreEquipo){
        super(pNombreEquipo);
    }

    public void sumarPuntos(int pPuntos){
        this.puntosAcumulados += pPuntos;
    }
    public int getPuntosAcumulados() {
        return puntosAcumulados;
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
    public ArrayList<JugadorFantasiaDefensivo> getDefensasTitulares() {
        return defensasTitulares;
    }
    
    /**
     * Retorna la lista de los delanteros titulares
     * @return
     */
    public ArrayList<JugadorFantasia> getDelanterosTitulares() {
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
    
    public JugadorFantasia getCapitan() {
        return capitan;
    }

    public void setCapitan(JugadorFantasia pCapitan) {
        this.capitan = pCapitan;
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
    public JugadorFantasia elegirJugadorPosicion(Posicion posicion, Scanner pEntrada){
        ArrayList<JugadorFantasia> jugadores = buscarJugador(posicion);
        JugadorFantasia jugadorBuscado = null;
        for (int i = 0; i < jugadores.size(); i++) {

            System.out.println((i+1) + ". " + jugadores.get(i).getNombre());
        }
        System.out.println("\nQue jugador deseas reemplzar?");
        System.out.print("\n-> ");
        int opcion = Integer.parseInt(pEntrada.nextLine());
        jugadorBuscado = jugadores.get((opcion-1));
        return jugadorBuscado;
    }
    
    /**
     * Crea una lista con los jugadores de una posición dada
     * @param pPosicion
     * @return
     */
    public ArrayList<JugadorFantasia> buscarJugador(Posicion pPosicion){
        ArrayList<JugadorFantasia> jugadoresPosicion = new ArrayList<>();
        for(JugadorFantasia jugador: this.jugadores){
            if(jugador.getPosicionJugador().equals(pPosicion)){
                jugadoresPosicion.add(jugador);
            }
        }
        return jugadoresPosicion;
    }

    public void actualizarPuntosJugador(RendimientoJugador pRendimiento, Posicion pPosicionJugador){
        actualizarMinutosJugados(pRendimiento.getMinutosJugados());
        actualizarGolesAnotados(pPosicionJugador, pRendimiento.getGolesAnotados());
        actualizarAsistencias(pRendimiento.getAsistencias());
        actualizarPenaltisErrados(pRendimiento.getPenaltisErrados());
        actualizarGolesAnotados(pPosicionJugador, pRendimiento.getPenaltisAnotados());
        actualizarAmarillas(pRendimiento.getTarjetasAmarillas());
        actualizarRojas(pRendimiento.getTarjetasRojas());
        actualizarAutogol(pRendimiento.getAutogoles());
    }



    public void actualizarPuntosEquipoPorJugador(JugadorReal pJugador, RendimientoJugador pRendimiento, MarcadorPartidoReal pMarcador){
        Posicion posicionJugador = pJugador.getPosicionJugador();
        //String ganador = pMarcador.getGanador().getNombreEquipo();
        //JugadorFantasia capitanEquipo = getCapitan();

        if(posicionJugador.equals(Posicion.ARQUERO)){
            JugadorFantasia arqueroTitular = this.arqueroTitular;
            if(pJugador.getNombre().equals(arqueroTitular.getNombre())){
                actualizarPuntosJugador(pRendimiento, posicionJugador);
                actualizarPenaltisDetenidos(pRendimiento.getPenaltisDetenidos());
            }
        }else if(posicionJugador.equals(Posicion.DELANTERO)){
            for(JugadorFantasia delantero: this.delanterosTitulares){
                if(pJugador.getNombre().equals(delantero.getNombre())){
                    actualizarPuntosJugador(pRendimiento, posicionJugador);
                }
            }
        }else if(posicionJugador.equals(Posicion.MEDIO)){
            for(JugadorFantasia medio: this.mediosTitulares){
                if(pJugador.getNombre().equals(medio.getNombre())){
                    actualizarPuntosJugador(pRendimiento, posicionJugador);
                }
            }
        }else if(posicionJugador.equals(Posicion.DEFENSA)){
            for(JugadorFantasiaDefensivo defensa: this.defensasTitulares){
                if(pJugador.getNombre().equals(defensa.getNombre())){
                    actualizarPuntosJugador(pRendimiento, posicionJugador);
                }
            }
        }
    }

    /**
     * Actualiza los puntos por minutos jugados
     * @param pMinutosJugados
     */
    public void actualizarMinutosJugados(int pMinutosJugados){
        if(pMinutosJugados == 60){
            sumarPuntos(1);
        } else if(pMinutosJugados > 60){
            sumarPuntos(2);
        }
    }

    /**
     * Actualiza los puntos por goles anotados segun la posición
     * @param pPosicion
     * @param pGolesAnotados
     */
    public void actualizarGolesAnotados(Posicion pPosicion ,int pGolesAnotados){
        if(pPosicion.equals(Posicion.ARQUERO) || pPosicion.equals(Posicion.DEFENSA)){
            int puntos = 6 * pGolesAnotados;
            sumarPuntos(puntos);
        } else if(pPosicion.equals(Posicion.DELANTERO)){
            int puntos = 4 * pGolesAnotados;
            sumarPuntos(puntos);
        } else if(pPosicion.equals(Posicion.MEDIO)){
            int puntos = 5 * pGolesAnotados;
            sumarPuntos(puntos);
        }
    }
    /**
     * Actualiza los puntos por asistencias
     * @param pAsistencias
     */
    public void actualizarAsistencias(int pAsistencias){
        int puntos = 3 * pAsistencias;
        sumarPuntos(puntos);
    }

    /**
     * Actualiza los puntos por penaltis detenidos
     * @param pPenaltisDetenidos
     */
    public void actualizarPenaltisDetenidos(int pPenaltisDetenidos){
        int puntos = 5 * pPenaltisDetenidos;
        sumarPuntos(puntos);
    }

    /**
     * Actualiza los puntos por ganador que no recibio goles
     * @param pIntacto
     */
    public void actualizarPuntosIntactos(boolean pIntacto){
        if(pIntacto == true){
            sumarPuntos(4);
        }
    }

    /**
     * Actualiza los puntos por capitan que gano partido
     * @param pGanador
     */
    public void actualizarCapitanGanador(boolean pGanador){
        if(pGanador == true){
            sumarPuntos(5);
        }
    }

    /**
     * Actualiza los puntos por penaltis errados
     * @param pPenaltisErrados
     */
    public void actualizarPenaltisErrados(int pPenaltisErrados){
        int puntos = -2 * pPenaltisErrados;
        sumarPuntos(puntos);
    }

    /**
     * Actualiza los puntos por tarjetas amarillas
     * @param pAmarillas
     */
    public void actualizarAmarillas(int pAmarillas){
        int puntos = -1 * pAmarillas;
        sumarPuntos(puntos);
    }

    /**
     * Actualiza los puntos por tarjetas rojas
     * @param pRojas
     */
    public void actualizarRojas(int pRojas){
        int puntos = -3 * pRojas;
        sumarPuntos(puntos);
    }

    /**
     * Actualiza los puntos por autogol
     * @param pAutogol
     */
    public void actualizarAutogol(int pAutogol){
        int puntos = -2 * pAutogol;
        sumarPuntos(puntos);
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
        for(JugadorFantasiaDefensivo defensa: getDefensasTitulares()){
            System.out.println("\nDefensa Titular: " + defensa.getNombre());
        }
        System.out.println("\nArquero Sustituto: " + getArqueroSustituto().getNombre());
        System.out.println("\nDelantero Sustituto: " + getDelanteroSustituto().getNombre());
        System.out.println("\nMedio Campista Sustituto: " + getMedioSustituto().getNombre());
        System.out.println("\nDefensa Sustituto: " + getDefensaSustituto().getNombre() + "\n");
        System.out.println("============================================");
        System.out.println("Capitan: " + getCapitan().getNombre());
        System.out.println("\nPuntos acumulados: " + getPuntosAcumulados());
        System.out.println("============================================");
    }
}
