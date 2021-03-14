package Inimigo;

import AmethystSprites.Sprite;

public class Inimigo extends Sprite{
	
	public Inimigo(int positionX, int positionY) {
		super("inimigo.png",1);
		this.x = positionX;
		this.y = positionY;
		this.setVelocidadeY(0.4);
	}

}
