package desafio_pixel;

import java.util.ArrayList;
import java.util.List;

import framework.Tabela;

public class MotorPixel {
	
	//Função que converte inteiro em char
	public static char toChar(int num) { 
		char c = (char) num;
		return c;
	}
	
	//Função que insere um desenho na grade da tabela, com base numa string de valores binários
	public static void inserirDesenho(Tabela tab, String binario) {
		
		//Formatação acrescentando zeros no final do número binário
		if ((tab.NUM_LINHAS*tab.NUM_COLUNAS) > binario.length()) {
			for (int i = binario.length()+1; i <= tab.NUM_LINHAS*tab.NUM_COLUNAS; i++) {
				binario = binario + "0";
			}
		}
		
		//Este trecho armazena cada pixel na grade da tabela
		int k=0; //Cursor que percorre a string
		for (int i = 0; i < tab.NUM_LINHAS; i++) {
			for (int j = 0; j < tab.NUM_COLUNAS; j++) {
				if (	   binario.codePointAt(k) == '.'  //tipos de entrada
						|| binario.codePointAt(k) == '@'
						|| binario.codePointAt(k) == '0'
						|| binario.codePointAt(k) == '1'
					)
				{
					tab.setInGrade(i, j, binario.codePointAt(k)); //insere o pixel na grade			
				}
				else {
					System.out.println("\n\nErro: Formatacao errada! Utilize apenas '.', '@', '0' ou '1' para o codigo binario.\n");
					return;
				}
				k++; //incrementa o cursor para ler o próximo caractere
			}
		}
		
	}
	
	//Gera uma tabela formatada com coordenadas cartesianas
	public static void gerarTabela(Tabela tab, String binario) {
		if ((tab.NUM_LINHAS*tab.NUM_COLUNAS) > binario.length()) {
			//Formatação preenchendo zeros no final do número binário
			for (int i = binario.length()+1; i <= tab.NUM_LINHAS*tab.NUM_COLUNAS; i++) {
				binario = binario + "0";
			}
		}
		
		//Este trecho imprime uma sequencia de letras no plano cartesiano do desenho
		char a = 'A';
		System.out.print("    ");
		for (int i = 0; i < tab.NUM_COLUNAS; i++) {
			System.out.print(toChar(a+i) + " ");
		}
		System.out.println();
		
		int cursor = 0; // Posição atual da String do número binário
		List<Object> sequencia = new ArrayList<>(); //Armazena a quantidade seguida de zeros e uns que compõem o desenho
		for (int i = 0; i < tab.NUM_LINHAS; i++) {
			int zeros = 0, uns = 0;
			System.out.print(i+1 + "   "); //Imprime sequencia de numeros no plano cartesiano
			
			for (int j = 0; j < tab.NUM_COLUNAS; j++) { // Imprime bit por bit para formar o desenho
				System.out.print(binario.charAt(cursor)+ " ");
				if (binario.charAt(cursor) == '.' || binario.charAt(cursor) == '0') {
					if (cursor>0
							&& j!=0
							&& (binario.charAt(cursor-1) == '@'
							|| binario.charAt(cursor-1) == '1')
						)
					{
						sequencia.add(uns);						
					}
					zeros++;
					uns = 0;
				}
				else if (binario.charAt(cursor) == '@' || binario.charAt(cursor) == '1') {
					if (cursor>0 
							&& (binario.charAt(cursor-1) == '.'
							|| binario.charAt(cursor-1) == '0'
							|| binario.charAt(cursor-1) == ' '))
					{
						sequencia.add(zeros);						
					}
					uns++;
					zeros = 0;
				}
				else {
					System.out.println("\n\nErro: Formatacao errada! Utilize apenas '.', '@', '0' ou '1' para o codigo binario.\n");
					return;
				}
				cursor++;
			}
			if (zeros>0)
				sequencia.add(zeros);
			else if (uns>0)
				sequencia.add(uns);
			
			System.out.print("   (");
			for (int j = 0; j < sequencia.size()-1; j++) {
				System.out.print(sequencia.get(j).toString() + ", ");
			}
			System.out.print(sequencia.get(sequencia.size()-1).toString());
			sequencia.clear();
			System.out.println(")");
		}
	}
}
