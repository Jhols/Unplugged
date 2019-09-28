package framework;

import java.util.function.BinaryOperator;

import desafio_pixel.MotorPixel;
import enigma_binario.MotorBinario;

public class Principal {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tabela t1 = TabelaFabrica.getTabela("console", 6, 5);
		Tabela tab = TabelaFabrica.getTabela("console", 6, 8);
		String binario = "...@@..."+
						 "...@@@@."+
						 "@@@@@@@@"+
						 "...@@@@."+
						 "...@@...";
		
		String binario2 = "...@@..."+
						 "...@@@@."+
						 "@@@@@@@@"+
						 "...@@@@."+
						 "@@@@@..."+
						 "........";
		
		desafio_pixel.MotorPixel.inserirDesenho(tab, binario);
		
		System.out.println();
		//MotorBinario.inserirPalavra(tab, "zzzz");
		tab.gerarTabela("binaria");
		System.out.println();
		MotorPixel.gerarTabela(tab, binario);
		System.out.println();
		MotorBinario.imprimirBinario("jovem");
		
		//((TabelaConsole) tab).alimentarPalavra("zzzz"); 
		//tab.gerarTabela();
		//t1.gerarTabela();
		/*System.out.println();
		String palavra = "abc";
		int bits = Principal.binario(Integer.getInteger(palavra, palavra.charAt(0)-64));
		((TabelaConsole) t1).alimentarPalavra(palavra.toUpperCase());
		
		//System.out.println(binario);
		if ((tab.NUM_LINHAS*tab.NUM_COLUNAS) > binario.length()) {
			for (int i = binario.length()+1; i < tab.NUM_LINHAS*tab.NUM_COLUNAS; i++) {
				binario = binario + "0";
			}
		}*/
		//System.out.println("\n"+binario);
		System.out.println();
		//t2.gerarTabela();
		
		
	}

}
