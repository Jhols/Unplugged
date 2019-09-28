package framework;

import java.util.function.BinaryOperator;

import desafio_pixel.motor;

public class Principal {
	
	public static int binario(int numero) {
		int d = numero;
		StringBuffer binario = new StringBuffer(); // guarda os dados
		while (d > 0) {
			int b = d % 2;
			binario.append(b);
			d = d >> 1; // é a divisão que você deseja
		}
		return Integer.parseInt(binario.reverse().toString()); // inverte a ordem e retorna
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tabela t1 = TabelaFabrica.getTabela("console", 6, 5);
		Tabela tab = TabelaFabrica.getTabela("console", 6, 8);
		String binario = "..000..."+
						 "..0000."+
						 "00000000"+
						 "..00000."+
						 "..000...";
		
		//desafio_pixel.motor.inserirDesenho(tab, binario);
		int a = '*';
		System.out.println(a);
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
