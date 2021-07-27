package Entidades;

import Enums.Simbolo;

public abstract class Computador extends Jogo {
	// Superclasse dos níveis do jogador computador
	Computador computador;
	protected Simbolo letra;

	public Computador getComputador() {
		return computador;
	}

	public Simbolo getLetra() {
		return letra;
	}

	public void setLetra(Simbolo letra) {
		this.letra = letra;
	}

	public abstract int[] comJogar(Tabuleiro tab);

}
