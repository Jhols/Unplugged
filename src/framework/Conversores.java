package framework;

public class Conversores {
	//Converte inteiro em um número binário
		public static int toBinario(int numero) {
			int d = numero;
			StringBuffer binario = new StringBuffer(); // guarda os dados
			while (d > 0) {
				int b = d % 2;
				binario.append(b);
				d = d >> 1; // é a divisão que você deseja
			}
			return Integer.parseInt(binario.reverse().toString()); // inverte a ordem e retorna
		}
		
		//Função que converte inteiro em char
		public static char toChar(int num) { 
			char c = (char) num;
			return c;
		}
}
