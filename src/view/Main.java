package view;

import controller.Conection;

public class Main {
	
	static Conection conection;
	
	public Main() {

	}
	
	public static Conection createConection(){
		Conection conection = new Conection();
		return conection;
	}
	
	public static void main(String[] args) {
		conection = createConection();
		// Inicializacion de la interfaz
		FirstFrame firstFrame = new FirstFrame(); //creacion de la primera ventana que aparece una vez se ejecuta el programa
		
	}
}
