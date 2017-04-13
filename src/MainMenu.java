import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import images.Commons;

public class MainMenu implements Commons {

	public MainMenu() {
		
	}
	public void drawNewGameMenu(Graphics g) {
		Rectangle newGameR = new Rectangle(20, 60, 250, 300);
		String newGame = "New Game";
		Font mmfont = new Font ("Helvetica", Font.BOLD, 14);
		g.setFont(mmfont);
		g.setColor(Color.white);
		g.drawString(newGame, BOARD_WIDTH / 2 - 50, BOARD_HEIGHT / 2 - 50);
		g.drawRect(BOARD_WIDTH / 2 - 55, BOARD_HEIGHT / 2 - 70, 85, 30);


	}
	public void drawHelpMenu (Graphics g) {
		String help = "Help";
		Font mmfont = new Font ("Helvetica", Font.BOLD, 14);
		g.setFont(mmfont);
		g.setColor(Color.white);
		g.drawString(help, BOARD_WIDTH / 2 - 30, BOARD_HEIGHT / 2);
		g.drawRect(BOARD_WIDTH / 2 - 55, BOARD_HEIGHT / 2 - 20, 85, 30);
	}
	
	public void drawExitMenu (Graphics g) {
		String exit = "Exit";
		Font mmfont = new Font ("Helvetica", Font.BOLD, 14);
		g.setFont(mmfont);
		g.setColor(Color.white);
		g.drawString(exit, BOARD_WIDTH / 2 - 30, BOARD_HEIGHT / 2 + 50);
		g.drawRect(BOARD_WIDTH / 2 - 55, BOARD_HEIGHT / 2 + 30, 85, 30);
	}
	
	public void drawMenuTitle(Graphics g) {
		String mmtitle = "Space Invaders";
		Font titleFont = new Font ("Helvetica", Font.BOLD, 18);
		g.setColor(Color.white);
		g.setFont(titleFont);
		g.drawString(mmtitle, BOARD_WIDTH /2 - 75, BOARD_HEIGHT /2 - 100);

	}
	
}
