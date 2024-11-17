package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import DAOLojinha.TelefoneDAO;

import java.time.*;
import java.time.format.DateTimeFormatter;
import ModelLojinha.ModelarTelefone;

public class CadastrarTelefone extends JFrame  {

	private JLabel lbTelefone;
	private JTextField txTelefone;
	private JButton btCadastrarTelefone;
	
	ModelarTelefone Telefone = new ModelarTelefone();
	
	
	public CadastrarTelefone() {
		setTitle("Cadastrar Telefone");
		setSize(600, 400);
		this.setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		
		lbTelefone = new JLabel();
		lbTelefone.setText("Telefone");
		lbTelefone.setBounds(100, 100, 200 , 35);
		add(lbTelefone);
		
		txTelefone = new JTextField();
		txTelefone.setBounds(180, 100, 200 , 35);
		add(txTelefone);
		
		btCadastrarTelefone = new JButton();
		btCadastrarTelefone.setBounds(180, 150 ,200, 35);
		btCadastrarTelefone.setText("Cadastrar telefone");
		add(btCadastrarTelefone);
		
		
		btCadastrarTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
					String tl = txTelefone.getText();
					
					if (tl.equals("")) {
						JOptionPane.showMessageDialog(null, "Voce nao prencheu algum numero");
					} else {
						Telefone.setTelefone(tl);
						JOptionPane.showMessageDialog(null, Telefone.getTelefone() + " Adicionado");
					}
					
				
			}
		});
	}
}
