package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.*;
public class TelaSobre extends JFrame {
	
	private JLabel lbLeonardo;
	private JLabel lbTiago;
	
	public TelaSobre() {		
		this.setTitle("Sobre");
	    this.setSize(900,600);  
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);		
	    setLayout(null);
	    
	    lbLeonardo = new JLabel();
	    lbLeonardo.setText("Feito por Leonardo Lima de Souza Loper N 28");
	    lbLeonardo.setBounds(300, 250, 300, 15);
	    add(lbLeonardo);
	    
	    lbTiago = new JLabel();
	    lbTiago.setText("e Tiago Soares de Magalhaes N 40");
	    lbTiago.setBounds(300, 270, 300, 15);
	    add(lbTiago);
	    
	}
}
