package Entidades;

import java.util.InputMismatchException;
import java.util.Scanner;

import Enums.Simbolo;

//Essa classe pega as jogadas da pessoa (o jogador) e controla o jogo 
public class Jogo {
	final Scanner sc = new Scanner(System.in);
	private Jogador humano = new Jogador();
	private Computador computador;
	private Tabuleiro tab = new Tabuleiro();
	int nivel;

	public void iniciarJogadores() {

		try {
			System.out.print("Escolha a sua peça (x/o): ");
			String pecaEscolhida = sc.next();

			final Simbolo escolhido = Simbolo.getEnum(pecaEscolhida);
			humano.setLetra(escolhido);

			System.out.print("Insira o nível do computador (1/2/3): ");
			nivel = sc.nextInt();

			if (nivel == 1) {
				computador = new Nivel1();

			} else if (nivel == 2) {
				computador = new Nivel2();

			} else if (nivel == 3) {
				computador = new Nivel3();
			}
			// simbolo do jogador Computador:
			if (escolhido == Simbolo.X) {
				computador.setLetra(Simbolo.O);
			} else {
				computador.setLetra(Simbolo.X);
			}
			tab.imprimir();

		} catch (InputMismatchException a) {
			System.out.println("Formato de entrada inválido!");
			return;
		} catch (NullPointerException a) {
			// Se inserir nível não existente instancia direto pro jogador Nivel1.
			System.err.println("Nível inválido!");
			System.out.println("Nível atribuído: 1");
			computador = new Nivel1();
			if (humano.getLetra() == Simbolo.X) {
				computador.setLetra(Simbolo.O);
			} else {
				computador.setLetra(Simbolo.X);
			}
		}

	}

	public void jogar() {

		int linha, coluna;
		int[] auxComp;
		boolean podeInserir = false;

		try {
			do {

				System.out.println();
				System.out.print("Escolha a linha: ");
				linha = sc.nextInt();

				System.out.print("Escolha a coluna: ");
				coluna = sc.nextInt();
				// Primeiro verifica se a posição está vazia na matriz, depois insere

				podeInserir = tab.isPosicaoLivre(linha, coluna);
				if (!podeInserir) {
					System.err.println("Posição ocupada! Tente novamente.");
				}
				tab.inserir(linha, coluna, humano.getLetra());

			} while (!podeInserir);

			tab.inserir(linha, coluna, humano.getLetra());

		} catch (InputMismatchException a) {
			System.err.println("Formato de entrada inválido! Insira valores de 0 a 2.");
			sc.next(); // descarta o valor inserido
			do {
				System.out.print("Linha: ");
				linha = sc.nextInt();

				System.out.print("Coluna: ");
				coluna = sc.nextInt();
				podeInserir = tab.isPosicaoLivre(linha, coluna);
				tab.inserir(linha, coluna, humano.getLetra());
			} while (!podeInserir);

		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.println();
			System.err.println("Indice inválido! Escolhas linhas e colunas conforme abaixo: ");

			System.out.println("     0    1    2");
			System.out.println(" 0  [00] [01] [02]");
			System.out.println(" 1  [10] [11] [12]");
			System.out.println(" 2  [20] [21] [22]");
			System.out.println();
			return;
		}
// Jogada do computador:
		if (!tab.isFimJogo()) {
			auxComp = computador.comJogar(tab);
			tab.inserir(auxComp[0], auxComp[1], computador.getLetra());
		}
		if (tab.isFimJogo()) {
			tab.getVencendor();
			return;
		}
	}

// depois de fazer as jogadas, os metodos vão verificar se a tabela tá cheia.
	public boolean isFimJogo() {
		return tab.isFimJogo();

	}

	public void imprimeJogo() {
		tab.imprimir();

	}

	public void imprimeResultado() {
		/*
		 * O getVencedor() verifica linhas, colunas, diagonais, a variável
		 * "vencendorTabuleiro" vai salvar o simbolo
		 */
		final Simbolo vencendorTabuleiro = tab.getVencendor();

		if (vencendorTabuleiro != null) {
			System.err.println("Vencendor: " + vencendorTabuleiro);
		} else {
			System.err.println("Fim de jogo - Empatou!!!");
		}

		if (vencendorTabuleiro == humano.getLetra()) {
			System.err.println("Você venceu!!!");
		} else if (vencendorTabuleiro == computador.getLetra())
			System.err.println("Você perdeu!!!");

	}

}
