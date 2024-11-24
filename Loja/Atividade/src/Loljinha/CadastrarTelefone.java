package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import DAOLojinha.TelefoneDAO;
import ModelLojinha.ModelarTelefone;
import DAOLojinha.ClienteDAO;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class CadastrarTelefone extends JFrame  {

	private JLabel lbTelefone;
	private JTextField txTelefone;
	private JLabel lbCliente;
	private JComboBox cbCliente;
	private JButton btCadastrarTelefone;
	
	
	ModelarTelefone Telefone = new ModelarTelefone();
	
	public CadastrarTelefone() {
		setTitle("Cadastrar Telefone");
		setSize(900, 600);
		this.setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		
		lbTelefone = new JLabel();
		lbTelefone.setText("Telefone");
		lbTelefone.setBounds(270, 100, 200 , 35);
		add(lbTelefone);
		
		txTelefone = new JTextField();
		txTelefone.setBounds(350, 100, 200 , 35);
		add(txTelefone);
		
		btCadastrarTelefone = new JButton();
		btCadastrarTelefone.setBounds(350, 150 ,200, 35);
		btCadastrarTelefone.setText("Cadastrar telefone");
		add(btCadastrarTelefone);
		
		lbCliente = new JLabel();
		lbCliente.setText("Cliente: ");
		lbCliente.setBounds(270, 400, 200, 15);
		add(lbCliente);
		
		List<ModelarCliente> clietes = new ClienteDAO().getLista();
		
		String[] nomeClientes = new String[clientes..size()];
		
		
		btCadastrarTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
					String tl = txTelefone.getText();
					
					if (tl.equals("")) {
						JOptionPane.showMessageDialog(null, "Voce nao prencheu algum numero");
					} else {
						Telefone.setTelefone(tl);
						JOptionPane.showMessageDialog(null, Telefone.getTelefone() + " Adicionado");
						try {
							new TelefoneDAO().adicionarTelefone(Telefone);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
			
					
				
			}
		});
	}
}
