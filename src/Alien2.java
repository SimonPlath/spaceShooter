import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import images.Commons;

public class Alien2 extends Sprites implements Commons {
	private Image alien2;
	public Alien2(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
		ImageIcon ii = new ImageIcon(this.getClass().getResource("images/alien2.gif"));
		setImage(ii.getImage());
	}
	
	public void move() {
		dy = dy + 4;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(dx, dy, ALIEN2_WIDTH, ALIEN2_HEIGHT);
	}
	
}
