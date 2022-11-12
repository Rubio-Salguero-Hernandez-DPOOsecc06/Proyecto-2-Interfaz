package controller;

import controller.Persistencia;
import model.Participante;

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
		App aplicacion = new App();
		this.menu = aplicacion.menuApp;
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
	
	
	
}
