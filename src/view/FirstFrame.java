package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class FirstFrame extends JFrame{
	
	//Class atributes
	
	
	public FirstFrame(){
		
		this.setTitle("Ultimate Soccer Fantasy"); //set title
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 
		this.setSize(600,800); //set size
		this.setLocationRelativeTo(null);
		
		//Icon image change
		ImageIcon icon = new ImageIcon("InterfaceFiles/AppIcon.png");
		this.setIconImage(icon.getImage());
		this.getContentPane().setBackground(new Color(230,230,230));
		
		//addition of First Panel Class
		FirstPanel firstPanel = new FirstPanel();
		
		this.add(firstPanel, BorderLayout.NORTH);
		
		
		
		this.setVisible(true); //Set visibility
	}
	
	
	//metodos
	
	
}
