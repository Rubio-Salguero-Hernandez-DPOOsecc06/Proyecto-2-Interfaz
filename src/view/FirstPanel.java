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

@SuppressWarnings("serial")

public class FirstPanel extends JPanel implements ActionListener{
	
	FirstPanel(){
		
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
		selectText.setText("Selecciona una opción del siguiente menú:");
		selectText.setFont(new Font("MV Boli",Font.PLAIN,25));
		selectText.setPreferredSize(new Dimension(600, 100));
		selectText.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Options Buttons

		JPanel options = new JPanel();
		options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));

		
		JButton button1 = new JButton(); //Iniciar sesion
		JButton button2 = new JButton(); //Registro	
		JButton button3 = new JButton(); //Salir de la aplicacion
		
		
		//alignments
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button2.setAlignmentX(Component.CENTER_ALIGNMENT);
		button3.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Set text
		button1.setText("Iniciar sesión");
		button2.setText("Registrarse en la plataforma");
		button3.setText("Salir de la aplicación");
		
		//Set size
		button1.setMaximumSize(new Dimension(200,50));
		button2.setMaximumSize(new Dimension(200,50));
		button3.setMaximumSize(new Dimension(200,50));
		
		button1.setPreferredSize(new Dimension(200, 40));
		button2.setPreferredSize(new Dimension(200, 40));
		button3.setPreferredSize(new Dimension(200, 40));
		
		

		options.add(button1);
		options.add(Box.createRigidArea(new Dimension(0,10)));
		options.add(button2);
		options.add(Box.createRigidArea(new Dimension(0,10)));
		options.add(button3);
		options.add(Box.createRigidArea(new Dimension(0,35)));
		
		//Credits label
		JLabel credits = new JLabel();
		credits.setText("Aplicación construida por el Grupo 5 del curso de DPOO. Semestre 2022-20");
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
