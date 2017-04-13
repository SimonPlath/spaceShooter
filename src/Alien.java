import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import images.Commons;

public class Alien extends Sprites implements Commons {

Image alien;
public Alien(int dx, int dy) {
	this.dx = dx;
	this.dy = dy;
	ImageIcon ii = new ImageIcon(this.getClass().getResource("images/alien1.gif"));
	setImage(ii.getImage());
}

public Rectangle getBounds() {
	return new Rectangle(dx, dy, ALIEN_WIDTH, ALIEN_HEIGHT);
}
	
}
