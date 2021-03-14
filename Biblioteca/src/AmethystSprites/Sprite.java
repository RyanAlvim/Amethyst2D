package AmethystSprites;

import AmethystKeyBoard.Teclado;
import AmethystWindow.Janela;

public class Sprite extends Animacao{
	private double massa = 0.5D;
	private double atrito = 0.5D;
	private double rest = 0.5D;
	private double velocidadeY = 0.0D;
	
	public Sprite(String arquivo, int Frames) {
		super(arquivo,Frames);
		this.velocidadeY = 0.0D;
	}
	public void moverX(int esquerda, int direita, double velocidade) {
		Teclado teclado = Janela.getInstance().getTeclado();
		if(teclado.Tecla(esquerda) && this.x > 1.0D) {
			this.x -= velocidade;
		}
		if(teclado.Tecla(direita) && this.x + this.width < Janela.getInstance().getWidth()) {
			this.x += velocidade;
		}
	}
	public void moverY(int cima, int baixo, double velocidade) {
		Teclado teclado = Janela.getInstance().getTeclado();
		if(teclado.Tecla(cima) && this.y > 1.0D) {
			this.y -= velocidade;
		}
		if(teclado.Tecla(baixo) && this.y + this.height < Janela.getInstance().getHeight()) {
			this.y += velocidade;
		}
	}
	
	public void Mover(double x, double y, double velocidade) {
		if(this.x < x && this.x + this.width < Janela.getInstance().getWidth()) {
			this.x += velocidade;
		}else if(this.x > x) {
			this.x -= velocidade;
		}
		if(this.y > y) {
			this.y -= velocidade;
		}else if(this.y < y) {
			this.y += velocidade;
		}
	}
	public void setVelocidadeY(double velocidade) {
		this.velocidadeY = velocidade;
	}
	public double getVelocidadeY() {
		return this.velocidadeY;
	}
	public void setRest(double rest) {
		this.rest = rest;
	}
	public double getRest() {
		return this.rest;
	}
	public void setRotacao(double rotacao) {
		this.rotacao = -rotacao;
	}
	public double getRotacao() {
		return this.rotacao;
	}
	public void setAtrito(double atrito) {
		this.atrito = atrito;
	}
	public double getAtrito() {
		return this.atrito;
	}
	public void setMassa(double massa) {
		this.massa = massa;
	}
	public double getMassa() {
		return this.massa;
	}
	public double getY() {
		return this.y;
	}
	public double getX() {
		return this.x;
	}
	
	public void setAtributos(double massa, double atrito, double rest, double rotacao) {
		this.atrito = atrito;
		this.massa = massa;
		this.rotacao = rotacao;
		this.rest = rest;
	}
	
}
