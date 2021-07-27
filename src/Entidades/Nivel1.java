package Entidades;

import java.util.Random;

public class Nivel1 extends Computador {
						
	@Override
	 public int[] comJogar(Tabuleiro tab) {
		
		 int[] computador = {0,0};
		 Random gerador = new Random();
			
		do {
		
			computador[0] = gerador.nextInt(3);
			computador[1] = gerador.nextInt(3);
		}while(!tab.isPosicaoLivre(computador[0],computador[1]));
				
		return computador;
		
		} 
		
	}
