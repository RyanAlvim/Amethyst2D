package AmethystCenario;

import java.awt.Point;

public class Colisao {
	public static boolean collided(Point min1, Point max1, Point min2, Point max2) {
	    if (min1.x >= max2.x || max1.x <= min2.x)
	      return false; 
	    if (min1.y >= max2.y || max1.y <= min2.y)
	      return false; 
	    return true;
	  }
	  
	  public static boolean collided(Object obj1, Object obj2) {
	    Point minObj1 = new Point((int)obj1.x, (int)obj1.y);
	    Point maxObj1 = new Point((int)(obj1.x + obj1.width), (int)(obj1.y + obj1.height));
	    Point minObj2 = new Point((int)obj2.x, (int)obj2.y);
	    Point maxObj2 = new Point((int)(obj2.x + obj2.width), (int)(obj2.y + obj2.height));
	    return collided(minObj1, maxObj1, minObj2, maxObj2);
	  }
}
