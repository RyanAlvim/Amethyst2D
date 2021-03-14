package AmethystCenario;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

import AmethystWindow.Janela;

public class Imagem extends Object{
	 public Image image;
	  
	  public Imagem(String fileName) {
	    carregarImagem(fileName);
	  }
	  
	  public void carregarImagem(String fileName) {
	    ImageIcon icon = new ImageIcon(fileName);
	    this.image = icon.getImage();
	    this.width = this.image.getWidth(null);
	    this.height = this.image.getHeight(null);
	  }
	  
	  public void mostrar() {
	    Graphics2D g2d = (Graphics2D)Janela.getInstance().getGameGraphics();
	    AffineTransform tx = new AffineTransform();
	    double rot = this.rotacao;
	    tx.rotate(-rot, (this.width / 2), (this.height / 2));
	    int newy = (int)(this.x * Math.sin(rot) + this.y * Math.cos(rot));
	    int newx = (int)(this.x * Math.cos(rot) - this.y * Math.sin(rot));
	    g2d.setTransform(tx);
	    g2d.drawImage(this.image, newx, newy, this.width, this.height, null);
	  }

}
