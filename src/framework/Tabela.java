package framework;

public abstract class Tabela {
	public final int NUM_LINHAS;
	public final int NUM_COLUNAS;
	
	protected int[][] grade;
	protected int linhasPreenchidas;
	
	public Tabela(int numLinhas, int numColunas) {
		NUM_LINHAS = numLinhas;
		NUM_COLUNAS = numColunas;
		this.grade = new int[NUM_LINHAS][NUM_COLUNAS];
		this.linhasPreenchidas = 0;
	}
	
	public int getNUM_LINHAS() {
		return NUM_LINHAS;
	}


	public  int getNUM_COLUNAS() {
		return NUM_COLUNAS;
	}


	public int getLinhasPreenchidas() {
		return linhasPreenchidas;
	}

	public void setLinhasPreenchidas(int linhasPreenchidas) {
		this.linhasPreenchidas = linhasPreenchidas;
	}

	public int getInGrade(int linha, int coluna) {
		return grade[linha][coluna];
	}

	public void setInGrade(int linha, int coluna, int valor) {
		this.grade[linha][coluna] = valor;
	}

	public abstract void gerarTabela(String tipo);
	
	
}
