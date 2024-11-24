package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

import DAOLojinha.TelefoneDAO;
import ModelLojinha.ModelarCliente;
import ModelLojinha.ModelarTelefone;
import DAOLojinha.ClienteDAO;
import DAOLojinha.ListaTelefoneDAO;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class CadastrarTelefone extends JFrame  {

	private JLabel lbTelefone;
	private JTextField txTelefone;
	private JLabel lbCliente;
	private JComboBox cbCliente;
	private JButton btCadastrarTelefone;
	private JButton btadicionarTelefone;
	
	
	ModelarTelefone Telefone = new ModelarTelefone();
	ListaTelefoneDAO salvarTelefone = new ListaTelefoneDAO();
	ModelarCliente cliente = new ModelarCliente();
	
	public CadastrarTelefone() throws SQLException {
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
		
		btadicionarTelefone = new JButton();
		btadicionarTelefone.setBounds(350, 250 ,200, 35);
		btadicionarTelefone.setText("Cadastrar telefone");
		add(btadicionarTelefone);
		
		lbCliente = new JLabel();
		lbCliente.setText("Cliente: ");
		lbCliente.setBounds(270, 210, 200, 15);
		add(lbCliente);
		
		List<ModelarCliente> clientes = new ClienteDAO().getLista();
		
		String[] nomeClientes = new String[clientes.size()];
		
		for (int i = 0; i < clientes.size(); i++) {
			nomeClientes[i] = clientes.get(i).getNomeCliente();
		}
		
		cbCliente = new JComboBox(nomeClientes);
		cbCliente.setBounds(350,200,300,35);
		add(cbCliente);
		
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
		
		btCadastrarTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				int idCliente = (int) clientes.get(cbCliente.getSelectedIndex()).getIdCliente(); // Le a Categoria
				cliente.setIdCliente(idCliente);
				System.out.println(idCliente);
					try {
						salvarTelefone.adicionarListaTelefone(cliente, Telefone);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
			}
		});
	}
}
