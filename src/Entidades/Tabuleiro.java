package Entidades;

import Enums.Simbolo;

public class Tabuleiro {

	private static final int MAX_MATRIZ = 3;
	private Simbolo[][] matrizTab = new Simbolo[MAX_MATRIZ][MAX_MATRIZ];
	
	public boolean isFimJogo() {
		// Se qualquer um dos retornos forem TRUE, esse metodo termina a execu��o do jogo.
		return verificaTabuleiroCompleto() || verificaColunaIguais() || verificaLinhaIguais()
				|| verificaDiagonalIgual();
	}

	// A matriz recebe x e y (linha e coluna). O enum Simbolo da rodada � inserido na posi��o.
	public void inserir(int x, int y, Simbolo simbolo) {
		matrizTab[x][y] = simbolo;
	}


	public boolean isPosicaoLivre(int x, int y) {
		// M�todo pra verificar se a posi��o j� est� ocoupada.
		//Se retornar null, est� vazio.
		return matrizTab[x][y] == null;
	}
	
	public void imprimir() {
		//m�todo pra imprimir as jogadas
		System.out.println();
		for (int linha = 0; linha < 3; linha++) {
			for (int col = 0; col < 3; col++) {
				if (matrizTab[linha][col] == null) {
					System.out.print("[ ]");
				} else
					System.out.printf("[%s]", matrizTab[linha][col]);
			}
			System.out.println();
		}
	}

	private boolean verificaLinhaIguais() {
		//esse m�todo vai percorrer as Linhas e verificar se as posi��es est�o ocupadas
		boolean status = false;

		for (int linha = 0; linha < MAX_MATRIZ; linha++) {
			status = true;
		
			for (int col = 1; col < MAX_MATRIZ; col++) {
				if (matrizTab[linha][col] == null || matrizTab[linha][0] == null
						|| matrizTab[linha][0] != matrizTab[linha][col]) {
					status = false;//se != null, muda o status pra informar que n�o tem linhas iguais
					break;
				}
			}
			if (status) {
				//se retornar true, tem linhas iguais, ent�o � fim de jogo em 'isFimJogo()'.
				break;
			}
		}
		return status;
	}

	private boolean verificaColunaIguais() {
		boolean status = false;
		// essa � a mesma l�gica da verificaLinhaIguais()		
		 
		for (int coluna = 0; coluna < MAX_MATRIZ; coluna++) {
			status = true;

			for (int linha = 0; linha < MAX_MATRIZ; linha++) {

				if (matrizTab[linha][coluna] == null || matrizTab[0][coluna] == null
						|| matrizTab[0][coluna] != matrizTab[linha][coluna]) {
					status = false;
					break;
				}
			}
			if (status) {
				break;
			}
		}
		return status;
	}

	private boolean verificaDiagonalIgual() {
		// pra verificar as diagonais, apenas comparei os indices.
		if (matrizTab[0][0] != null && matrizTab[1][1] != null && matrizTab[2][2] != null
				&& matrizTab[0][0] == matrizTab[1][1] && matrizTab[2][2] == matrizTab[1][1]) {
			return true;
			//Precisam estar preenchidas e com os 3 indices iguais.
		}

		if (matrizTab[0][2] != null && matrizTab[1][1] != null && matrizTab[2][0] != null
				&& matrizTab[0][2] == matrizTab[1][1] && matrizTab[1][1] == matrizTab[2][0]) {
			return true;
		}
		return false;
	}

	public Simbolo getVencendor() {
		// Esses ifs comparam se os indices s�o iguais, linha e coluna pra pegar o Simbolo do vencedor.
		if (matrizTab[0][0] == matrizTab[1][1] && matrizTab[2][2] == matrizTab[1][1]) {
			return matrizTab[0][0];
		}

		if (matrizTab[0][2] == matrizTab[1][1] && matrizTab[1][1] == matrizTab[2][0]) {
			return matrizTab[0][2];
		}
		
		for (int linha = 0; linha < MAX_MATRIZ; linha++) {
			Simbolo vencendor = null;

			for (int col = 1; col < MAX_MATRIZ; col++) {
				vencendor = matrizTab[linha][col];

				if (matrizTab[linha][0] != matrizTab[linha][col]) {
					vencendor = null;// Se ficar null, deu empate.
					break;
				}
			}

			if (vencendor != null) {
				return vencendor;
			}
		}

		for (int coluna = 0; coluna < MAX_MATRIZ; coluna++) {
			Simbolo vencendor = null;

			for (int linha = 0; linha < MAX_MATRIZ; linha++) {
				vencendor = matrizTab[linha][coluna];

				if (matrizTab[0][coluna] != matrizTab[linha][coluna]) {
					vencendor = null;
					break;
				}
			}
			if (vencendor != null) {
				return vencendor;
			}
		}
		return null;
	}

	private boolean verificaTabuleiroCompleto() {
		boolean status = true;

		for (int coluna = 0; coluna < MAX_MATRIZ; coluna++) {
			for (int linha = 0; linha < MAX_MATRIZ; linha++) {

				if (matrizTab[linha][coluna] == null) {
					// Se tiver algum indice null, ent�o ainda tem posi��es de inser��o.
					status = false;
					break;
				}
			}
			if (!status) {
				//Se retornar true, o tabuleiro est� completo.
				break;
			}
		}
		return status;
	}
}
