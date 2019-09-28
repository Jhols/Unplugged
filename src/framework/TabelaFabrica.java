package framework;

public class TabelaFabrica {
	
	public static Tabela getTabela(String tipoTabela, int numLinhas, int numColunas) {
		
		if (tipoTabela == null) return null;
		
		else if (tipoTabela.equals("console")) return new TabelaConsole(numLinhas, numColunas);
		
		else if (tipoTabela.equals("gui")) return new TabelaGUI(numLinhas, numColunas);
		
		else return null;
	}
}

