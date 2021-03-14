package AmethystSprites;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import AmethystCenario.Imagem;
import AmethystWindow.Janela;

public class Animacao extends Imagem {
	private int Frameinicial;
	private int Framecurr;
	private int Framefinal;
	private int Totalframe;
	private boolean playing;
	private boolean loop;
	private boolean draw;
	private long[] Durationframe;
	private long totalDuration;
	private long lastTime;
	private boolean Repeatanimation;
	private int Finalfram;
	private int initialFrame;
	private int currAnimFrame;
	private int currAnimFram;
	private long[] timeEachFrame;
	private boolean canDraw;
	private boolean AnimacaoFinished;
	
	
	public Animacao(String file, int Totalframe, boolean loop){
		super(file);
		this.Totalframe = Totalframe;
		this.width = this.image.getWidth(null) /Totalframe;
		this.height = this.image.getHeight(null);
		this.lastTime = System.currentTimeMillis();
		this.playing = true;
		this.draw = true;
		this.Durationframe = new long[Totalframe];
	}
	public Animacao(String file,int numFrame, int num) {
		super(file);
		this.width = this.image.getWidth(null) / numFrame;
		this.height = this.image.getHeight(null) / num;
		this.canDraw = true;
		this.Repeatanimation = true;
		this.Framefinal = numFrame;
		this.Finalfram = num;
		this.Frameinicial=0;
		this.initialFrame=0;
		this.currAnimFrame=0;
		this.currAnimFram = 0;
		this.timeEachFrame = new long[numFrame];
		this.lastTime = System.currentTimeMillis();
		this.AnimacaoFinished=false;
		
	}
	
	public void setMudancaFrame(long mudanca) {
		for(int i =0; i< this.timeEachFrame.length;i++) {
			this.timeEachFrame[i] = mudanca;
		}
	}
	
	public Animacao(String file, int FrameTotal) {
		this(file,FrameTotal,true);
	}
	public Animacao(String file) {
		this(file,1,true);
	}
	public void setDuracao(int frame,long time) {
		this.Durationframe[frame] = time;
	}
	public long getDuracao(int frame) {
		return this.Durationframe[frame];
	}
	public void setSequencia(int FrameInicio, int FrameFinal) {
		setSequencia(FrameInicio,FrameFinal,true);
	}
	public void setSequencia(int FrameInicio, int FrameFinal,boolean loop) {
		setInicioFrame(FrameInicio);
		setCurrFrame(FrameInicio);
		setFinalFrame(FrameFinal);
		setLoop(loop);
	}
	public void setSequencia(int FrameInicio, int FrameFinal, long time) {
		setSequencia(FrameInicio, FrameFinal,true,time);
	}
	public void setSequencia(int FrameInicio, int FrameFinal, boolean loop, long time) {
		setSequencia(FrameInicio, FrameFinal,loop);
		time /= (FrameFinal - FrameInicio + 1);
		for(int i = FrameInicio; i <= FrameFinal;i++) {
			this.Durationframe[i] = time;
		}
	}
	public boolean Looping() {
		return this.loop;
	}
	public void setDuracao(long time) {
		long timeF = time / this.Totalframe;
		this.totalDuration = timeF * this.Totalframe;
		for(int i =0; i < this.Durationframe.length; i++) {
			this.Durationframe[i] = timeF;
		}
	}
	
	public long getTotalDuracao() {
		return this.totalDuration;
	}
	
	public void update() {
		if(this.playing) {
			long time = System.currentTimeMillis();
			if(time - this.lastTime > this.Durationframe[this.Framecurr] && this.Finalfram != 0) {
				this.Framecurr++;
				this.lastTime = time;
			}
			if(this.Framecurr == this.Finalfram && this.loop) {
				this.Framecurr = this.initialFrame -1;
				this.playing = false;
			}
		}
	}
	public void stop() {
		this.Framecurr = this.initialFrame;
		this.playing=false;
	}
	public void play() {
		this.playing=true;
	}
	public void pause() {
		this.playing=false;
	}
	public void setInicioFrame(int frame) {
		this.initialFrame=frame;
	}
	public int getInicioFrame() {
		return this.initialFrame;
	}
	public void setFinalFrame(int frame) {
		this.Framefinal=frame;
	}
	public int getFinalFrame() {
		return this.Framefinal;
	}
	public void setCurrFrame(int frame) {
		this.Framecurr = frame;
	}
	public int getCurrFrame() {
		return this.Framecurr;
	}
	public boolean Playing() {
		return this.playing;
	}
	public void hide() {
		this.draw = false;
	}
	public void unhide(boolean value) {
		this.draw = value;
	}
	public void setLoop(boolean value) {
		this.loop = value;
	}
	public void mostrar() {
		if(this.draw) {
			double rot = this.rotacao;
		      Graphics2D g2d = (Graphics2D)Janela.getInstance().getGameGraphics();
		      AffineTransform tx = new AffineTransform();
		      tx.setToRotation(-rot, (this.width / 2), (this.height / 2));
		      int newy = (int)(this.x * Math.sin(rot) + this.y * Math.cos(rot));
		      int newx = (int)(this.x * Math.cos(rot) - this.y * Math.sin(rot));
		      g2d.setTransform(tx);
		      g2d.drawImage(this.image, newx, newy, newx + this.width, newy + this.height, 
		          this.Framecurr * this.width, 0, (this.Framecurr + 1) * this.width, this.height, null);
		    } 
	}
}
