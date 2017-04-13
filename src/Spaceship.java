import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import images.Commons;

public class Spaceship extends JFrame implements Commons {
	
//CONSTANTS

//VARIABLES
private boolean visible = true;
protected boolean dying;
 int dx;
private int dy;
Image sonic;

int speed = 5;
	
	public Spaceship() {
		ImageIcon ii =  new ImageIcon(this.getClass().getResource("images/spaceship1.png"));
		setImage(ii.getImage());
		dx = S_INITIAL_X;
		dy = S_INITIAL_Y;
	}
	
	public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
	
	public void setImage(Image image) {
		this.sonic = image;
	}
	
	public Image getImage() {
		return sonic;
	}
	
	public int getSonicWidth() {
		return SPACESHIP_WIDTH;
	}
	
	public int getSonicHeight() {
		return SPACESHIP_HEIGHT;
	}
	
	public int getSonicDx() {
		return dx;
	}
	
	public int getSonicDy() {
		return dy;
	}
	public void moveLeft() {
		if (dx > 0) {
		dx = dx - 6;
		}
	}
	public void moveRight() {
		if (dx < BOARD_WIDTH - 40) {
		dx = dx + 6;
		}
	}
	public void moveUp() {
		dy = dy - 6;
	}
	public void moveDown() {
		dy = dy + 6;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(dx, dy, SPACESHIP_WIDTH, SPACESHIP_HEIGHT);
	}
}   
	
