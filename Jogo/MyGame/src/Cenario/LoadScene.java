package Cenario;


import java.util.Random;

import AmethystCenario.Imagem;
import AmethystWindow.Janela;
import Inimigo.Inimigo;
import Jogador.Jogador;
import Main.Main;
import Pontos.Moedas;

public class LoadScene {
	private Janela janela;
	private Imagem imagem;
	private Inimigo inimigo;
	private Inimigo inimigo2;
	private Jogador player;
	private int x = 450;
	private int y = 10;
	private int pontos = 0;
	private Moedas moeda;
	private Random random;
	private int numeroMoeda[] = {500,680,789,698,799,120,789,655};
	public LoadScene() {
		janela = new Janela(1000, 800);
		imagem = new Imagem("cena.jpg");
		player = new Jogador(640, 750);
		random = new Random();
		moeda = new Moedas(numeroMoeda[random.nextInt(numeroMoeda.length)], 720);
		
	}
	
	public void run() {
		for(;;) {
			inimigo = new Inimigo(x,y);
			inimigo2 = new Inimigo(200, y);
			imagem.mostrar();
			inimigo.mostrar();
			inimigo2.mostrar();
			moeda.mostrar();
			player.mostrar();
			player.seMover();
			janela.run();
			if(inimigo.y < 2500) {			
				y++;
			}else {
				y=10;
			}
			
			if(inimigo.colisao(player)) {
				janela.message("Você Morreu! Pontos:" + pontos);
				janela.dispose();
				new Main().Game();
			}
			if(player.colisao(moeda)) {
				pontos++;
				moeda.x = numeroMoeda[random.nextInt(numeroMoeda.length)];
			}
		
		}
	}
}
