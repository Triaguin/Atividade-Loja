package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.*;
public class TelaSobre extends JFrame {
	
	private JButton btsobre;
	
	public TelaSobre() {		
		this.setTitle("Sobre");
	    this.setSize(900,600);  
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);		
	    setLayout(null);
	    
	    btsobre = new JButton();
	    btsobre.setText("Ver sobre a gente ");
	    btsobre.setBounds(350,200,200,100);
	    add(btsobre);
	    
	    btsobre.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e) {
	    		JOptionPane.showMessageDialog(null, "lol");
	    	}
	    	
	    });
	    
	}
}
