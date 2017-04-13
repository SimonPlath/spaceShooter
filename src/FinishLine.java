import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import images.Commons;

public class FinishLine implements Commons {

boolean finished;
Image finishline;
private int dx;
private int dy;
private boolean visibility = true;

public FinishLine(boolean finished, int xPos, int yPos) {
	dx = xPos;
	dy = yPos;
	ImageIcon ii = new ImageIcon(this.getClass().getResource("images/finishline.jpg"));
	setImage(ii.getImage());
	
	this.finished = finished;
}

public boolean getFinished() {

	return finished;
}

public void setFinished(boolean finished) {
	this.finished = finished;
}

public void setImage(Image image) {
	this.finishline = image;
}

public Image getImage() {
	return finishline;
}

public int getXpos() {
	return dx;
}

public int getYpos() {
	return dy;
}


public Rectangle getBounds() {
	return new Rectangle(dx, dy, FINISH_LINE_WIDTH, 1);
}

public void moveFL() {
	dy += 1;
}

}
