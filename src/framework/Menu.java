package framework;

import java.util.Scanner;

import desafio_pixel.MotorPixel;
import enigma_binario.MotorBinario;

public class Menu {
	
	private static Menu singleton = null;
	
	private Menu() {
		//Construtor
	}
	
	//M�todo que retorna a �nica inst�ncia de menu
	public static Menu getInstance() {
		if (singleton == null)
			singleton = new Menu();
		
			return singleton;
	}
	
	//Menu da aplica��o
	public void rodar() {
		int p;
		
		do {
			limparTela();
			System.out.println("..:.::10110 -UNplUggED- 01010::.:..\n");
			System.out.println("Selecione um jogo para jogar:\n"
							 + "1 - Enigma Binario\n"
							 + "2 - Desafio Pixel\n"
							 + "\n"
							 + "0 - Encerrar");
			System.out.print("\n> ");
			
			p = new Scanner(System.in).nextInt();
			
			if (p>0) {
				switch(p) {
				case 1: //Enigma Bin�rio
					Motor mb = new MotorBinario();
					menuJogo(mb);
					break;
					
				case 2: //Desafio Pixel
					Motor mp = new MotorPixel();
					menuJogo(mp);
					break;
				}	
			}
		}while(p!=0);
		
	}
	
	//Menu do jogo
	public void menuJogo(Motor m) {
		int nivel = 0;
		do {
			limparTela();
			System.out.println("Selecione um nivel de dificuldade (Zero para encerrar):");
			System.out.println("Nivel      Trofeu");
			for (int i = 0; i < m.QTD_NIVEIS; i++) {
				System.out.print(" "+ (i+1));
				if (m.getTrofeus(i) == 1) { // Apresenta um trofeu, caso o usu�rio j� tenha vencido o nivel
					System.out.print("            Y");
				}
				System.out.println();
			}
			System.out.print("\n> ");
			
			nivel = new Scanner(System.in).nextInt();
			if (nivel>0) {
				limparTela();
				m.rotina(nivel); // Chama a rotina que executa o motor do jogo				
			}
		} while(nivel != 0);
	}
	
	//Fun��o que limpa o console
	public void limparTela() {
		for (int i = 0; i < 50; ++i) System.out.println ();
	}
}
