package Loljinha;


import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

import javax.swing.*;

import DAOLojinha.ClienteDAO;
import ModelLojinha.ModelarCliente;

public class ExcluirCliente extends JFrame {
	
	private JLabel lbCliente;
	private JTextField txCliente;
	private JButton btExcluirCliente;
	
	ModelarCliente cliente = new ModelarCliente();
	ClienteDAO excluirCliente = new ClienteDAO();
	public ExcluirCliente() {

		setTitle("Excluir Cliente");
		setSize(900, 800);
		this.setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		
		lbCliente = new JLabel();
		lbCliente.setText("Nome: ");
		lbCliente.setBounds(300, 100, 300, 15);
		add(lbCliente);

		txCliente = new JTextField();
		txCliente.setBounds(300, 115, 300, 35);
		add(txCliente);
		
		btExcluirCliente.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				
				try {
					int idcliente = Integer.parseInt(txCliente.getText());
					cliente.setIdCliente(idcliente);
					excluirCliente.excluirCliente(cliente);
					JOptionPane.showMessageDialog(null, "Cliente Excluida com sucesso!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Algo deu errado");
				}
				
				
			}
		});

		add(btExcluirCliente);
		
	}
	
}
