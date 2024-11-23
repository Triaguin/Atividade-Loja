package Loljinha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;

import ModelLojinha.ModelarProduto;
import DAOLojinha.CategoriaDAO;
import DAOLojinha.ProdutoDAO;

public class ConsultarProduto extends JFrame {

	private JScrollPane scrollTabela;
	private JTable tabelaProduto;
	private String[] atributos;
	Object[][] dados;

	ModelarProduto produto = new ModelarProduto();
	ProdutoDAO salvarProduto = new ProdutoDAO();
	
	public ConsultarProduto() throws SQLException {

		setTitle("Consultar Produto");
		setSize(900, 600);
		setLocationRelativeTo(null);

		atributos = new String[] {"Nome", "Valor", "Quantidade", "Categoria"};
		dados = listaParaMatriz();
		tabelaProduto = new JTable(dados, atributos);
		scrollTabela = new JScrollPane(tabelaProduto);
		this.add(scrollTabela);
		
	}

	public Object[][] listaParaMatriz() throws SQLException {
		
		List<ModelarProduto> lista =  new ProdutoDAO().getLista();
		
		Object[][] matriz = new Object[lista.size()][4];
		for (int i = 0; i < lista.size(); i++) {
			matriz[i][0] = lista.get(i).getNomeProduto();
			matriz[i][1] = lista.get(i).getValorProduto();
			matriz[i][2] = lista.get(i).getQuantidadeProduto();
			matriz[i][3] = new CategoriaDAO().getCategoria(lista.get(i).getIdCategoria()).getNomeCategoria();
		}
		
		return matriz;
	}
}