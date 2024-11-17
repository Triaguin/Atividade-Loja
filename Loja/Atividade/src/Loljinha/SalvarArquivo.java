package Loljinha;

import java.io.*;
import javax.swing.JOptionPane;

public class SalvarArquivo extends Menu {
	
	public void salvarArquivo() {
		
		File arquivo = new File ("semnome.java");
		try {
		if (arquivo.createNewFile()) {
			JOptionPane.showMessageDialog(null, arquivo.getName() + " criado com sucesso em : " + arquivo.getAbsolutePath());
	      } else {
	    	  JOptionPane.showMessageDialog(null, "Arquivo ja existente");
	      }
		}catch (IOException e1) {
			JOptionPane.showMessageDialog(null,"Um erro aconteceu");
      e1.printStackTrace();
    }
	}
	
}
