package jogo.velha;

import java.text.ParseException;

import Entidades.Jogo;

public class Main {

	public static void main(String[] args) {
		System.out.println("*Jogo da velha*");
		System.out.println("---------------");
		Jogo start = new Jogo();
		start.iniciarJogadores();

		do {
			start.jogar();

			System.out.println("---------------");
			start.imprimeJogo();

		} while (!start.isFimJogo());

		System.out.println("---------------");
	
		start.imprimeResultado();

	}

}
