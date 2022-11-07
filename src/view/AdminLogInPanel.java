package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AdminLogInPanel extends JPanel implements ActionListener{

	//Class parameters
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	
	public AdminLogInPanel(){
		
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
		title.setText("Inicio de sesión como Administrador");
		title.setFont(new Font("MV Boli",Font.BOLD,25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setPreferredSize(new Dimension(600, 80));
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
		selectText.setText("Selecciona una opción:");
		selectText.setFont(new Font("MV Boli",Font.PLAIN,25));
		selectText.setPreferredSize(new Dimension(600, 80));
		selectText.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Options Buttons

		JPanel options = new JPanel();
		options.setLayout(new GridLayout(4, 3, 10, 10));

		
		button1 = new JButton(); //Como Participante
		button2 = new JButton(); //Como Admin
		button3 = new JButton(); //Retroceder
		button4 = new JButton(); //Salir de la app
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		
		//alignments
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button2.setAlignmentX(Component.CENTER_ALIGNMENT);
		button3.setAlignmentX(Component.CENTER_ALIGNMENT);
		button4.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Set text
		button1.setText("Iniciar sesión como participante");
		button2.setText("Iniciar sesión como Administrador");
		button3.setText("Retroceder");
		button4.setText("Salir de la aplicación");
		
		//Set size
		button1.setMaximumSize(new Dimension(200,50));
		button2.setMaximumSize(new Dimension(200,50));
		button3.setMaximumSize(new Dimension(200,50));
		button4.setMaximumSize(new Dimension(200,50));
		
		button1.setPreferredSize(new Dimension(200, 40));
		button2.setPreferredSize(new Dimension(200, 40));
		button3.setPreferredSize(new Dimension(200, 40));
		button4.setMaximumSize(new Dimension(200,50));
		
		

		options.add(button1);

		options.add(button2);

		options.add(button3);
		
		options.add(button4);

		
		
		//addition to main panel
		centerPanel.add(title, BorderLayout.NORTH);
		centerPanel.add(selectText, BorderLayout.CENTER);
		centerPanel.add(options, BorderLayout.SOUTH);
		
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(picLabel, BorderLayout.NORTH);
		
		this.setVisible(true);
	}

	//Actions performed in this Panel
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			
			
			
		}
		
	}
}
