package framework;

public class Conversores {
	//Converte inteiro em um n�mero bin�rio
		public static int toBinario(int numero) {
			int d = numero;
			StringBuffer binario = new StringBuffer(); // guarda os dados
			while (d > 0) {
				int b = d % 2;
				binario.append(b);
				d = d >> 1; // � a divis�o que voc� deseja
			}
			return Integer.parseInt(binario.reverse().toString()); // inverte a ordem e retorna
		}
		
		//Fun��o que converte inteiro em char
		public static char toChar(int num) { 
			char c = (char) num;
			return c;
		}
}
