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
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")

public class LogInPanels extends JPanel implements ActionListener{
	
	//Class parameters
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JPanel PlayerLogInPanel;
	JPanel AdminLogInPanel;
	JPanel FirstPanel;
	
	public LogInPanels() {
		
		
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
		title.setText("Inicio de Sesión en la Plataforma");
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
		selectText.setText("Selecciona una opcion:");
		selectText.setFont(new Font("MV Boli",Font.PLAIN,25));
		selectText.setPreferredSize(new Dimension(600, 80));
		selectText.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Options Buttons

		JPanel options = new JPanel();
		options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));
		options.setPreferredSize(new Dimension(400, 200));

		
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
		button1.setText("Como Participante");
		button2.setText("Como Administrador");
		button3.setText("Retroceder");
		button4.setText("Salir de la aplicacion");
		
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
		options.add(Box.createRigidArea(new Dimension(0,10)));
		options.add(button2);
		options.add(Box.createRigidArea(new Dimension(0,10)));
		options.add(button3);
		options.add(Box.createRigidArea(new Dimension(0,10)));
		options.add(button4);
		options.add(Box.createRigidArea(new Dimension(0,10)));
		
		
		//addition to main panel
		centerPanel.add(title, BorderLayout.NORTH);
		centerPanel.add(selectText, BorderLayout.CENTER);
		centerPanel.add(options, BorderLayout.SOUTH);
		
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(picLabel, BorderLayout.NORTH);
		
		this.setVisible(true);
	}

	
	/** 
	 * @param e
	 */
	//Actions performed in this Panel
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			
			//instance of Log in Panels
			this.PlayerLogInPanel = new PlayerLogInPanel();
			JPanel panelName = this.PlayerLogInPanel;
			
			this.removeAll();
			this.add(panelName);
			this.repaint();
			this.revalidate();
		}
		
		else if(e.getSource()==button2) {
			
			//instance of Log in Panels
			this.AdminLogInPanel = new AdminLogInPanel();
			JPanel panelName = this.AdminLogInPanel;
			
			this.removeAll();
			this.add(panelName);
			this.repaint();
			this.revalidate();
		}
		
		else if(e.getSource()==button3) {
			
			//instance of Log in Panels
			this.FirstPanel = new FirstPanel();
			JPanel panelName = this.FirstPanel;
			
			this.removeAll();
			this.add(panelName);
			this.repaint();
			this.revalidate();
		}
		
		else if(e.getSource()==button4) {

			System.exit(0);
		}
		
	}

	

}
