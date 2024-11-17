package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

import javax.swing.*;

import ModelLojinha.ModelarCategoria;
import DAOLojinha.CategoriaDAO;

public class CadastrarCategoria extends JFrame {

	private JLabel lbCategoria;
	private JTextField txCategoria;
	private JButton btCadastrarCategoria;

	ModelarCategoria categoria = new ModelarCategoria();
	CategoriaDAO salvarCategoria = new CategoriaDAO();
	
	public CadastrarCategoria() {

		setTitle("Cadastrar Categoria");
		setSize(900, 600);
	    this.setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);

		lbCategoria = new JLabel();
		lbCategoria.setText("Categoria: ");
		lbCategoria.setBounds(415, 220, 70, 15);
		add(lbCategoria);

		txCategoria = new JTextField();
		txCategoria.setBounds(350, 260, 200, 35);
		add(txCategoria);

		btCadastrarCategoria = new JButton();
		btCadastrarCategoria.setText("Cadastrar");
		btCadastrarCategoria.setBounds(400, 325, 100, 35);

		btCadastrarCategoria.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				
				try {
					String cg = txCategoria.getText();
					categoria.setNomeCategoria(cg);
					salvarCategoria.adicionarCategoria(categoria);
					JOptionPane.showMessageDialog(null, cadastrarCategoria(cg) ? "Categoria: " + cg + " Cadastrada Com Sucesso" : "Categoria " + cg + " Nao Cadastrada Com Sucesso");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});

		add(btCadastrarCategoria);
	}

	public boolean cadastrarCategoria(String categoria) {
		return true;
	}
}