package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
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

@SuppressWarnings("serial")

public class GamePanel extends JPanel implements ActionListener{

	//Atributes
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	FirstFrame FirstFrame;
	
	//Panel Definition
	
	public GamePanel() {
	
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
		backImage = ImageIO.read(new File("InterfaceFiles/Game.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	Image dimg = backImage.getScaledInstance(420, 230,
	        Image.SCALE_SMOOTH);
	
	ImageIcon dimgRe = new ImageIcon(dimg);
	
	JLabel picLabel = new JLabel(dimgRe);	
	
	rightPanel.add(picLabel); //Here
	
		//Addition of text to rightPanel
	
	JLabel userLabel = new JLabel();
	userLabel.setText("    Informacion de temporada");
	userLabel.setFont(new Font("MV Boli",Font.BOLD,25));
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
	button1.setText("Juega con tu equipo");
	
	button2 = new JButton();
	button2.setText("Crea tu equipo de fantasia");
	
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
	optionsLabel.setText("   Menu de juego");
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
	title.setText("              Ultimate Soccer Fantasy              ");
	title.setFont(new Font("MV Boli",Font.BOLD,26));
	
	constraints.gridx = 0;
	constraints.gridy = 0;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	
	this.add(title, constraints);
	
	
	// Addition of left console panel
	JTextArea textArea = new JTextArea(18,50);
	textArea.setLineWrap(true);
	textArea.setFont(new Font("MV Boli",Font.PLAIN,18));
	textArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam nunc nisl, tristique et felis ut, consequat volutpat libero. Pellentesque venenatis feugiat feugiat. Donec cursus ligula sed ipsum venenatis, ac bibendum ex convallis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Cras vehicula tellus et aliquet mattis. Praesent non mauris vehicula, semper lectus at, fermentum nunc. Aliquam erat volutpat. Donec non velit leo.\r\n"
			+ "\r\n"
			+ "Etiam accumsan condimentum nunc, in condimentum justo posuere eget. In congue justo eros, ac sodales ex pretium eget. Proin pulvinar pretium consequat. Duis rutrum urna ut arcu feugiat, non rutrum urna venenatis. Nunc at.");
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
	JTextField inputField = new JTextField();
	inputField.setPreferredSize(new Dimension(600, 40));
	inputField.setFont(new Font("MV Boli",Font.PLAIN,25));
	inputField.setBackground(Color.white);
	inputField.setForeground(Color.black);
	
	constraints.gridx = 0;
	constraints.gridy = 4;
	constraints.gridwidth = 1;
	constraints.gridheight = 2;
	constraints.weightx = 1.0;
	
	this.add(inputField, constraints);
	
	constraints.weightx = 0;
	
	}
	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			
			//Juega con tu equipo de fantasia
			
			//creacion de una instancia de una nueva clase panel para mostrar los botones de juego

		}
		
		else if(e.getSource()==button2) {
			
			//Crea tu equipo de fantasia

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
	
	
}
