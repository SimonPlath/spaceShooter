import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import images.Commons;

public class PowerUp implements Commons {

int pointVal;
private boolean visible = true;
int yPos;
int xPos;
private int dx;
private Image powerup;

public PowerUp(int xPos, int yPos) {
	this.yPos = yPos;
	this.xPos = xPos;
	
	ImageIcon ii =  new ImageIcon(this.getClass().getResource("images/powerup.jpg"));
	setImage(ii.getImage());
}

public int getTokenHeight() {
	return TOKEN_HEIGHT;
}

public int getTokenWidth() {
	return TOKEN_WIDTH;
}

public int getXPos() {
	return xPos;
}

public int getYPos() {
	return yPos;
}

public int getPointVal() {
	return pointVal;
}

public void setImage(Image image) {
	this.powerup = image;
}

public Image getImage() {
	return powerup;
}

public boolean isVisible() {
	return visible;
}

public void setVisible(boolean visibility) {
	this.visible = visibility;
}

public Rectangle getBounds() {
	return new Rectangle(xPos, yPos, TOKEN_WIDTH, TOKEN_HEIGHT);
}

public void move() {
	yPos += 2;
}

public boolean isDying() {
	// TODO Auto-generated method stub
	return false;
}

public void die() {
	// TODO Auto-generated method stub
	
}

public void remove() {
}
}
