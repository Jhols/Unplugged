package enigma_binario;

import framework.Principal;
import framework.Tabela;
import framework.TabelaConsole;
import framework.TabelaFabrica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import framework.Conversores;

public class MotorBinario extends framework.Motor {
	
	private String palavra = null;
	
	public MotorBinario() {
		super("binaria");
	}
	
	public MotorBinario(int linhas, int colunas, int qtdNiveis) {
		super(linhas, colunas, qtdNiveis, "binaria");
	}
	
	@Override
	public void rotina(int nivel) {
		
		String p = null;
		
		switch(nivel) {
			case  1:
				setPalavra("ROBO");
				break;
			case 2:
				setPalavra("JOVEM");
				break;
		}
		
		System.out.println("Transforme cada linha em um valor decimal e descubra qual a palavra com base na legenda abaixo:");
		
		tab.setLinhasPreenchidas(0);
		inserirNaGrade(tab, palavra);
		tab.gerarTabela(TIPO_JOGO);
		
	
		int totalLetras = 26;
		
		System.out.println("\nLegenda:");
		for (int i = 1; i <= totalLetras; i++) {
			if (i<10)
				System.out.print("0");
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 65; i < 65+totalLetras; i++) {
			char c = (char) i;
			System.out.print(" " + c + " ");
		}
		System.out.println();
		
		System.out.println("\nDigite a palavra que corresponde ao enigma:");
		
		p = new Scanner(System.in).next();
		p = p.toUpperCase();
		
		System.out.println("\nPalavra: "+ getPalavra());
		if (p.equals(getPalavra())) {
			System.out.println("Parabens! Palavra Correta!");
			setTrofeus(nivel-1, 1);
		}
		//else if (p.equals("L"+)) Aplicar expressão regular
		else
			System.out.println("Voce Errou!");
		
		try {
			char c = (char) System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Método que insere uma palavra em binário na grade da tabela
	@Override
	public void inserirNaGrade(Tabela tab, String palavra) {
		
		int bits; //armazena temporariamente um caractere da palavra em binário
		
		palavra = palavra.toUpperCase(); //Deixa as letras maiusculas		
		
		for (int i = 0; i < palavra.length(); i++) {
			int saltos = 0; //Pula um conjunto de colunas para escrever o binário na posição certa da tabela
			bits = Conversores.toBinario(Integer.getInteger(palavra, palavra.charAt(i)-64)); 
			
			//Este trecho serve para formatar a grade, acrescentando zeros à esquerda do número binário
			for (int j = 0; j < tab.getNUM_COLUNAS() - Integer.toString(bits).length(); j++) {
				tab.setInGrade(tab.getLinhasPreenchidas(), j, 0); //Preenche um zero na posição da grade
				saltos++;
			}
			
			//Insere na grade o número binário correspondente ao caractere
			for (int j = 0; j < Integer.toString(bits).length(); j++) {
				int digito = Integer.toString(bits).charAt(j)-48;
				tab.setInGrade(tab.getLinhasPreenchidas(), j + saltos, digito);
			}
			tab.setLinhasPreenchidas(tab.getLinhasPreenchidas()+1); //Incrementa o contador de linhas preenchidas
		}
	}
	
	//Transforma uma palavra em números binários
	public static void imprimirBinario(String palavra) {
		palavra = palavra.toUpperCase(); //Deixa as letras maiusculas
		
		int bits = Conversores.toBinario(Integer.getInteger(palavra, palavra.charAt(0)-64));
		
		for (int i = 0; i < palavra.length(); i++) { //imprime binario da palavra
			bits = Conversores.toBinario(Integer.getInteger(palavra, palavra.charAt(i)-64));
			System.out.print(palavra.charAt(i));
			System.out.println(" " + String.format("%05d", bits));
		}
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	
}
