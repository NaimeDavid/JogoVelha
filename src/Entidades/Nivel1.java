package Entidades;

import java.util.Random;

public class Nivel1 extends Computador {
	//O n�vel1 gera dois n�meros aleatorios de 0 a 2, e usa como indices.
					
	@Override
	 public int[] comJogar(Tabuleiro tab) {
		
		 int[] computador = {0,0};
		 Random gerador = new Random();
			
		do {
		/*
		Testa se os dois numeros usados como indices,j� est�o ocupados na matriz
		isPosicaoLivre deve retornar Null.
		*/
			computador[0] = gerador.nextInt(3);
			computador[1] = gerador.nextInt(3);
		}while(!tab.isPosicaoLivre(computador[0],computador[1]));
				
		return computador;
		
		} 
		
	}
