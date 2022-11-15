package controller;

import controller.Persistencia;
import model.EquipoFantasia;
import model.EquipoReal;
import model.Fecha;
import model.Participante;
import model.PartidoReal;
import model.TemporadaFantasia;
import model.TemporadaReal;

import view.PlayerAppPanel;

public class Conection {

	//Esta clase es utilizada para vincular la logica del modelo con la interfaz grafica.
	//Instancia de la clase Menu ya esta dentro del objeto creado de App
	
	//Atributos
	public App aplicacion;
	public Menu menu;
	
	TemporadaReal temporadaActiva;
	TemporadaFantasia temporadaFantasiaActiva;
	Fecha fecha;
	EquipoReal equipoLocal;
	Participante participanteRecuperado;
	EquipoFantasia equipoAsociado;
	
	PlayerAppPanel PlayerAppPanel;
	
	
	//Constructor
	
	public Conection() {

	}
	
	public void newAppMenu(App aplicacion, Menu menu) {
		this.menu = menu;
		this.aplicacion = aplicacion;
		this.temporadaActiva = aplicacion.temporadaActiva();
		this.temporadaFantasiaActiva = aplicacion.temporadaFantasiaActiva();
	}
	
	public App getApp() {
		return this.aplicacion;
	}
	
	public Menu getMenu() {
		return this.menu;
	}
	
	
	//Metodos de conexion
	
	public void prueba() {
		System.out.println("Se oprimio el boton de iniciar sesion");
	}
	
	//Iniciar sesion como participante:
	/**
	 * Se usa para verificar que existan las credenciales puestas para iniciar sesion.
	 * @return
	 */
	public int inicioSesionParticipante(String usuario, String clave) {
		this.participanteRecuperado = Persistencia.iniciarSesion(usuario, clave);
		
        if(participanteRecuperado != null && participanteRecuperado.getEquipoAsociado() != null){
            //mostrarMenuParticipante(participanteRecuperado, participanteRecuperado.getEquipoAsociado());
        	this.equipoAsociado = this.participanteRecuperado.getEquipoAsociado();
        	
        	return 1; //Tiene un equipo
        }
        else if(participanteRecuperado != null && participanteRecuperado.getEquipoAsociado() == null){
            //mostrarMenuParticipante(participanteRecuperado);
        	return 2; //No tiene equipo
        }
        else {
        	return 0; //No existe el usuario
        }
	}
        
        
      /**
       * Metodo para registrar un nuevo participante
       * @return
       */

      public int registroParticipante(String usuario, String clave) {
    	  
    	  CreadorObjetos CREADOR = menu.CREADOR;
    	  
    	  Participante participanteRecuperado = Persistencia.iniciarSesion(usuario, clave);
    		  
    	  if(usuario.isEmpty() == (true) && clave.isEmpty() == (true)) {
    		  
    		  return 2; //vacios
    	  }
    	  
    	  else if(participanteRecuperado != null) {
    		  
    		  return 0; //ya existe
    		  
    	  }
    		  
    	  else {
    		  
    	  
    		  Participante nuevoParticipante = CREADOR.crearParticipante(usuario, clave);
    		  //mostrarMenuParticipante(nuevoParticipante);
    		  
    		  return 1; //Se creo con exito
          
    	  }
      }
    	  
    	  
    	  /**
    	   * Metodo que le permite a un administrador crear una nueva temporada de fantasia.
    	   * @return
    	   */
    	  
    	  public void crearNuevaTemporada(TemporadaFantasia nuevaTemporadaFantasia) {
    		  
    		  App aplicacion = getApp();
    		  
              Persistencia.guardarTemporadaFantasia(nuevaTemporadaFantasia);
              aplicacion.agregarTemporadaFantasia(nuevaTemporadaFantasia);
             
    		  
    	  }
    	  
    	  public void subirNuevoResultado() {
    		  
              this.temporadaActiva = aplicacion.temporadaActiva();
              this.temporadaFantasiaActiva = aplicacion.temporadaFantasiaActiva();
              
              /**
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
              LECTOR.leerResultadoPartido(nombreArchivo, temporadaActiva, partido, temporadaFantasiaActiva, CREADOR);
              **/
    	  }
    	  
    	  public void subirNuevoResultado1(int numeroFecha) {
    		  
    		  this.fecha = this.temporadaActiva.buscarFecha(numeroFecha);  //busca fecha
    		  
    	  }
    	  
    	  public void subirNuevoResultado2() {
    		  
    		  this.equipoLocal = menu.imprimirEquiposTemporada();
    		  
    	  }
    	  
    	  
    	  
    	  
    	  
    	  
    	  public void preguntarOpcion() {
    		
    			System.out.println("\n***Escribe en el recuadro de abajo y oprime enviar***\n");
    			
    		}  
    	  
    	  
    	  
    	  
    	  
    	  //PREGUNTAR OPCION
    	  
    	  public void preguntarOpcion0() { //Preguntar opcion a un participante sin equipo
    		  
    		 preguntarOpcion();
    		  
    	  }
    	  
    	  public String preguntarOpcion1(String respuesta) { //Preguntar opcion a un participante sin equipo
    		  
    		  menu.getRespuesta(respuesta);
    		  
    		  return respuesta;
    		  
    	  }
    	  
    	  
    	  
    	  
    	  //GAME PANEL
    	  
    	  public void verCronogramaTemp() {
    		  
              temporadaActiva.mostrarCronogramaTemporada();
              menu.mostrarMenuFechas(participanteRecuperado);
              
    	  }
    	  
    	  public void verCronogramaFecha() {
    		  
              System.out.println("Hay " + temporadaActiva.getFechasTemporada().size() + " fechas en la temporada");
              
    	  }
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  public void crearEquipoFantasia() {
    	  //Crear equipo fantasia
    	  
    	/**
          System.out.println("\nHas elegido crear tu equipo de fantasia...\n");
          System.out.println("\nIngresa el nombre de tu nuevo equipo...");
          String nombreEquipo = preguntarPalabra();
          EquipoFantasia equipoAsociado = CREADOR.crearEquipoFantasia(nombreEquipo);
          crearEquipofantasia(this, pParticipanteActivo, equipoAsociado);
          Persistencia.guardarTemporadaFantasia(aplicacion.temporadaFantasiaActiva());
          mostrarMenuParticipante(pParticipanteActivo, pParticipanteActivo.getEquipoAsociado());
    	  **/
    	  }
    	  
    	  public void crearEquipoFantasia1(String nombreEquipo) {
    		  
    		  CreadorObjetos CREADOR = menu.CREADOR;
    		  
    		  EquipoFantasia equipoAsociado = CREADOR.crearEquipoFantasia(nombreEquipo);
    		  menu.crearEquipofantasia(this.menu, participanteRecuperado, equipoAsociado);
    		  Persistencia.guardarTemporadaFantasia(aplicacion.temporadaFantasiaActiva());
    		  
    	  }
}
       

	
	
	

