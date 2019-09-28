package desafio_pixel;

import framework.Tabela;

public class motor {
	public static void inserirDesenho(Tabela tab, String binario) {
		if ((tab.NUM_LINHAS*tab.NUM_COLUNAS) > binario.length()) {
			for (int i = binario.length()+1; i < tab.NUM_LINHAS*tab.NUM_COLUNAS; i++) {
				binario = binario + "0";
			}
		}
		int k = 0;
		for (int i = 0; i < tab.NUM_LINHAS-1; i++) {
			for (int j = 0; j < tab.NUM_COLUNAS; j++) {
				System.out.print(binario.charAt(k)+ " ");
				k++;
			}
			System.out.println();
		}
	}
}
