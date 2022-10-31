package controller;

import java.util.Scanner;
import model.*;


public class Menu{
    public final static Scanner ENTRADA = new Scanner(System.in);
    public final static CreadorObjetos CREADOR = new CreadorObjetos();
    public final static LectorArchivos LECTOR = new LectorArchivos();
    private App aplicacion;
    /**
     * Constructor
     */
    public Menu(App pAplicacion){
        this.aplicacion = pAplicacion;
    }

    /**
     * permite ingresar al usuario un numero
     * @return
     */
    public int preguntarOpcion(){
        int numero = 0;
        System.out.print("\n-> ");
        try {
            int opcion = Integer.parseInt(ENTRADA.nextLine());
            numero = opcion;
        } catch (Exception e) {
            System.out.println("\nNo ingresaste un numero...\n");
        }
        return numero;
    }
    /**
     * permite al usuario ingresar una cadena de texto
     * @return
     */
    public String preguntarPalabra(){
        System.out.print("\n-> ");
        String cadena = ENTRADA.nextLine();
        return cadena;
    }

    /**
     * Menu que se muestra al iniciar la aplicacion
     */
    public void mostrarMenuPrincipal(){
        System.out.println("Que deseas hacer?\n");
        System.out.println("1. Iniciar sesion");
        System.out.println("2. Registrarte");
        System.out.println("3. Salir de la aplicacion\n");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 1:
                System.out.println("\nhas elegido iniciar sesion...\n");
                mostrarMenuLogin();
                break;
            case 2:
                System.out.println("\nhas elegido registrarte...\n");
                mostrarMenuRegistro();
                break;                
            case 3:
                System.out.println("\nHas elegido salir de la aplicacion...\n");
                System.exit(0);
                break;
            default:
                System.out.println("\nATENCION: Debes ingresar una opcion valida\n");
                mostrarMenuPrincipal();
                break;
        }
    }

    /**
     * menu que se muestra al querer iniciar sesion
     */
    public void mostrarMenuLogin(){
        System.out.println("Deseas iniciar sesion como...\n");
        System.out.println("1. Participante");
        System.out.println("2. Administrador");
        System.out.println("3. volver atras");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 1:
                System.out.println("\nHas elegido iniciar sesion como participante\n");
                System.out.println("Ingresa tu nombre de usuario");
                String nombreUsuario = preguntarPalabra();
                System.out.println("\ningresa tu clave");
                String clave = preguntarPalabra();
                Participante participanteRecuperado = Persistencia.iniciarSesion(nombreUsuario, clave);

                if(participanteRecuperado != null && participanteRecuperado.getEquipoAsociado() != null){
                    mostrarMenuParticipante(participanteRecuperado, participanteRecuperado.getEquipoAsociado());
                }
                else if(participanteRecuperado != null && participanteRecuperado.getEquipoAsociado() == null){
                    mostrarMenuParticipante(participanteRecuperado);
                }
                mostrarMenuPrincipal();
                break;
            case 2:
                System.out.println("\nHas elegido iniciar sesion como administrador\n");
                Administrador administrador= App.getAdministrador();
                System.out.println("Ingresa tu nombre de usuario");
                String nombreAdmin = preguntarPalabra();
                System.out.println("\ningresa tu clave");
                String claveAdmin = preguntarPalabra();
                boolean condicion1 = administrador.getNombreUsuario().equals(nombreAdmin);
                boolean condicion2 = administrador.getClave().equals(claveAdmin);
                if(condicion1 && condicion2){
                    mostrarMenuAdministrador(administrador);
                }
                else{
                    System.out.println("\nNo se te ha concedido acceso de administrador\n");
                    mostrarMenuPrincipal();
                }
                break;
            case 3:
                System.out.println("\nVolviendo...\n");
                mostrarMenuPrincipal();
                break;
            default:
                System.out.println("\nATENCION: Debes ingresar una opcion valida\n");
                mostrarMenuLogin();
                break;
        }
    }

    /**
     * Muestra el menu de un participante luego de iniciar sesion
     * @param pParticipanteActivo
     */
    public void mostrarMenuParticipante(Participante pParticipanteActivo){
        System.out.println("\nBIENVENID@: " + pParticipanteActivo.getNombreUsuario());
        System.out.println("\nQue deseas hacer?\n");
        System.out.println("1. Crear tu equipo de fantasia");
        System.out.println("2. Salir de la aplicacion");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 1:
                System.out.println("\nHas elegido crear tu equipo de fantasia...\n");
                System.out.println("\nIngresa el nombre de tu nuevo equipo...");
                String nombreEquipo = preguntarPalabra();
                EquipoFantasia equipoAsociado = CREADOR.crearEquipoFantasia(nombreEquipo);
                configurarEquipoInicial(this, pParticipanteActivo, equipoAsociado);
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("\nATENCION: Debes ingresar una opcion valida\n");
                mostrarMenuParticipante(pParticipanteActivo);
                break;
        }
    }
    /**
     * muestra el menu de un administrador luego de iniciar sesión
     * @param pAdministrador
     */
    public void mostrarMenuAdministrador(Administrador pAdministrador){
        System.out.println("\nBienvenido");
        System.out.println("\nQue deseas hacer?\n");
        System.out.println("1. crear una nueva temporada");
        System.out.println("2. salir de la aplicacion");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 1:
                TemporadaReal nuevaTemporadaReal = CREADOR.crearTemporadaReal();
                System.out.println("\nAhora debes ingresar el archivo de los equipos que jugaran esta temporada");
                String nombreArchivoEquipos = preguntarPalabra();
                LECTOR.leerArchivoEquiposReales(nombreArchivoEquipos, nuevaTemporadaReal, CREADOR);
                System.out.println("\n Ahora debes ingresar el archivo de los jugadores de los equipos");
                String nombreArchivoJugadores = preguntarPalabra();
                LECTOR.leerArchivoJugadoresReales(nombreArchivoJugadores, nuevaTemporadaReal, CREADOR);
                System.out.println("\n Ahora debes ingresar el archivo de las fechas de esta temporada");
                String nombreArchivoFechas = preguntarPalabra();
                LECTOR.leerArchivoFechasReales(nombreArchivoFechas, nuevaTemporadaReal, CREADOR);
                mostrarMenuAdministrador(pAdministrador);
                break;
            case 2:
                System.exit(0);
                break;
        
            default:
                System.out.println("\nATENCION: Debes ingresar una opcion valida\n");
                mostrarMenuAdministrador(pAdministrador);
                break;
        }
    }

    /**
     * permite al usuario ingresar su nombre y clave para el registro
     */
    public void mostrarMenuRegistro(){
        System.out.print("\nIngresa tu nuevo nombre de usuario\n");
        String nombreUsuario = preguntarPalabra();
        System.out.print("\nIngresa tu nueva clave\n");
        String clave = preguntarPalabra();
        Participante nuevoParticipante = CREADOR.crearParticipante(nombreUsuario, clave);
        mostrarMenuParticipante(nuevoParticipante);
    }

    /**
     * Muestra el menu que vera un participante que ya ha creado un equipo de fantasia
     * @param pParticipanteActivo
     * @param pEquipoAsociado
     */
    public void mostrarMenuParticipante(Participante pParticipanteActivo, EquipoFantasia pEquipoAsociado){
        System.out.println("\nBIENVENID@: " + pParticipanteActivo.getNombreUsuario());
        System.out.println("\nQue deseas hacer?\n");
        System.out.println("1. Ver tu equipo de fantasia");
        System.out.println("2. Salir de la aplicacion");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 1:
                System.out.println("\nHas elegido ver tu equipo de fantasia\n");
                mostrarMenuEquipoFantasia(pParticipanteActivo, pEquipoAsociado);
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("\nATENCION: Debes ingresar una opcion valida\n");
                mostrarMenuParticipante(pParticipanteActivo);
                break;
        }
    }

    public void mostrarMenuEquipoFantasia(Participante pParticipante, EquipoFantasia pEquipoAsociado){
        System.out.println("Aqui va tu equipo :)");
    }

    /**
     * Menu que permite al participante ver los arqueros disponibles de un equipo
     * @param pEquipo
     * @return
     */
    public JugadorFantasiaArquero mostrarMenuCompraArquero(EquipoReal pEquipo){  
        JugadorFantasiaArquero nuevoArquero = null;
        System.out.println("\n");
        for(int i = 0; i < pEquipo.getJugadoresPorPosicion(Posicion.ARQUERO).size(); i++){
            JugadorReal arquero =  (JugadorReal) pEquipo.getJugadoresPorPosicion(Posicion.ARQUERO).get(i);
            System.out.println((i+1)+". "+arquero.getNombre());
            System.out.println("precio de compra: " + arquero.getPrecioCompra()+"\n");
        }
        System.out.println("\n que arquero deseas escoger");
        System.out.println("\nPara regresas ingresa 0");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 0:
                EquipoReal equipo = imprimirEquiposTemporada();
                mostrarMenuCompraArquero(equipo);
                break;
        
            default:
                JugadorReal arqueroSeleccionado = (JugadorReal) pEquipo.getJugadoresPorPosicion(Posicion.ARQUERO).get(opcion-1);
                nuevoArquero = CREADOR.crearArquero(arqueroSeleccionado.getNombre(), arqueroSeleccionado.getPosicionJugador(), arqueroSeleccionado.getPrecioCompra(), pEquipo);
        }
        return nuevoArquero;
    }
    /**
     * Permite al participante ver los defensas disponibles de un equipo
     * @param pEquipo
     * @return
     */
    public JugadorFantasiaDefensivo mostrarMenuCompraDefensa(EquipoReal pEquipo){
        JugadorFantasiaDefensivo nuevoDefensa = null;
        System.out.println("\n");
        for(int i = 0; i < pEquipo.getJugadoresPorPosicion(Posicion.DEFENSA).size(); i++){
            JugadorReal defensa = (JugadorReal) pEquipo.getJugadoresPorPosicion(Posicion.DEFENSA).get(i);
            System.out.println((i+1)+". "+defensa.getNombre());
            System.out.println("precio de compra: " + defensa.getPrecioCompra()+"\n");
        }
        System.out.println("\n que defensa deseas escoger");
        System.out.println("\nPara regresas ingresa 0");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 0:
                EquipoReal equipo = imprimirEquiposTemporada();
                mostrarMenuCompraDefensa(equipo);
                break;
        
            default:
                JugadorReal defensaSeleccionado = (JugadorReal) pEquipo.getJugadoresPorPosicion(Posicion.DEFENSA).get(opcion-1);
                nuevoDefensa = CREADOR.crearDefensa(defensaSeleccionado.getNombre(), defensaSeleccionado.getPosicionJugador(), defensaSeleccionado.getPrecioCompra(), pEquipo);
        }
        return nuevoDefensa;
    }
    /**
     * Permite al perticipante ver los medio campistas disponibles de un equipo
     * @param pEquipo
     * @return
     */
    public JugadorFantasia mostrarMenuCompraMedio(EquipoReal pEquipo){
        JugadorFantasia nuevoMedio = null;
        System.out.println("\n");
        for(int i = 0; i < pEquipo.getJugadoresPorPosicion(Posicion.MEDIO).size(); i++){
            JugadorReal medio = (JugadorReal) pEquipo.getJugadoresPorPosicion(Posicion.MEDIO).get(i);
            System.out.println((i+1)+". "+medio.getNombre());
            System.out.println("precio de compra: " + medio.getPrecioCompra()+"\n");
        }
        System.out.println("\n que medio campista deseas escoger");
        System.out.println("\nPara regresas ingresa 0");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 0:
                EquipoReal equipo = imprimirEquiposTemporada();
                mostrarMenuCompraMedio(equipo);
                break;
        
            default:
                JugadorReal medioSeleccionado = (JugadorReal) pEquipo.getJugadoresPorPosicion(Posicion.MEDIO).get(opcion-1);
                nuevoMedio = CREADOR.crearJugadorFantasia(medioSeleccionado.getNombre(), medioSeleccionado.getPosicionJugador(), medioSeleccionado.getPrecioCompra(), pEquipo);
        }
        return nuevoMedio;
    }
    /**
     * Permite a un participante ver los delanteros disponibles de un equipo
     * @param pEquipo
     * @return
     */
    public JugadorFantasia mostrarMenuCompraDelantero(EquipoReal pEquipo){
        JugadorFantasia nuevoDelantero = null;
        System.out.println("\n");
        for(int i = 0; i < pEquipo.getJugadoresPorPosicion(Posicion.DELANTERO).size(); i++){
            JugadorReal delantero = (JugadorReal) pEquipo.getJugadoresPorPosicion(Posicion.DELANTERO).get(i);
            System.out.println((i+1)+". "+delantero.getNombre());
            System.out.println("precio de compra: " + delantero.getPrecioCompra()+"\n");
        }
        System.out.println("\nque delantero deseas escoger");
        System.out.println("\nPara regresas ingresa 0");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 0:
                EquipoReal equipo = imprimirEquiposTemporada();
                mostrarMenuCompraMedio(equipo);
                break;
        
            default:
                JugadorReal delanteroSeleccionado = (JugadorReal) pEquipo.getJugadoresPorPosicion(Posicion.DELANTERO).get(opcion-1);
                nuevoDelantero = CREADOR.crearJugadorFantasia(delanteroSeleccionado.getNombre(), delanteroSeleccionado.getPosicionJugador(), delanteroSeleccionado.getPrecioCompra(), pEquipo);
        }
        return nuevoDelantero;
    }
    
    /**
     * Permite al participante ver los equipos disponibles de la temporada
     * @return
     */
    public EquipoReal imprimirEquiposTemporada(){
        TemporadaReal temporadaActiva =  aplicacion.temporadaActiva();
        System.out.println("\n");
        for(int i = 0; i < temporadaActiva.getEquiposDeTemporada().size(); i++){
            EquipoReal equipo = temporadaActiva.getEquiposDeTemporada().get(i);
            System.out.println((i+1)+". "+equipo.getNombreEquipo());
        }
        System.out.println("\nQue equipos deseas ver?");
        int opcion = preguntarOpcion();
        EquipoReal equipoSeleccionado = temporadaActiva.getEquiposDeTemporada().get(opcion-1);
        return equipoSeleccionado;
    }

    public void configurarEquipoInicial(Menu pMenu, Participante pParticipante, EquipoFantasia pEquipo){
        pParticipante.setEquipoAsociado(pEquipo);
        System.out.println("\nCompra un arquero titular\n");
        JugadorFantasiaArquero nuevoArquerotitular = pParticipante.comprarArquero(pMenu);
        pEquipo.setArqueroTitular(nuevoArquerotitular);
        pEquipo.agregarJugador(nuevoArquerotitular);
        System.out.println(pParticipante.getEquipoAsociado().getArqueroTitular().getNombre() + " agregado");

        System.out.println("\nCompra 2 delanteros titulares");
        for(int i = 0; i < 2; i++){
            JugadorFantasia nuevoDelantero = pParticipante.comprarDelantero(pMenu);
            pEquipo.agregarDelanteroTitular(nuevoDelantero);
            pEquipo.agregarJugador(nuevoDelantero);
            System.out.println(nuevoDelantero.getNombre()+" agregado");
        }
    }
}
