
import java.awt.Image;
import java.awt.Rectangle;

import images.Commons;

public class Sprites implements Commons {

	protected int dx;
	protected int dy;
	private boolean visibility = true;
	Image alien;

	public Sprites() {
		super();
	}

	public int getxPos() {
		return dx;
	}

	public int getyPos() {
		return dy;
	}

	public Image getImage() {
		return alien;
	}

	public void setImage(Image image) {
		alien = image;
	}

	public boolean isVisible() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public void move() {
		dy = dy + 2;
	}

	public Rectangle getBounds() {
		return new Rectangle(dx, dy, ALIEN_WIDTH, ALIEN_HEIGHT);
	}

	public void remove() {
		
	}

}