package Jogador;

import AmethystKeyBoard.Teclado;
import AmethystSprites.Sprite;

public class Jogador extends Sprite{

	public Jogador(int posicaoX, int posicaoY) {
		super("jogador.png",20);
		this.x = posicaoX;
		this.y = posicaoY;
	}
	
	public void seMover() {
		moverX(Teclado.ESQUERDA, Teclado.DIREITA, 0.3);
	}

}
