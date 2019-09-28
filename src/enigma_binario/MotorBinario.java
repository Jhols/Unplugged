package enigma_binario;

import framework.Principal;
import framework.Tabela;
import framework.TabelaConsole;

public class MotorBinario {
	
	//Converte inteiro em um n�mero bin�rio
	public static int toBinario(int numero) {
		int d = numero;
		StringBuffer binario = new StringBuffer(); // guarda os dados
		while (d > 0) {
			int b = d % 2;
			binario.append(b);
			d = d >> 1; // � a divis�o que voc� deseja
		}
		return Integer.parseInt(binario.reverse().toString()); // inverte a ordem e retorna
	}
	
	//M�todo que insere uma palavra em bin�rio na grade da tabela
	public static void inserirPalavra(Tabela tab, String palavra) {
		
		int bits; //armazena temporariamente um caractere da palavra em bin�rio
		
		palavra = palavra.toUpperCase(); //Deixa as letras maiusculas		
		
		for (int i = 0; i < palavra.length(); i++) {
			int saltos = 0; //Pula um conjunto de colunas para escrever o bin�rio na posi��o certa da tabela
			bits = toBinario(Integer.getInteger(palavra, palavra.charAt(i)-64)); 
			
			//Este trecho serve para formatar a grade, acrescentando zeros � esquerda do n�mero bin�rio
			for (int j = 0; j < tab.getNUM_COLUNAS() - Integer.toString(bits).length(); j++) {
				tab.setInGrade(tab.getLinhasPreenchidas(), j, 0); //Preenche um zero na posi��o da grade
				saltos++;
			}
			
			//Insere na grade o n�mero bin�rio correspondente ao caractere
			for (int j = 0; j < Integer.toString(bits).length(); j++) {
				int digito = Integer.toString(bits).charAt(j)-48;
				tab.setInGrade(tab.getLinhasPreenchidas(), j + saltos, digito);
			}
			tab.setLinhasPreenchidas(tab.getLinhasPreenchidas()+1); //Incrementa o contador de linhas preenchidas
		}
	}
	
	//Transforma uma palavra em n�meros bin�rios
	public static void imprimirBinario(String palavra) {
		palavra = palavra.toUpperCase(); //Deixa as letras maiusculas
		
		int bits = toBinario(Integer.getInteger(palavra, palavra.charAt(0)-64));
		
		for (int i = 0; i < palavra.length(); i++) { //imprime binario da palavra
			bits = toBinario(Integer.getInteger(palavra, palavra.charAt(i)-64));
			System.out.print(palavra.charAt(i));
			System.out.println(" " + String.format("%05d", bits));
		}
	}
}
