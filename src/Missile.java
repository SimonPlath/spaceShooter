import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import images.Commons;

public class Missile extends JFrame implements Commons {
	private int dx, dy;
	private Image missile;
	Spaceship spaceship;
	private boolean visible = true;
	
	public Missile(int dx, int dy) {
		ImageIcon ii = new ImageIcon(this.getClass().getResource("images/bullet.png"));
		setImage(ii.getImage());
		spaceship = new Spaceship();
		this.dx = dx;
		this.dy = dy;
	}
	public void setImage(Image image) {
		this.missile = image;
	}
	
	public int getxPos(){
		return dx;
	}
	
	public int getyPos() {
		return dy;
	}
	public Image getImage() {
		return missile;
	}
	
	public void moveMissile() {
		dy = dy - 4;
	}
	public void setVisibility(boolean visible) {
		this.visible = visible;
	}
	public boolean isVisible() {
		return visible;
	}
	public Rectangle getBounds() {
		return new Rectangle(dx, dy, MISSILE_WIDTH, MISSILE_HEIGHT);
	}
	
}
