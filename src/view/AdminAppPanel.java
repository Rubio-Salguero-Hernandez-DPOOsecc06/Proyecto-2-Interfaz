package view;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.OutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import controller.Conection;
import controller.CreadorObjetos;
import controller.LectorArchivos;
import controller.Menu;
import controller.Persistencia;
import model.EquipoReal;
import model.Fecha;
import model.PartidoReal;
import model.TemporadaFantasia;
import model.TemporadaReal;

@SuppressWarnings("serial")

public class AdminAppPanel extends JPanel implements ActionListener{
	
	//Atributes
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton inputButton;
	FirstFrame FirstFrame;
	
	JTextField inputField;
	JTextArea textArea;
	Conection conection;
	Main mainClass;
	Menu menu;
	
	LectorArchivos LECTOR;
	CreadorObjetos CREADOR;
	TemporadaReal nuevaTemporadaReal;
	TemporadaFantasia nuevaTemporadaFantasia;
	
	Integer paso = 0; //Numero de paso en el que el programa se encuentra, usado para que funcionen las acciones de los botones.
	
	//Panel Definition
	
	public AdminAppPanel() {
		
	this.conection = mainClass.conection;
	
	//Layout
	this.setLayout(new GridBagLayout());
	
	//Elements of the Layout
	
	GridBagConstraints constraints = new GridBagConstraints();
	
	
	//#1: Panel with Image and Label with Type of user
	JPanel rightPanel = new JPanel();
	constraints.gridx = 4;
	constraints.gridy = 1;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	
	
	rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
	
	
		//Addition of image to rightPanel
	BufferedImage backImage = null;
	try {
		backImage = ImageIO.read(new File("InterfaceFiles/Admin.jpg"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	Image dimg = backImage.getScaledInstance(400, 250,
	        Image.SCALE_SMOOTH);
	
	ImageIcon dimgRe = new ImageIcon(dimg);
	
	JLabel picLabel = new JLabel(dimgRe);	
	
	rightPanel.add(picLabel); //Here
	
		//Addition of text to rightPanel
	
	JLabel userLabel = new JLabel();
	userLabel.setText("Tipo de Usuario: ADMINISTRADOR");
	userLabel.setFont(new Font("MV Boli",Font.BOLD,18));
	userLabel.setHorizontalAlignment(SwingConstants.CENTER);
	rightPanel.add(userLabel);

	this.add(rightPanel, constraints);
	
	
	//Option buttons for admin
	JPanel buttonPanel = new JPanel();
	buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
	constraints.gridx = 4;
	constraints.gridy = 2;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	
	button1 = new JButton();
	button1.setText("Crear nueva temporda");
	
	button2 = new JButton();
	button2.setText("Subir un resultado real");
	
	button3 = new JButton();
	button3.setText("Volver al menu principal");
	
	button4 = new JButton();
	button4.setText("Salir de la aplicacion");
	
		//Action listeners
	button1.addActionListener(this);
	button2.addActionListener(this);
	button3.addActionListener(this);
	button4.addActionListener(this);
	
		//Set size
	button1.setMaximumSize(new Dimension(200,50));
	button2.setMaximumSize(new Dimension(200,50));
	button3.setMaximumSize(new Dimension(200,50));
	button4.setMaximumSize(new Dimension(200,50));
	
	button1.setPreferredSize(new Dimension(100, 40));
	button2.setPreferredSize(new Dimension(200, 40));
	button3.setPreferredSize(new Dimension(100, 40));
	button4.setPreferredSize(new Dimension(200, 40));
	
		//JLabel for options
	
	JLabel optionsLabel = new JLabel();
	optionsLabel.setText("Menu de Administrador");
	optionsLabel.setFont(new Font("MV Boli",Font.PLAIN,20));
	optionsLabel.setHorizontalAlignment(SwingConstants.CENTER);

		//addition to BoxLayout
	buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
	buttonPanel.add(optionsLabel);
	buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
	buttonPanel.add(button1);
	buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
	buttonPanel.add(button2);
	buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
	buttonPanel.add(button3);
	buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
	buttonPanel.add(button4);
	buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
	
		//addition of constraints
	
	this.add(buttonPanel, constraints);
	
	
	//Addition of Title for menu
	JLabel title = new JLabel();
	title.setText("Bienvenido/a a Ultimate Soccer Fantasy, ¡vamos a jugar!");
	title.setFont(new Font("MV Boli",Font.BOLD,30));
	
	constraints.gridx = 0;
	constraints.gridy = 0;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	
	this.add(title, constraints);
	
	
	// Addition of left console panel
	this.textArea = new JTextArea(18,50);
	
	PrintStream printStream = new PrintStream( new CustomOutputStream( textArea ));
	System.setOut(printStream);
	//System.setErr(printStream);
	
	textArea.setLineWrap(true);
	textArea.setFont(new Font("MV Boli",Font.PLAIN,16));
	textArea.setText("Bienvenido/a Administrador, selecciona una opción del menú para comenzar.\n");
	textArea.setEditable(false);
	JScrollPane scrollPane = new JScrollPane(textArea);
	
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridwidth = 3;
	constraints.gridheight = 2;
	

	this.add(scrollPane, constraints);
	
	constraints.weightx = 0;
	constraints.weighty = 0;
	
	
	//Escribe aqui JLabel
	
	JLabel writeHere = new JLabel();
	writeHere.setText("Escribe aqui:");
	writeHere.setFont(new Font("MV Boli",Font.BOLD,15));
	writeHere.setHorizontalAlignment(SwingConstants.CENTER);
	
	constraints.gridx = 0;
	constraints.gridy = 3;
	constraints.gridwidth = 2;
	constraints.gridheight = 1;

	this.add(writeHere, constraints);
	
	
	//Text field where user input goes
	JPanel inputZone = new JPanel();
	inputZone.setLayout(new FlowLayout());
	
	constraints.gridx = 0;
	constraints.gridy = 4;
	constraints.gridwidth = 1;
	constraints.gridheight = 2;
	constraints.weightx = 1.0;
	
	this.inputField = new JTextField();
	inputField.setPreferredSize(new Dimension(600, 40));
	inputField.setFont(new Font("MV Boli",Font.PLAIN,25));
	inputField.setBackground(Color.white);
	inputField.setForeground(Color.black);
	
	this.inputButton = new JButton();
	inputButton.setText("Enviar");
	inputButton.addActionListener(this);
	
	inputZone.add(inputField);
	inputZone.add(inputButton);
	
	this.add(inputZone, constraints);
	
	constraints.weightx = 0;
	
	}
	
	
	
	
	//Metodo para leer inputs
	
	String actualString;
	
	public void pedirInputs() {
		
		this.textArea.append("\n**Escribe en el recuadro de abajo y oprime enviar**\n");
		
	}
	
	public String returnInputs() {
		
		return actualString;
		
	}
	
	
	


	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			
			this.textArea.setText("");
			
			this.conection = mainClass.conection;
			this.menu = conection.getMenu();
			JTextField inputField = this.inputField;
			
			//Complete
			this.textArea.append("\n****Se quiere crear una nueva temporada de juego****\n");
			
			this.LECTOR = menu.LECTOR;
			this.CREADOR = menu.CREADOR;
			
            this.nuevaTemporadaReal = CREADOR.crearTemporadaReal();
            this.nuevaTemporadaFantasia = CREADOR.crearTemporadaFantasia();

            //Llamado a metodo de Conection
            conection.crearNuevaTemporada(nuevaTemporadaFantasia);
            //

			textArea.append("\nAhora debes ingresar el archivo de los equipos que jugaran esta temporada\n");
			
			pedirInputs();
			
		
		
		}
		
		if(e.getSource()==inputButton) {
			
			
			//Paso 0
			if(this.paso.equals(0)) {
			
			String nombreArchivoEquipos = inputField.getText();
        
			int resu = LECTOR.leerArchivoEquiposReales(nombreArchivoEquipos, nuevaTemporadaReal, CREADOR);
			
			if(resu == 0) {
				
			textArea.append("No se encontro el archivo, vuelve a crear una temporada.\n");
			this.paso = 0;
			
				}
			
			else if(resu == 1) {
        
			textArea.append("\nAhora debes ingresar el archivo de los jugadores de los equipos\n");
			pedirInputs();
            
            this.paso = 1;
            
				}
            
			}
			
			
			//Paso 1
			else if(this.paso.equals(1)) {
			
			String nombreArchivoJugadores = inputField.getText();
            
            int resu = LECTOR.leerArchivoJugadoresReales(nombreArchivoJugadores, nuevaTemporadaReal, CREADOR);
            
			if(resu == 0) {
				
			textArea.append("\nVuelve a crear una temporada.\n");
			this.paso = 0;
			
				}
			
			else if(resu == 1) {
      
            
            textArea.append("\nAhora debes ingresar el archivo de las fechas de esta temporada\n");
            pedirInputs();
            
            this.paso = 2;
            
				}
            
			}
			
			//Paso 2
			
			else if(this.paso.equals(2)) {
            
			String nombreArchivoFechas = inputField.getText();
      
            int resu = LECTOR.leerArchivoFechasReales(nombreArchivoFechas, nuevaTemporadaReal, CREADOR);
            
            
			if(resu == 0) {
				
			textArea.append("\nNo se encontro el archivo, vuelve a crear una temporada.\n");
			this.paso = 0;
				}
			
			else if(resu == 1) {
      
            
            textArea.append("\nPor favor cierra la aplicación y vuelve a iniciarla para confirmar tus cambios\n");
            
            this.paso = 0;
			}
			
			}
			
			
			//Pasos para funcion 2
			
			else if(this.paso.equals(3)) {
				
				String nombreArchivo = inputField.getText();
				textArea.append("\nA que fecha pertenece este resultado?\n");
				pedirInputs();
				this.paso = 4;
		
			}
			
			else if(this.paso.equals(4)) {
					
			
			try {
				
			int numeroFecha	= Integer.parseInt(inputField.getText());
			//llamar al siguiente paso de la ejecucion en la clase conection y pasarle este numero de fecha
			conection.subirNuevoResultado1(numeroFecha);
			
			//Llamar a funcion que imprime los equipos locales
			
			textArea.append("\nCual es el equipo local?\n");
			pedirInputs();
			this.paso = 5;
			
			} catch(Exception e1) {
				
				textArea.append("\nDebes pasar un numero, vuelve a subir el resultado.\n");
			}
				
			}
			
			else if(this.paso.equals(5)) {
				
				conection.subirNuevoResultado2();
				
			
				System.out.println("Cual es el equipo visitante?");
			/**	
            EquipoReal equipoLocal = imprimirEquiposTemporada();
            System.out.println("Cual es el equipo visitante?");
            EquipoReal equipoVisitante = imprimirEquiposTemporada();
            PartidoReal partido = fecha.buscarPartido(equipoLocal, equipoVisitante);
            LECTOR.leerResultadoPartido(nombreArchivo, temporadaActiva, partido, temporadaFantasiaActiva, CREADOR);
			**/
		}
			
			
		}
		
		
		
		else if(e.getSource()==button2) {  //Subir un resultado real
			this.textArea.setText("");
			
			this.paso = 3;
			textArea.append("\nIngresa el nombre del archivo:\n");
			pedirInputs();
			

		}
			
			
			
			
		
		else if(e.getSource()==button3) {
			
			FirstFrame = new FirstFrame();
			JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this); //Returns the Frame where the Panel is located
			topFrame.dispose(); //Closes that frame to leave only the new one for the Admin App.
			
		}
		
		else if(e.getSource()==button4) {
			
			System.exit(0);

		}
		
	} //cerrar action performed
		

} //cerrar clase
