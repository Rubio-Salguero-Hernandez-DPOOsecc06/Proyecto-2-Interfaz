package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FirstFrame extends JFrame{
	
	FirstFrame(){
		this.setTitle("Ultimate Fantasy Soccer"); //set title
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 
		this.setSize(600,600); //set size
		this.setLocationRelativeTo(null);
		
		this.setVisible(true); //Set visibility
		
		//Icon image change
		ImageIcon icon = new ImageIcon("InterfaceFiles/AppIcon.png");
		this.setIconImage(icon.getImage());
		this.getContentPane().setBackground(new Color(230,230,230));
		
		
		
		
		
	}
}
