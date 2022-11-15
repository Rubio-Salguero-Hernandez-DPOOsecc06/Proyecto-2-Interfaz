package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Conection;


@SuppressWarnings("serial")

public class FirstPanel extends JPanel implements ActionListener{
	
	//Class parameters
	JButton button1;
	JButton button2;
	JButton button3;
	
	JPanel LogInPanels;
	JPanel PlayerRegisterPanel;
	
	Main mainClass;
	Conection conection;
	
	//getter for conection instance
	public Conection getConection() {
		return this.conection;
	}
	
	
	FirstPanel(){
		this.mainClass = new Main();
		this.conection = mainClass.conection;
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);
		this.setSize(500,500);    //Frame is 600x600
		this.setBounds(200, 200, 200, 200);
		
		//Subpanel to add centered elements
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		
		
		//addition of panel contents
		
		//TITLE 1
		JLabel title = new JLabel();
		title.setText("Bienvenido/a a Ultimate Soccer Fantasy");
		title.setFont(new Font("MV Boli",Font.BOLD,25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setPreferredSize(new Dimension(600, 100));
		title.setBackground(Color.white);
		title.setOpaque(true);
		
		//WELCOME IMAGE 1
		BufferedImage backImage = null;
		try {
			backImage = ImageIO.read(new File("InterfaceFiles/SoccerBall.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Image dimg = backImage.getScaledInstance(600, 350,
		        Image.SCALE_SMOOTH);
		
		ImageIcon dimgRe = new ImageIcon(dimg);
		
		JLabel picLabel = new JLabel(dimgRe);
		
		//SELECT AN OPTION LABEL
		
		JLabel selectText = new JLabel();
		selectText.setText("Selecciona una opcion del siguiente menu:");
		selectText.setFont(new Font("MV Boli",Font.PLAIN,25));
		selectText.setPreferredSize(new Dimension(600, 100));
		selectText.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Options Buttons

		JPanel options = new JPanel();
		options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));

		
		button1 = new JButton(); //Iniciar sesion
		button2 = new JButton(); //Registro	
		button3 = new JButton(); //Salir de la aplicacion
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
		//alignments
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button2.setAlignmentX(Component.CENTER_ALIGNMENT);
		button3.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Set text
		button1.setText("Iniciar sesion");
		button2.setText("Registrarse en la plataforma");
		button3.setText("Salir de la aplicacion");
		
		//Set size
		button1.setMaximumSize(new Dimension(200,50));
		button2.setMaximumSize(new Dimension(200,50));
		button3.setMaximumSize(new Dimension(200,50));
		
		button1.setPreferredSize(new Dimension(100, 40));
		button2.setPreferredSize(new Dimension(200, 40));
		button3.setPreferredSize(new Dimension(200, 40));
		
		

		options.add(button1, BorderLayout.CENTER);
		options.add(Box.createRigidArea(new Dimension(0,10)));
		options.add(button2, BorderLayout.CENTER);
		options.add(Box.createRigidArea(new Dimension(0,10)));
		options.add(button3, BorderLayout.CENTER);
		options.add(Box.createRigidArea(new Dimension(0,35)));
		
		//Credits label
		JLabel credits = new JLabel();
		credits.setText("Aplicacion construida por el Grupo 5 del curso de DPOO. Semestre 2022-20");
		credits.setHorizontalAlignment(SwingConstants.CENTER);
		credits.setFont(new Font("MV Boli",Font.PLAIN,15));
		
		
		
		//addition to main panel
		centerPanel.add(title, BorderLayout.NORTH);
		centerPanel.add(selectText, BorderLayout.CENTER);
		centerPanel.add(options, BorderLayout.SOUTH);
		
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(picLabel, BorderLayout.NORTH);
		this.add(credits, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	//Actions performed in this Panel
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {					//INICIAR SESION
			this.LogInPanels = new LogInPanels();
			JPanel panelName = this.LogInPanels;
			
			this.removeAll();
			this.add(panelName);
			this.repaint();
			this.revalidate();
			
			this.conection.prueba();
			
		}
		
		else if(e.getSource()==button2) {
			this.PlayerRegisterPanel = new PlayerRegisterPanel();
			JPanel panelName = this.PlayerRegisterPanel;
			
			this.removeAll();
			this.add(panelName);
			this.repaint();
			this.revalidate();
			
		}
		else if(e.getSource()==button3) {
			
			System.exit(0);
		}
		
	}
}
