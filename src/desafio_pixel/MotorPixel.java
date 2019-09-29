package desafio_pixel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import framework.Conversores;
import framework.Motor;
import framework.Tabela;
import framework.TabelaConsole;

public class MotorPixel extends Motor {
	
	public MotorPixel() {
		super("pixel");
	}
	
	public MotorPixel(int linhas, int colunas, int qtdNiveis) {
		super(linhas, colunas, qtdNiveis, "pixel");
	}
	
	public void rotina(int nivel) {
		//Tabela telaJogador = new TabelaConsole(NUM_LINHAS_TAB, NUM_COLUNAS_TAB);
		
		/*String binPadrao = "........"
						 + "........"
						 + "........"
						 + "........"
						 + "........"
						 + "........"
						 + "........"
						 + "........";
		*/
		
		String binario = "";
		//String regex = "^(?i)[a-zA-z]\\d{1,}"; //Expressão regular que confere as coordenadas da tabela
		
		switch(nivel) {
			case 1:
				binario = "..@@@..."
						+ ".....@.."
						+ "..@@@@.."
						+ ".@...@.."
						+ ".@...@.."
						+ "..@@@@.."
						+ "........"
						+ "........";
				break;
				
			case 2:
				binario = "........"
						+ "....@..."+
						  "....@@.."+
						  "@@@@@@@."+
						  "@@@@@@@@"+
						  "@@@@@@@."+
						  "....@@.."+
						  "....@...";
				break;
		}
		
		tab.setLinhasPreenchidas(0);
		inserirNaGrade(tab, binario);
		
		tab.gerarTabela(TIPO_JOGO);
		//lerLinha(tab, binario, 0);
		//telaJogador.gerarTabela(TIPO_JOGO);
		
		System.out.println("\nDigite o codigo binario correspondente a imagem:\n"
						+ "Legenda:\n"
						+ "   ZERO -> .\n"
						+ "   UM -> @\n");
		System.out.print("> ");
		
		String p = new Scanner(System.in).next();
		
		if (p.length() < binario.length()) {
			for (int i = p.length(); i < binario.length(); i++) {
				p += '.';
			}
		}
		
		/*if(p.matches(regex)) {
			p = p.toUpperCase();
			int linha = p.charAt(0) - 65;
			int coluna = p.charAt(1) - 48;
			
			
		}*/
		
		if (p.equals(binario)) {
			System.out.println("Parabens! Codigo Correto!");
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
	
	//Função que insere um desenho na grade da tabela, com base numa string de valores binários
	public void inserirNaGrade(Tabela tab, String binario) {
		
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
	public static void gerarTabelaCartesiana(Tabela tab, String binario) {

		if ((tab.NUM_LINHAS*tab.NUM_COLUNAS) > binario.length()) {
			//Formatação preenchendo zeros no final do número binário
			for (int i = binario.length()+1; i <= tab.NUM_LINHAS*tab.NUM_COLUNAS; i++) {
				binario = binario + "0";
			}
		}
		
		//Este trecho imprime uma sequencia de numeros no plano cartesiano do desenho
		char a = 'A';
		System.out.print("   ");
		for (int i = 0; i < tab.NUM_COLUNAS; i++) {
			System.out.print(i+1 + " "); //Imprime sequencia de numeros no plano cartesiano
		}
		System.out.println();
		
		int cursor=0;
		for (int i = 0; i < tab.NUM_LINHAS; i++) {
			System.out.print(Conversores.toChar(a+i) + "  "); //Imprime sequencia de letras no plano cartesiano
			
			for (int j = 0; j < tab.NUM_COLUNAS; j++) { // Imprime bit por bit para formar o desenho
				System.out.print(binario.charAt(cursor)+ " ");
				cursor++;
			}
			lerLinha(tab, binario, i);
			System.out.println();
		}
	}

	public static void lerLinha(Tabela tab, String binario, int linha) {
		int zeros = 0, uns = 0, cursor= (linha+1)*tab.NUM_COLUNAS - tab.NUM_COLUNAS;
		List<Object> sequencia = new ArrayList<Object>();
		
		for (int j = 0; j < tab.NUM_COLUNAS; j++) { // Imprime bit por bit para formar o desenho
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
		System.out.print(")");
		
	}
	
}