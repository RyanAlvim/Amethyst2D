package AmethystCenario;

public class Object {
	public double x;
	public double y;
	public int width;
	public int height;
	
	protected double rotacao = 0;
	
	public Object() {
		this.x=0.0D;
		this.y=0.0D;
		this.width=0;
		this.height=0;
	}
	
	public boolean colisao(Object obj) {
		return Colisao.collided(this, obj);
	}
}
