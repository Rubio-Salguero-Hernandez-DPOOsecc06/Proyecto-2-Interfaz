package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")

public class PlayerAppFrame extends JFrame{

	//Class atributes
	PlayerAppPanel PlayerAppPanel;
	
	
	public PlayerAppFrame() {
		
		this.setTitle("Ultimate Soccer Fantasy - Participante"); //set title
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(1280,720); //set size
		this.setLocationRelativeTo(null);
		
		ImageIcon icon = new ImageIcon("InterfaceFiles/AppIcon.png");
		this.setIconImage(icon.getImage());
		this.getContentPane().setBackground(new Color(230,230,230));
		
		//addition of Admin App Panel Class
		
		this.PlayerAppPanel = new PlayerAppPanel();
		this.add(PlayerAppPanel, BorderLayout.NORTH);
		
		
		
		this.setVisible(true); //Set visibility
		
	}
	
	
}
