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

    public Posicion preguntarPosicion(){
        Posicion posicion = Posicion.ARQUERO;
        System.out.println("\nQue posicion deseas?\n");
        System.out.println("Que posicion deseas cambiar?\n");
                System.out.println("1. Arquero");
                System.out.println("2. Delantero");
                System.out.println("3. Medio campista");
                System.out.println("4. Defensa");
                int opcionPosicion = preguntarOpcion();
                switch (opcionPosicion) {
                    case 1:
                        break;
                    case 2:
                        posicion = Posicion.DELANTERO;
                        break;
                    case 3:
                        posicion = Posicion.MEDIO;
                        break;
                    case 4:
                        posicion = Posicion.DEFENSA;
                        break;
                    default:
                        System.out.println("Ingresa una opcion valida");
                        preguntarPosicion();
                        break;
                }
        return posicion;
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
        System.out.println("2. ver menu de fechas");
        System.out.println("3. ver rendimientos de un partido");
        System.out.println("4. Salir de la aplicacion");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 1:
                System.out.println("\nHas elegido crear tu equipo de fantasia...\n");
                System.out.println("\nIngresa el nombre de tu nuevo equipo...");
                String nombreEquipo = preguntarPalabra();
                EquipoFantasia equipoAsociado = CREADOR.crearEquipoFantasia(nombreEquipo);
                crearEquipofantasia(this, pParticipanteActivo, equipoAsociado);
                mostrarMenuParticipante(pParticipanteActivo, pParticipanteActivo.getEquipoAsociado());
                break;
            case 2:
                mostrarMenuFechas(pParticipanteActivo);
                break;
            case 3:
                System.out.println("\nDe que fecha es el partido que deseas ver");
                int numFecha = preguntarOpcion();
                Fecha fecha = this.aplicacion.temporadaActiva().buscarFecha(numFecha);
                System.out.println("Cual fue el equipo local");
                EquipoReal equipoLocal = imprimirEquiposTemporada();
                System.out.println("Cual fue el equipo visitante");
                EquipoReal equipoVisitante = imprimirEquiposTemporada();
                PartidoReal partido = fecha.buscarPartido(equipoLocal, equipoVisitante);
                partido.getMarcador().imprimirRendimientosLocal();
                partido.getMarcador().imprimirRendimientosVisitante();
                break;
            case 4:
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
        System.out.println("2. cargar nuevo resultado");
        System.out.println("3. salir de la aplicacion");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 1:
                TemporadaReal nuevaTemporadaReal = CREADOR.crearTemporadaReal();
                TemporadaFantasia nuevaTemporadaFantasia = CREADOR.crearTemporadaFantasia();
                Persistencia.guardarTemporadaFantasia(nuevaTemporadaFantasia);
                aplicacion.agregarTemporadaFantasia(nuevaTemporadaFantasia);
                System.out.println("\nAhora debes ingresar el archivo de los equipos que jugaran esta temporada");
                String nombreArchivoEquipos = preguntarPalabra();
                LECTOR.leerArchivoEquiposReales(nombreArchivoEquipos, nuevaTemporadaReal, CREADOR);
                System.out.println("\nAhora debes ingresar el archivo de los jugadores de los equipos");
                String nombreArchivoJugadores = preguntarPalabra();
                LECTOR.leerArchivoJugadoresReales(nombreArchivoJugadores, nuevaTemporadaReal, CREADOR);
                System.out.println("\nAhora debes ingresar el archivo de las fechas de esta temporada");
                String nombreArchivoFechas = preguntarPalabra();
                LECTOR.leerArchivoFechasReales(nombreArchivoFechas, nuevaTemporadaReal, CREADOR);
                System.out.println("Por favor cierra la aplicación y vuelve a iniciarla para confirmar tus cambios");
                break;
            case 2:
                TemporadaReal temporadaActiva = aplicacion.temporadaActiva();
                System.out.println("\nIngresa el nombre del archivo");
                String nombreArchivo = preguntarPalabra();
                System.out.println("A que fecha pertenece este resultado?");
                int numeroFecha = preguntarOpcion();
                Fecha fecha = temporadaActiva.buscarFecha(numeroFecha);
                System.out.println("Cual es el equipo local?");
                EquipoReal equipoLocal = imprimirEquiposTemporada();
                System.out.println("Cual es el equipo visitante?");
                EquipoReal equipoVisitante = imprimirEquiposTemporada();
                PartidoReal partido = fecha.buscarPartido(equipoLocal, equipoVisitante);
                LECTOR.leerResultadoPartido(nombreArchivo, temporadaActiva, partido, CREADOR);
                break;
            case 3:
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
        System.out.println("1. Ver menu de tu equipo de fantasia");
        System.out.println("2. Ver menu de fechas");
        System.out.println("3. Salir de la aplicacion");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 1:
                System.out.println("\nHas elegido ver tu equipo de fantasia\n");
                mostrarMenuEquipoFantasia(pParticipanteActivo, pEquipoAsociado);
                break;
            case 2:
                System.out.println("\nHas elegido ver el menu de fechas");
                mostrarMenuFechas(pParticipanteActivo);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("\nATENCION: Debes ingresar una opcion valida\n");
                mostrarMenuParticipante(pParticipanteActivo);
                break;
        }
    }

    /**
     * Muestra el menu asociado a un equipo de fantasia para manipularlo
     * @param pParticipante
     * @param pEquipoAsociado
     */
    public void mostrarMenuEquipoFantasia(Participante pParticipante, EquipoFantasia pEquipoAsociado){
        System.out.println("\nEstas viendo a tu equipo: " + pEquipoAsociado.getNombreEquipo());
        System.out.println("\nQue deseas hacer?...\n");
        System.out.println("1. Ver tu equipo de fantasia");
        System.out.println("2. Reemplazar un jugador titular por un sustituto");
        System.out.println("3. vender/comprar jugador <- (Siempre debes vender antes de poder comprar)");
        System.out.println("4. Volver atras");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 1:
                pEquipoAsociado.verEquipoFantasia();
                mostrarMenuEquipoFantasia(pParticipante, pEquipoAsociado);
                break;
            case 2:
                System.out.println("\nHas elegido cambiar a un titular por un sustituto\n");
                pEquipoAsociado.verEquipoFantasia();
                Posicion posicion = preguntarPosicion();
                JugadorFantasia jugadorCambiado = pEquipoAsociado.elegirJugadorPosicion(posicion, ENTRADA);
                if(jugadorCambiado.getPosicionJugador().equals(Posicion.ARQUERO)){
                    pEquipoAsociado.cambiarArquero((JugadorFantasiaArquero)jugadorCambiado);
                }
                else if(jugadorCambiado.getPosicionJugador().equals(Posicion.DELANTERO)){
                    pEquipoAsociado.cambiarDelantero(jugadorCambiado);
                }
                else if(jugadorCambiado.getPosicionJugador().equals(Posicion.MEDIO)){
                    pEquipoAsociado.cambiarMedio(jugadorCambiado);
                }
                else if(jugadorCambiado.getPosicionJugador().equals(Posicion.DEFENSA)){
                    pEquipoAsociado.cambiarDefensa((JugadorFantasiaDefensivo)jugadorCambiado);
                }
                pEquipoAsociado.verEquipoFantasia();
                System.out.println("\nRegresa guardar tus cambios\n");
                mostrarMenuEquipoFantasia(pParticipante, pEquipoAsociado);
                break;
            case 3:
                System.out.println("\nHas escogido vender un jugador\n");
                pEquipoAsociado.verEquipoFantasia();
                Posicion posicionBuscada = preguntarPosicion();
                if(posicionBuscada.equals(Posicion.ARQUERO)){
                    JugadorFantasia jugadorVendido = pEquipoAsociado.elegirJugadorPosicion(posicionBuscada, ENTRADA);               
                    pParticipante.venderArquero(this, pParticipante, pEquipoAsociado, (JugadorFantasiaArquero)jugadorVendido);
                    Persistencia.guardarParticipante(pParticipante);
                    pEquipoAsociado.verEquipoFantasia();
                    System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible());
                }
                else if(posicionBuscada.equals(Posicion.DELANTERO)){
                    
                    JugadorFantasia jugadorVendido = pEquipoAsociado.elegirJugadorPosicion(posicionBuscada, ENTRADA);
                    pParticipante.venderDelantero(this, pParticipante, pEquipoAsociado, jugadorVendido);
                    pEquipoAsociado.verEquipoFantasia();
                    System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible());
                    System.out.println("\nRegresa al menu anterior para guardar tus cambios\n");
                    
                }
                else if(posicionBuscada.equals(Posicion.MEDIO)){
                    
                    JugadorFantasia jugadorVendido = pEquipoAsociado.elegirJugadorPosicion(posicionBuscada, ENTRADA);
                    pParticipante.venderMedio(this, pParticipante, pEquipoAsociado, jugadorVendido);
                    pEquipoAsociado.verEquipoFantasia();
                    System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible());
                    System.out.println("\nRegresa al menu anterior para guardar tus cambios\n");
                    
                }
                else if(posicionBuscada.equals(Posicion.DEFENSA)){
                    JugadorFantasia jugadorVendido = pEquipoAsociado.elegirJugadorPosicion(posicionBuscada, ENTRADA);                   
                    pParticipante.venderDefensa(this, pParticipante, pEquipoAsociado, (JugadorFantasiaDefensivo)jugadorVendido);
                    pEquipoAsociado.verEquipoFantasia();
                    System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible());
                    System.out.println("\nRegresa al menu anterior para guardar tus cambios\n");
                    
                }
                mostrarMenuEquipoFantasia(pParticipante, pEquipoAsociado);
                break;
            case 4:
                Persistencia.guardarParticipante(pParticipante);
                mostrarMenuParticipante(pParticipante, pEquipoAsociado);
                break;
            default:
                System.out.println("\nATENCION: Debes ingresar una opcion valida\n");
                mostrarMenuEquipoFantasia(pParticipante, pEquipoAsociado);
                break;
        }
    }
    /**
     * Permite al participante ver informacion relevante relacionada con la informacion real
     * @param pParticipante
     */
    public void mostrarMenuFechas(Participante pParticipante){
        TemporadaReal temporadaActiva = this.aplicacion.temporadaActiva();
        EquipoFantasia equipoParticipante = pParticipante.getEquipoAsociado();
        System.out.println("\nQue deseas hacer?\n");
        System.out.println("1. Ver el cronograma de toda la temporada");
        System.out.println("2. Ver cronograma de una fecha");
        System.out.println("3. Consultar estadisticas de la temporada");
        System.out.println("4. consultar estadisticas de una fecha");
        System.out.println("5. Volver atras");
        System.out.println("6. Salir de la aplicacion");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 1:
                System.out.println("\nHas elegido ver el cronograma de toda la temporada\n");
                temporadaActiva.mostrarCronogramaTemporada();
                mostrarMenuFechas(pParticipante);
                break;
            case 2:
                System.out.println("\nHas elegido ver el cronograma de una fecha\n");
                System.out.println("Hay " + temporadaActiva.getFechasTemporada().size() + " fechas en la temporada");
                int numeroTemporada = preguntarOpcion();
                if(numeroTemporada <= temporadaActiva.getFechasTemporada().size()){
                    Fecha fechaEscogida = temporadaActiva.getFechasTemporada().get((numeroTemporada-1));
                    System.out.println("\nEl cronograma para la fecha " + fechaEscogida.getNumeroFecha() + " es:\n");
                    fechaEscogida.mostrarCronogramaFecha();
                }
                else{
                    System.out.println("Ingresaste un numero invalido");
                }
                mostrarMenuFechas(pParticipante);
                break;
            case 3:
                System.out.println("\nHas elegido consultar las estadisticas de la temporada\n");
                break;
            case 4:
                System.out.println("\nHas elegido consultar las estadisticas de una fecha\n");
                break;
            case 5:
                System.out.println("\nHas elegido volver atras\n");
                if(equipoParticipante == null){
                    mostrarMenuParticipante(pParticipante);
                }
                else if(equipoParticipante != null){
                    mostrarMenuParticipante(pParticipante, equipoParticipante);
                }
                break;
            case 6:
                System.exit(0);
                break;                       
            default:
                break;
        }
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
        System.out.println("\nQue arquero deseas escoger");
        System.out.println("\nPara regresar ingresa 0");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 0:
                EquipoReal equipo = imprimirEquiposTemporada();
                nuevoArquero = mostrarMenuCompraArquero(equipo);
                break;
        
            default:
                try {
                    JugadorReal arqueroSeleccionado = (JugadorReal) pEquipo.getJugadoresPorPosicion(Posicion.ARQUERO).get(opcion-1);
                nuevoArquero = CREADOR.crearArquero(arqueroSeleccionado.getNombre(), arqueroSeleccionado.getPosicionJugador(), arqueroSeleccionado.getPrecioCompra(), pEquipo);
                } catch (Exception e) {
                    System.out.println("ERROR -> INGRESASTE UN NUMERO EQUIVOCADO");
                    EquipoReal equipo1 = imprimirEquiposTemporada();
                    nuevoArquero = mostrarMenuCompraArquero(equipo1);
                }
                
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
        System.out.println("\nQue defensa deseas escoger");
        System.out.println("\nPara regresar ingresa 0");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 0:
                EquipoReal equipo = imprimirEquiposTemporada();
                nuevoDefensa = mostrarMenuCompraDefensa(equipo);
                break;
        
            default:
            try {
                JugadorReal defensaSeleccionado = (JugadorReal) pEquipo.getJugadoresPorPosicion(Posicion.DEFENSA).get(opcion-1);
                nuevoDefensa = CREADOR.crearDefensa(defensaSeleccionado.getNombre(), defensaSeleccionado.getPosicionJugador(), defensaSeleccionado.getPrecioCompra(), pEquipo);
                
            } catch (Exception e) {
                System.out.println("ERROR -> INGRESASTE UN NUMERO EQUIVOCADO");
                EquipoReal equipo1 = imprimirEquiposTemporada();
                nuevoDefensa = mostrarMenuCompraDefensa(equipo1);
            }
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
        System.out.println("\nQue medio campista deseas escoger");
        System.out.println("\nPara regresar ingresa 0");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 0:
                EquipoReal equipo = imprimirEquiposTemporada();
                nuevoMedio = mostrarMenuCompraMedio(equipo);
                break;
        
            default:
            try {
                JugadorReal medioSeleccionado = (JugadorReal) pEquipo.getJugadoresPorPosicion(Posicion.MEDIO).get(opcion-1);
                nuevoMedio = CREADOR.crearJugadorFantasia(medioSeleccionado.getNombre(), medioSeleccionado.getPosicionJugador(), medioSeleccionado.getPrecioCompra(), pEquipo);
            } catch (Exception e) {
                System.out.println("ERROR -> INGRESASTE UN NUMERO EQUIVOCADO");
                EquipoReal equipo1 = imprimirEquiposTemporada();
                nuevoMedio = mostrarMenuCompraMedio(equipo1);
            }
                
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
        System.out.println("\nPara regresar ingresa 0");
        int opcion = preguntarOpcion();
        switch (opcion) {
            case 0:
                EquipoReal equipo = imprimirEquiposTemporada();
                nuevoDelantero = mostrarMenuCompraDelantero(equipo);
                break;
        
            default:
            try {
                JugadorReal delanteroSeleccionado = (JugadorReal) pEquipo.getJugadoresPorPosicion(Posicion.DELANTERO).get(opcion-1);
                nuevoDelantero = CREADOR.crearJugadorFantasia(delanteroSeleccionado.getNombre(), delanteroSeleccionado.getPosicionJugador(), delanteroSeleccionado.getPrecioCompra(), pEquipo);
            } catch (Exception e) {
                System.out.println("ERROR -> INGRESASTE UN NUMERO EQUIVOCADO");
                EquipoReal equipo1 = imprimirEquiposTemporada();
                nuevoDelantero = mostrarMenuCompraDelantero(equipo1);
            }
                
        }
        return nuevoDelantero;
    }
    
    /**
     * Permite al participante ver los equipos disponibles de la temporada
     * @return
     */
    public EquipoReal imprimirEquiposTemporada(){
        EquipoReal equipoSeleccionado = null;
        TemporadaReal temporadaActiva =  aplicacion.temporadaActiva();
        System.out.println("\n");
        for(int i = 0; i < temporadaActiva.getEquiposDeTemporada().size(); i++){
            EquipoReal equipo = temporadaActiva.getEquiposDeTemporada().get(i);
            System.out.println((i+1)+". "+equipo.getNombreEquipo());
        }
        System.out.println("\nQue equipos deseas ver?");
        int opcion = preguntarOpcion();
        try {
            equipoSeleccionado = temporadaActiva.getEquiposDeTemporada().get(opcion-1);
            return equipoSeleccionado;
        } catch (Exception e) {
            System.out.println("ERROR -> INGRESASTE UN NUMERO EQUIVOCADO");
            equipoSeleccionado = imprimirEquiposTemporada();
        }
        return equipoSeleccionado;

    }
    /**
     * Configura la alineacion inicial del equipo de fantasia recien creado
     * @param pMenu
     * @param pParticipante
     * @param pEquipo
     */
    public void crearEquipofantasia(Menu pMenu, Participante pParticipante, EquipoFantasia pEquipo){
        pParticipante.setEquipoAsociado(pEquipo); //asocia el equipo al participante

        //proceso de compra del arquero titular
        System.out.println("Ahora debes escoger tu arquero titutlar");
        System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible()); 
        JugadorFantasiaArquero arqueroTitutlar = pParticipante.comprarArquero(pMenu);
        while(arqueroTitutlar == null){
            System.out.println("Ahora debes escoger tu arquero titutlar");
            arqueroTitutlar = pParticipante.comprarArquero(pMenu);
        }
        pEquipo.setArqueroTitular(arqueroTitutlar);
        pEquipo.agregarJugador(arqueroTitutlar);

        //proceso de compra de delantero titular 1
        System.out.println("Ahora debes escoger a tu primer delantero titular");
        System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible());
        JugadorFantasia delanteroTitular1 = pParticipante.comprarDelantero(pMenu);
        while(delanteroTitular1 == null){
            System.out.println("Ahora debes escoger a tu primer delantero titular");
            delanteroTitular1 = pParticipante.comprarDelantero(pMenu);
        }
        pEquipo.agregarDelanteroTitular(delanteroTitular1);
        pEquipo.agregarJugador(delanteroTitular1);
        
        //proceso de compra de delantero titular 2
        System.out.println("Ahora debes escoger a tu segundo delantero titular");
        System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible());
        JugadorFantasia delanteroTitular2 = pParticipante.comprarDelantero(pMenu);
        while(delanteroTitular2 == null){
            System.out.println("Ahora debes escoger a tu segundo delantero titular");
            delanteroTitular2 = pParticipante.comprarDelantero(pMenu);
        }
        pEquipo.agregarDelanteroTitular(delanteroTitular2);
        pEquipo.agregarJugador(delanteroTitular2);

        //proceso comprar medio campista 1
        System.out.println("Ahora debes comprar a tu primer medio campista titular");
        System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible());
        JugadorFantasia medio1 = pParticipante. comprarMedio(pMenu);
        while(medio1 == null){
            System.out.println("Ahora debes comprar a tu primer medio campista titular");
            medio1 = pParticipante.comprarMedio(pMenu);
        }
        pEquipo.agregarMedioTitular(medio1);
        pEquipo.agregarJugador(medio1);

        //proceso comprar medio campista 2
        System.out.println("Ahora debes comprar a tu segundo medio campista titular");
        System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible());
        JugadorFantasia medio2 = pParticipante. comprarMedio(pMenu);
        while(medio2 == null){
            System.out.println("Ahora debes comprar a tu segundo medio campista titular");
            medio2 = pParticipante.comprarMedio(pMenu);
        }
        pEquipo.agregarMedioTitular(medio2);
        pEquipo.agregarJugador(medio2);

        //proceso comprar medio campista 3
        System.out.println("Ahora debes comprar a tu tercer medio campista titular");
        System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible());
        JugadorFantasia medio3 = pParticipante. comprarMedio(pMenu);
        while(medio3 == null){
            System.out.println("Ahora debes comprar a tu tercer medio campista titular");
            medio3 = pParticipante.comprarMedio(pMenu);
        }
        pEquipo.agregarMedioTitular(medio3);
        pEquipo.agregarJugador(medio3);

        //proceso comprar medio campista 4
        System.out.println("Ahora debes comprar a tu cuarto medio campista titular");
        System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible());
        JugadorFantasia medio4 = pParticipante.comprarMedio(pMenu);
        while(medio4 == null){
            System.out.println("Ahora debes comprar a tu cuarto medio campista titular");
            medio4 = pParticipante.comprarMedio(pMenu);
        }
        pEquipo.agregarMedioTitular(medio4);
        pEquipo.agregarJugador(medio4);

        //proceso compra defensa 1
        System.out.println("Ahora debes comprar a tu primer defensa titular");
        System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible());
        JugadorFantasiaDefensivo defensa1 = pParticipante.comprarDefensa(pMenu);
        while(defensa1 == null){
            System.out.println("Ahora debes comprar a tu primer defensa titular");
            defensa1 = pParticipante.comprarDefensa(pMenu);
        }
        pEquipo.agregarDefensaTitular(defensa1);
        pEquipo.agregarJugador(defensa1);

        //proceso compra defensa 2
        System.out.println("Ahora debes comprar a tu segundo defensa titular");
        System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible());
        JugadorFantasiaDefensivo defensa2 = pParticipante.comprarDefensa(pMenu);
        while(defensa2 == null){
            System.out.println("Ahora debes comprar a tu segundo defensa titular");
            defensa2 = pParticipante.comprarDefensa(pMenu);
        }
        pEquipo.agregarDefensaTitular(defensa2);
        pEquipo.agregarJugador(defensa2);
        
        //proceso compra defensa 3
        System.out.println("Ahora debes comprar a tu tercer defensa titular");
        System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible());
        JugadorFantasiaDefensivo defensa3 = pParticipante.comprarDefensa(pMenu);
        while(defensa3 == null){
            System.out.println("Ahora debes comprar a tu tercer defensa titular");
            defensa3 = pParticipante.comprarDefensa(pMenu);
        }
        pEquipo.agregarDefensaTitular(defensa3);
        pEquipo.agregarJugador(defensa3);
        
        //proceso compra defensa 4
        System.out.println("Ahora debes comprar a tu cuarto defensa titular");
        System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible());
        JugadorFantasiaDefensivo defensa4 = pParticipante.comprarDefensa(pMenu);
        while(defensa4 == null){
            System.out.println("Ahora debes comprar a tu cuarto defensa titular");
            defensa4 = pParticipante.comprarDefensa(pMenu);
        }
        pEquipo.agregarDefensaTitular(defensa4);
        pEquipo.agregarJugador(defensa4);

        //proceso compra arquero sustituto
        System.out.println("Ahora debes escoger tu arquero sustituto");
        System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible()); 
        JugadorFantasiaArquero arqueroSustituto = pParticipante.comprarArquero(pMenu);
        while (arqueroSustituto == null) {
            System.out.println("Ahora debes escoger tu arquero sustituto");
            arqueroSustituto = pParticipante.comprarArquero(pMenu);
        }
        pEquipo.setArqueroSustituto(arqueroSustituto);
        pEquipo.agregarJugador(arqueroSustituto);

        //proceso de compra de delantero sustituto
        System.out.println("Ahora debes escoger a tu delantero sustituto");
        System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible());
        JugadorFantasia delanteroSustituto = pParticipante.comprarDelantero(pMenu);
        while (delanteroSustituto == null){
            System.out.println("Ahora debes escoger a tu delantero sustituto");
            delanteroSustituto = pParticipante.comprarDelantero(pMenu);
        }
        pEquipo.setDelanteroSustituto(delanteroSustituto);
        pEquipo.agregarJugador(delanteroSustituto);

        //proceso comprar medio campista sustituto
        System.out.println("Ahora debes comprar a tu medio campista sustituto");
        System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible());
        JugadorFantasia medioSustituto = pParticipante. comprarMedio(pMenu);
        while (medioSustituto == null) {
            System.out.println("Ahora debes comprar a tu medio campista sustituto");
            medioSustituto = pParticipante.comprarMedio(pMenu);
        }
        pEquipo.setMedioSustituto(medioSustituto);
        pEquipo.agregarJugador(medioSustituto);

        //proceso compra defensa sustituto
        System.out.println("Ahora debes comprar a tu defensa sustituto");
        JugadorFantasiaDefensivo defensaSustituto = pParticipante.comprarDefensa(pMenu);
        while (defensaSustituto == null) {
            System.out.println("Ahora debes comprar a tu defensa sustituto");
            defensaSustituto = pParticipante.comprarDefensa(pMenu);
        }
        pEquipo.setDefensaSustituto(defensaSustituto);
        pEquipo.agregarJugador(defensaSustituto);

        pEquipo.setCapitan(arqueroTitutlar);

        TemporadaFantasia temporadaActiva = aplicacion.temporadaFantasiaActiva();
        temporadaActiva.getEquiposTemporada().add(pEquipo);

        Persistencia.guardarParticipante(pParticipante);
        pParticipante.getEquipoAsociado().verEquipoFantasia();
        System.out.println("Presupuesto disponible: " + pParticipante.getPresupuestoDisponible());
    }
}
