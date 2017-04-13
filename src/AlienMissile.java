import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import images.Commons;

public class AlienMissile implements Commons {
	
	private int dx;
	private int dy;
	private Image enemyMissile;
	private boolean visibility = true;
	
	public AlienMissile(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
		ImageIcon ii = new ImageIcon(this.getClass().getResource("images/laser2.png"));
		setImage(ii.getImage());
	}
	
	public void setImage(Image image) {
		enemyMissile = image;
	}
	
	public Image getImage() {
		return enemyMissile;
	}
	
	public int getxPos() {
		return dx;
	}
	
	public int getyPos() {
		return dy;
	}
	
	public void move() {
		dy = dy + 4;
	}
	
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
	
	public boolean isVisible() {
		return visibility;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(dx, dy, ALIEN_MISSILE_WIDTH, ALIEN_MISSILE_HEIGHT);
	}

}
