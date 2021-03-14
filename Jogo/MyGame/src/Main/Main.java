package Main;

import AmethystCenario.Imagem;
import AmethystKeyBoard.Teclado;
import AmethystWindow.Janela;
import Cenario.LoadScene;

public class Main {

	
	public static void Game() {
		Janela janela = new Janela(510, 200);
		Teclado teclado = janela.getTeclado();
		Imagem imagem = new Imagem("cena1.png");
	
		for(;;) {
			imagem.mostrar();
			janela.run();
			if(teclado.Tecla(Teclado.ESC)) {
				janela.fechar();
			}
			if(teclado.Tecla(Teclado.ENTER)) {
				janela.fechar();
				new LoadScene().run();
			}
		}
	}
	
	public static void main(String[] args) {
		Game();
	}

}
