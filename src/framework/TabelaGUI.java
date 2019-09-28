package framework;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TabelaGUI extends Tabela {

	public TabelaGUI(int numLinhas, int numColunas) {
		super(numLinhas, numColunas);
	}

	@Override
	public void gerarTabela(String tipo) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "Nao existe implementacao grafica para este sistema ainda");
	}

}
