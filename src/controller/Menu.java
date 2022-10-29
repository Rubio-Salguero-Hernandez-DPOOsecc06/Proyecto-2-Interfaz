package controller;

import java.beans.PersistenceDelegate;
import java.util.Scanner;

import model.*;


public class Menu{
    public final static Scanner ENTRADA = new Scanner(System.in);
    public final static CreadorObjetos CREADOR = new CreadorObjetos();
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
                System.out.println("\n Has elegido iniciar sesion como participante\n");
                break;
            case 2:
                System.out.println("\n Has elegido iniciar sesion como administrador\n");
                break;
            case 3:
                System.out.println("\n Volviendo...\n");
                mostrarMenuPrincipal();
                break;
            default:
                System.out.println("\nATENCION: Debes ingresar una opcion valida\n");
                mostrarMenuLogin();
                break;
        }
    }

    public void mostrarMenuRegistro(){
        System.out.print("\nIngresa tu nuevo nombre de usuario\n");
        String nombreUsuario = preguntarPalabra();
        System.out.print("\nIngresa tu nueva clave\n");
        String clave = preguntarPalabra();
        Participante nuevoParticipante = CREADOR.crearParticipante(nombreUsuario, clave);
    }


}
