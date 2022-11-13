package controller;

import controller.Persistencia;

import model.Participante;
import model.TemporadaFantasia;
import model.TemporadaReal;

public class Conection {

	//Esta clase es utilizada para vincular la logica del modelo con la interfaz grafica.
	//Instancia de la clase Menu ya esta dentro del objeto creado de App
	
	//Atributos
	public App aplicacion;
	public Menu menu;
	
	//Constructor
	
	public Conection() {
			
		
	}
	
	public void newAppMenu() {
		this.aplicacion = new App();
		this.menu = aplicacion.menuApp;
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
		Participante participanteRecuperado = Persistencia.iniciarSesion(usuario, clave);
		
        if(participanteRecuperado != null && participanteRecuperado.getEquipoAsociado() != null){
            //mostrarMenuParticipante(participanteRecuperado, participanteRecuperado.getEquipoAsociado());
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
    	  
}
       

	
	
	

