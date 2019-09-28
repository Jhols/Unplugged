package framework;

public class TabelaConsole extends Tabela {
	
	public TabelaConsole(int numLinhas, int numColunas) {
		super(numLinhas, numColunas);
	}

	public void gerarTabela() {
		for (int i = 0; i < NUM_LINHAS; i++) {
			for (int j = 0; j < NUM_COLUNAS; j++) {
				System.out.print(grade[i][j] + " ");						
			}
			System.out.println();
		}
	}
	
	public void alimentarPalavra(String palavra) {
		//int bits = Principal.binario(Integer.getInteger(palavra, palavra.charAt(0)-64));
		/*for (int i = 0; i < palavra.length(); i++) { //imprime binario da palavra
			bits = Principal.binario(Integer.getInteger(palavra, palavra.charAt(i)-64));
			System.out.print(palavra.charAt(i));
			System.out.println(" " + String.format("%0" + getNUM_COLUNAS() + "d", bits));
			setInGrade(linhasPreenchidas, i, bits);
		}*/
		int bits;
		for (int i = 0; i < palavra.length(); i++) {
			int saltos = 0;
			bits = Principal.binario(Integer.getInteger(palavra, palavra.charAt(i)-64));
			
			for (int j = 0; j < getNUM_COLUNAS() - Integer.toString(bits).length(); j++) {
				setInGrade(linhasPreenchidas, j, 0);
				saltos++;
			}
			
			for (int j = 0; j < Integer.toString(bits).length(); j++) { //imprime binario da letra
				int digito = Integer.toString(bits).charAt(j)-48;
				setInGrade(linhasPreenchidas, j + saltos, digito);
			}
			linhasPreenchidas++;
		}
		
		gerarTabela();
	}

}
