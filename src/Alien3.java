import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import images.Commons;

public class Alien3 extends Sprites implements Commons {

	private Image alien3;
	private int missileCounter = 0;
	private boolean missileReady = false;
	
	public Alien3(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
		ImageIcon ii = new ImageIcon(this.getClass().getResource("images/alien3.gif"));
		setImage(ii.getImage());
	}
	
	public void setMissileReady() {
		 if (missileCounter > 70) {
			 missileReady = true; 
			 missileCounter = 0;
		 } else {
			 missileReady = false;
		 }
	}
	
	public void move() {
		dy = dy + 1;
		missileCounter++;
	}
	
	public boolean getMissileReady() {
		return missileReady;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(dx, dy, ALIEN3_WIDTH, ALIEN3_HEIGHT);
	}
	
}
