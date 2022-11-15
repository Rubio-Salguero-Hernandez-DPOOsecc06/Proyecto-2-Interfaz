package view;

import controller.App;
import controller.Conection;
import controller.Menu;
import controller.Persistencia;

public class Main {
	
	public static Conection conection;
	public App aplicacion;
	public Menu menu;
	
	public Main() {

	}
	
	public static Conection createConection(){
		Conection conection = new Conection();
		return conection;
	}
	
	private void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	private void setApp(App aplicacion) {
		this.aplicacion = aplicacion;
	}
	
	public App getApp() {
		return this.aplicacion;
	}
	
	public Menu getMenu() {
		return this.menu;
	}
	
	public static void main(String[] args) {
		conection = createConection();
		
		App aplicacion = new App();
        Persistencia.recuperarTemporadaReal(aplicacion);
        Persistencia.recuperarTemporadaFantasia(aplicacion);
        if(aplicacion.getTemporadas().size() == 0){
            System.out.println("\nNo existen temporadas credas aun\n");
        }
        else{
            System.out.println("Existen " +aplicacion.getTemporadas().size()+ " temporadas creadas");
        }
        Menu menuApp = new Menu(aplicacion);
        
        Main main = new Main();
        
        main.setMenu(menuApp);
		main.setApp(aplicacion);
		conection.newAppMenu(aplicacion, menuApp);
        
		// Inicializacion de la interfaz
		FirstFrame firstFrame = new FirstFrame(); //creacion de la primera ventana que aparece una vez se ejecuta el programa
		
	}
}
