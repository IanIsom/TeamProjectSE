package gameInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import GUI.P1GameArenaPanel;
import clientSubSystem.GameClient;

public class P1GameArenaControl implements ActionListener{

	private JPanel container;
	private GameClient client;
	
	public P1GameArenaControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client; 
	}
	
	
	public void actionPerformed(ActionEvent e) {
		//more to add later
		
	}
	
	
	
	
}
