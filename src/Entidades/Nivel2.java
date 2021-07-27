package Entidades;

public class Nivel2 extends Computador {
	//O Nivel2 vai preencher a matriz na esquerda pra direita, preenchendo primeiro as linhas e depois as colunas.
	
	@Override
	public int[] comJogar(Tabuleiro tab) {
		int[] computador = { 0, 0 };
		int linha = -1;
		int coluna = 0;

		do {
			linha++;

			if (linha > 2) {
				//depois de as linhas as linhas, pula pra próxima coluna
				linha = 0;
				coluna++;
			}
			computador[0]=linha;
			computador[1]=coluna;
			
		} while (!tab.isPosicaoLivre(computador[0], computador[1]));
		return computador;
	}

}