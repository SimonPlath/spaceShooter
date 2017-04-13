import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import images.Commons;

public class DrawImages implements Commons {
	
	DrawImages() {	
	}
	
	//draws a Spaceship image on the background of JPanel
	
	public void drawSpaceship(Graphics g, Spaceship spaceship, JPanel image) {
			if (spaceship.isVisible()) {
			g.drawImage(spaceship.getImage(), spaceship.getSonicDx(), spaceship.getSonicDy(), spaceship.getSonicHeight(), spaceship.getSonicWidth(), image);
			}
		}
	
	//draws a Power-up image on the background of JPanel

	public void drawPowerUp(Graphics g, ArrayList<PowerUp> powerups, ImageObserver image) {
      Iterator<PowerUp> it = powerups.iterator();

      while (it.hasNext()) {
          PowerUp powerUp = (PowerUp) it.next();

          if (powerUp.isVisible()) {
              g.drawImage(powerUp.getImage(), powerUp.getXPos(), powerUp.getYPos(), powerUp.getTokenHeight(), powerUp.getTokenWidth(), image);
          }

          if (powerUp.isDying()) {
              powerUp.die();
          }
      }
	}
	
	//draws the finish line image on the background of JPanel
	
	public void drawFinishLine(Graphics g, FinishLine finishline, JPanel image) {
	g.drawImage(finishline.getImage(), finishline.getXpos(), finishline.getYpos(), FINISH_LINE_WIDTH, FINISH_LINE_HEIGHT, image);
	}
	
	//draws the alien image on the background of JPanel
	
	public void drawAliens(Graphics g, ArrayList<Alien> aliens, ArrayList<Alien2> aliens2, ArrayList<Alien3> aliens3, JPanel image) {
	Iterator<Alien> it1 = aliens.iterator();
	Iterator<Alien2> it2 = aliens2.iterator();
	Iterator<Alien3> it3 = aliens3.iterator();
	
	while (it1.hasNext()) {
	Sprites alien = (Sprites) it1.next();
	g.drawImage(alien.getImage(), alien.getxPos(), alien.getyPos(), ALIEN_WIDTH, ALIEN_HEIGHT, image);
	}
	
	while (it2.hasNext()) {
		Alien2 alien2 = (Alien2) it2.next();
		g.drawImage(alien2.getImage(), alien2.getxPos(), alien2.getyPos(), ALIEN2_WIDTH, ALIEN2_HEIGHT, image);
	}
	
	while (it3.hasNext()) {
		Alien3 alien3 = (Alien3) it3.next();
		g.drawImage(alien3.getImage(), alien3.getxPos(), alien3.getyPos(), ALIEN3_WIDTH, ALIEN3_HEIGHT, image);
	}
}
	
	//draws the Spaceship missile images on the background of JPanel

	public void drawMissile(Graphics g, ArrayList<Missile> missiles, JPanel image) {
	Iterator<Missile> it = missiles.iterator();
	while (it.hasNext()) {
		Missile bullet = (Missile) it.next();
			if (bullet.isVisible()) {
				g.drawImage(bullet.getImage(), bullet.getxPos(), bullet.getyPos(), MISSILE_WIDTH, MISSILE_HEIGHT, image);
			}
	}
}
	
	//draws the alien missiles images on the background of JPanel
	
	public void drawAlienMissiles(Graphics g, ArrayList<AlienMissile> alienMissiles, JPanel image) {
	Iterator<AlienMissile> it = alienMissiles.iterator();
	while (it.hasNext()) {
		AlienMissile alienMissile = (AlienMissile) it.next();
			if (alienMissile.isVisible()) {
				g.drawImage(alienMissile.getImage(), alienMissile.getxPos(), alienMissile.getyPos(), MISSILE_WIDTH, MISSILE_HEIGHT, image);
		}
	}
}
	
	//draws the scoreboard image on the background of JPanel

	public void drawScoreBoard(Graphics g, Scoreboard scoreboard, JPanel background) {
	String power_up_msg = "Power-ups = " + scoreboard.getPowerUps() + "/10";
	String score_msg = "Score = " + scoreboard.getScore();
	Font small = new Font ("Helvetica", Font.BOLD, 14);
	FontMetrics fm = background.getFontMetrics(small);
	
	g.setColor(Color.white);
	g.setFont(small);
	g.drawString(power_up_msg, 0, 20);
	g.drawString(score_msg, 0, 40);
}
	
	//draws the Main Menu image on the background of JPanel

	public void drawMainMenu(Graphics g, MainMenu mainmenu) {
	mainmenu.drawNewGameMenu(g);
	mainmenu.drawExitMenu(g);
	mainmenu.drawHelpMenu(g);
	mainmenu.drawMenuTitle(g);	
}
	
	//draws the game over state on the background
	
	public void drawGameOver(Graphics g, Scoreboard scoreboard, JPanel background) {
	 String msg1 = "Game Over";
	 String msg2 = "Score = " + scoreboard.getScore();
			 
	    Font small = new Font("Helvetica", Font.BOLD, 14);
	    FontMetrics fm = background.getFontMetrics(small);

	    g.setColor(Color.white );
	    g.setFont(small);
	    g.drawString(msg1, (BOARD_WIDTH - fm.stringWidth(msg1)) / 2,
	            BOARD_HEIGHT / 2);
	    g.drawString(msg2, (BOARD_WIDTH - fm.stringWidth(msg2)) / 2, BOARD_HEIGHT / 2 + 50);
}
	
}
