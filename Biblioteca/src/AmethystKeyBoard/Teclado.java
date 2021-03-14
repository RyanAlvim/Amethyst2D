package AmethystKeyBoard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Hashtable;

public class Teclado implements KeyListener {
	public static final int ENTER = 10;
	public static final int ESC = 27;
	public static final int ESPACO = 32;
	public static final int ESQUERDA = 37;
	public static final int CIMA = 38;
	public static final int DIREITA = 39;
	public static final int BAIXO = 40;
	
	private Hashtable ListKey;
	
	public Teclado() {
		this.ListKey = new Hashtable<>();
		addTecla(38, 0);
	    addTecla(37, 0);
	    addTecla(39, 0);
	    addTecla(40, 0);
	    addTecla(27, 1);
	    addTecla(32, 1);
	    addTecla(10, 1);
	}
		
	public boolean Tecla(int key) {
		if(this.ListKey.containsKey(Integer.valueOf(key))) {
			Action action = (Action)this.ListKey.get(Integer.valueOf(key));
			return action.isPressed();
		}
		return false;
		
	}
	
	public void addTecla(int key) {
		addTecla(key,1);
	}
	
	public void addTecla(int key, int comportamento) {
		removekey(key);
		this.ListKey.put(Integer.valueOf(key), new Action(comportamento));
	}
	
	public void removekey(int key) {
		this.ListKey.remove(Integer.valueOf(key));
	}
	
	public void setComportamento(int key, int comportamento) {
		if(this.ListKey.containsKey(Integer.valueOf(key))) {
			addTecla(key, comportamento);
		}
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(this.ListKey.containsKey(Integer.valueOf(key))) {
			Action action = (Action)this.ListKey.get(Integer.valueOf(key));
			action.press();
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(this.ListKey.containsKey(Integer.valueOf(key))) {
			Action action = (Action)this.ListKey.get(Integer.valueOf(key));
			action.release();
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}


}
