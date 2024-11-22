package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;

import ModelLojinha.ModelarCategoria;
import DAOLojinha.CategoriaDAO;

public class ConsultarCategoria extends JFrame {

	private JScrollPane scrollTabela;
	private JTable tabelaCategoria;
	private String[] atributos;
	Object[][] dados;

	ModelarCategoria categoria = new ModelarCategoria();
	CategoriaDAO salvarCategoria = new CategoriaDAO();
	
	public ConsultarCategoria() throws SQLException {

		setTitle("Consultar Categoria");
		setSize(900, 600);
	    this.setResizable(false);
		setLocationRelativeTo(null);

		atributos = new String[] {"Nome"};
		dados = listaParaMatriz();
		tabelaCategoria = new JTable(dados, atributos);
		scrollTabela = new JScrollPane(tabelaCategoria);
		this.add(scrollTabela);
		
	}

	public Object[][] listaParaMatriz() throws SQLException {
		
		List<ModelarCategoria> lista =  new CategoriaDAO().getLista();
		
		Object[][] matriz = new Object[lista.size()][1];
		
		for (int i = 0; i < lista.size(); i++) {
			matriz[i][0] = lista.get(i).getNomeCategoria();
		}
		
		return matriz;
	}
}