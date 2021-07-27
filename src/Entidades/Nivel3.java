package Entidades;

public class Nivel3 extends Computador {
//Esse n�vel vai preencher primeiro as colunas, e depois as linhas.
	@Override
	public int[] comJogar(Tabuleiro tab) {

		int[] computador = { 0, 0 };
		int linha = 0;
		int coluna = -1;

		do {
			coluna++;

			if (coluna > 2) {
				// depois de as linhas as linhas, pula pra pr�xima coluna
				coluna = 0;
				linha++;
			}
			computador[0] = linha;
			computador[1] = coluna;

		} while (!tab.isPosicaoLivre(computador[0], computador[1]));
		return computador;

	}
}
