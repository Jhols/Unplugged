package framework;

public abstract class Motor {
	public final int NUM_LINHAS_TAB;
	public final int NUM_COLUNAS_TAB;
	public final int QTD_NIVEIS;
	public final String TIPO_JOGO;
	
	protected Tabela tab = null;
	protected int[] trofeus; 
	
	
	public Motor(int linhas, int colunas, int qtdNiveis, String tipo_jogo) {
		NUM_LINHAS_TAB = linhas;
		NUM_COLUNAS_TAB = colunas;
		QTD_NIVEIS = qtdNiveis;
		TIPO_JOGO = tipo_jogo;
		trofeus = new int[QTD_NIVEIS];
		tab = TabelaFabrica.getTabela("console", NUM_LINHAS_TAB, NUM_COLUNAS_TAB);
	}
	
	public Motor(String tipo_jogo) {
		this(8, 8, 5, tipo_jogo);
	}

	public Motor() {
		this("binaria");
	}

	public abstract void rotina(int nivel);
	
	public abstract void inserirNaGrade(Tabela tab, String texto);

	public int getTrofeus(int indice) {
		return trofeus[indice];
	}

	public void setTrofeus(int indice, int valor) {
		this.trofeus[indice] = valor;
	}
	
}
