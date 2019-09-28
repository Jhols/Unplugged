package framework;

import desafio_pixel.MotorPixel;

public class TabelaConsole extends Tabela {
	
	public TabelaConsole(int numLinhas, int numColunas) {
		super(numLinhas, numColunas);
	}

	public void gerarTabela(String tipo) { //Gera uma tabela em console com base no tipo de jogo
		for (int i = 0; i < NUM_LINHAS; i++) {
			for (int j = 0; j < NUM_COLUNAS; j++) {
				switch (tipo) {
					case "binaria":
						System.out.print(grade[i][j] + " ");
						break;
					case "pixel":
						System.out.print(MotorPixel.toChar(grade[i][j]) + " ");
						break;
					default:
						System.out.println("\nErro: Nao foi possivel gerar uma tabela.\n");
				}
			}
			System.out.println();
		}
	}
}
