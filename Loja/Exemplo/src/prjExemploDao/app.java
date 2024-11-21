package prjExemploDao;

import java.sql.SQLException;
import java.util.List;

import DAO.ProdutoDao;
import Model.Produto;

public class app {

	public static void main(String[] args) throws SQLException {
		
		Produto produto = new Produto(); // Criando outro objeto que esta em outro packge
		
		produto.setNomeProduto("Rosangela"); //Inserindo os atributos
		produto.setValorProduto(18);
		
		ProdutoDao produtoDao = new ProdutoDao(); // Salvando os valores
		produtoDao.adicionarProduto(produto);
		
//		produto.setIdProduto(1);
//		produto.setNomeProduto("Tiaguin"); //Inserindo os atributos
//		produto.setValorProduto(69);
//		new ProdutoDao().alterar(produto); //Altera o produto
		
//		produto.setIdProduto(2);
//		produto.setNomeProduto("Lima"); //Inserindo os atributos
//		produto.setValorProduto(24);
		
//		new ProdutoDao().excluir(produto); //Exclui o produto
		
		List<Produto> produtos = new ProdutoDao().getLista(); // Lendo os valores
//		
		for (Produto prod : produtos) { //Mostra os Valores
			System.out.println(prod.getIdProduto() + " " + prod.getNomeProduto() + " " + prod.getValorProduto());
		}
	}

}
