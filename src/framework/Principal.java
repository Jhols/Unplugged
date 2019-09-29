package framework;

import java.util.Scanner;
import java.util.function.BinaryOperator;

import desafio_pixel.MotorPixel;
import enigma_binario.MotorBinario;

public class Principal {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Menu m = Menu.getInstance(); //Captura a única instância de menu
		m.rodar(); //Roda o menu da aplicação
		
	}

}
