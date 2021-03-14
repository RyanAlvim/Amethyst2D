package AmethystWindow;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import AmethystKeyBoard.Teclado;

public class Janela extends JFrame{
	
	public static Janela instancia;
	private Teclado teclado = new Teclado();
	private BufferStrategy buffer;
	private long currTime;
	private long lastTime;
	private long totalTime;
	private Graphics graficos;
	private DisplayMode displayMode;
	private GraphicsDevice device;
	
	public Janela(int width, int height){
		device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		displayMode = new DisplayMode(width,height,16,0);
		addKeyListener(this.teclado);
		setDefaultCloseOperation(3);
		setSize(width,height);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
		createBufferStrategy(2);
		buffer = getBufferStrategy();
		graficos = this.buffer.getDrawGraphics();
		currTime = System.currentTimeMillis();
		lastTime =0L;
		totalTime = 0L;
		instancia = this;
	}
	public static Janela getInstance() {
		return instancia;
	}
	
	public Teclado getTeclado() {
		return this.teclado;
		
	}
	
	public Graphics getGameGraphics() {
		return this.graficos;
	}
	
	public void message(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	public void run() {
		graficos.dispose();
		buffer.show();
		Toolkit.getDefaultToolkit().sync();
		graficos = buffer.getDrawGraphics();
		lastTime = currTime;
		currTime = System.currentTimeMillis();
		totalTime += currTime - lastTime;
	}
	
	public void TextMessage(String message, int x, int y, Color color, Font font) {
	    Graphics2D g2 = (Graphics2D)this.graficos;
	    g2.setFont(font);
	    g2.setColor(color);
	    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
	        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	    g2.drawString(message, x, y);
	  }
	
	public void fechar() {
		this.dispose();
	}
	
	public void encerrar() {
		this.dispose();
		System.exit(0);
	}

}
