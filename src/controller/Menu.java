package controller;

import java.util.Scanner;
import model.*;


public class Menu{
    public final static Scanner ENTRADA = new Scanner(System.in);
    public final static CreadorObjetos CREADOR = new CreadorObjetos();
    public final static LectorArchivos LECTOR = new LectorArchivos();
    public Menu(){
    }

    /**
     * permite ingresar al usuario un numero
     * @return
     */
    public int preguntarOpcion(){
        int numero = 0;
        System.out.print("\n-> ");
        int opcion = Integer.parseInt(ENTRADA.nextLine());
        numero = opcion;
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
                if(participanteRecuperado != null){
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
        System.out.println("2. Ver tu equipo de fantasia");
    }

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
}
