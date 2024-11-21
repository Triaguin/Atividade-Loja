package prjExemploDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import DAO.ProdutoDao;
import Model.Produto;

public class app {

	public static void main(String[] args) throws SQLException {
		
		Scanner ler = new Scanner(System.in);
		
		Produto produto = new Produto(); // Criando outro objeto que esta em outro packge
		List<Produto> produtos = new ProdutoDao().getLista(); // Cria uma lista dos produtos que ja estao no bd
		
		System.out.println("O que voce deseja fazer");
		
		switch(ler.nextInt()) {
		
		case 1:
			
			//Insere os atributos
			System.out.println("Insira o nome do produto");
			produto.setNomeProduto(ler.next()); 
			System.out.println("Insira o valor do produto");
			produto.setValorProduto(ler.nextDouble());
			
			// Salvando os valores
			new ProdutoDao().adicionarProduto(produto);
			
			break;
			
		case 2:
			
			//Mostra os produtos do banco
			
			for (Produto prod : produtos) { //Mostra os Valores
				System.out.println(prod.getIdProduto() + " " + prod.getNomeProduto() + " " + prod.getValorProduto());
			}
			
			//Insere os atributos
			System.out.println("Insira o id do produto");
			produto.setIdProduto(ler.nextInt());
			System.out.println("Insira o novo nome do produto");
			produto.setNomeProduto(ler.next());
			System.out.println("Insira o novo valor do produto");
			produto.setValorProduto(ler.nextDouble());
			
			//Altera o produto
			new ProdutoDao().alterar(produto);
			
			break;
			
		case 3:
			
			for (Produto prod : produtos) { //Mostra os Valores
				System.out.println(prod.getIdProduto() + " " + prod.getNomeProduto() + " " + prod.getValorProduto());
			}
			
			//Insere o id
			System.out.println("Insira o id do produto");
			produto.setIdProduto(ler.nextInt());
			
			//Exclui o produto
			new ProdutoDao().excluir(produto);
			break;
			
		}
		
		//Mostra os produtos do banco
		produtos = new ProdutoDao().getLista(); // Lendo os novos valores
		
		for (Produto prod : produtos) { //Mostra os Valores
			System.out.println(prod.getIdProduto() + " " + prod.getNomeProduto() + " " + prod.getValorProduto());
		}
		
	}

}
