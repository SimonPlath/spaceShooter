
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import images.Commons;


public class Background extends JPanel implements Commons, Runnable {
	
	private boolean left, right, up, down;
	private final int DELAY =  15;
	private ArrayList<PowerUp> powerups;
	private ArrayList<Alien> aliens;
	private ArrayList<Alien2> aliens2;
	private ArrayList<Alien3> aliens3;
	private ArrayList<Missile> missiles;
	private ArrayList<AlienMissile> alienMissiles;
	Rectangle newGame = new Rectangle(BOARD_WIDTH / 2 - 55, BOARD_HEIGHT / 2 - 70, 85, 30);
	Rectangle help = new Rectangle(BOARD_WIDTH / 2 - 55, BOARD_HEIGHT / 2 - 20, 85, 30);
	Rectangle exit = new Rectangle(BOARD_WIDTH / 2 - 55, BOARD_HEIGHT / 2 + 30, 85, 30) ;
	private Spaceship spaceship;
	private PowerUp powerup;
	private Alien alien;
	private Alien2 alien2;
	private Alien3 alien3;
	private FinishLine finishline;
	private Scoreboard scoreboard;
	private Dimension d;
	private MainMenu mainmenu;
	private boolean ingame = true;
	private Thread animator;
	private int randNumber = 0;
	private enum STATE {
		MENU, GAME, GAMEOVER
	};
	
	private STATE state = STATE.MENU;
	
	//constructor
	public Background() {
		
		setFocusable(true);
        d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));	
		addMouseListener(new TAdapter());
		addKeyListener(new TAdapter());
		gameInit();
		setDoubleBuffered(true);
	}
	
	// initiates the game objects
	
	private void gameInit() {
		
		powerups = new ArrayList<PowerUp>();
		finishline = new FinishLine(false, FINISH_LINE_X, FINISH_LINE_Y);
		scoreboard = new Scoreboard();
		mainmenu = new MainMenu();
		aliens = new ArrayList<Alien>();
		aliens2 = new ArrayList<Alien2>();
		aliens3 = new ArrayList<Alien3>();
		spaceship = new Spaceship();
		missiles = new ArrayList<Missile>();
		alienMissiles = new ArrayList<AlienMissile>();
		
		//create coins and add them to list of coins
		
		for (int j = 0; j < 10; j++) {
			randNumber = randomNumberGenerator();	
			PowerUp p = new PowerUp(randNumber, -350 * j);
			powerups.add(p);
		}
		
		//creates aliens and add them to a list of aliens
		
		for (int c = 0; c < 45; c++) {
			randNumber = randomNumberGenerator();
			alien = new Alien(randNumber, -150*c);
			aliens.add(alien);
		}	
		
		//creates alien2 and adds them to a list of alien2
		
		for (int a = 0; a < 25; a++) {
			randNumber = randomNumberGenerator();
			alien2 = new Alien2(randNumber, (-300 * a)- 1500);
			aliens2.add(alien2);
		}
		
		//creates alien3 and adds them to a list of alien3
		
		for (int b = 0; b < 30; b++) {
			randNumber = randomNumberGenerator();
			alien3 = new Alien3(randNumber, (-350 * b) - 2000);
			aliens3.add(alien3);
		}
		
		//start thread
		
		if (animator == null || !ingame) {
			animator = new Thread(this);
			animator.start();
		}
		
	}
	
	//paints game object images on the background depending on the game state
	
	@Override
    public void paintComponent(Graphics g) {
		DrawImages images = new DrawImages();
        super.paintComponent(g);
        
        if (state == STATE.GAME) {
			images.drawScoreBoard(g, scoreboard, this);
        	images.drawPowerUp(g, powerups, this);
        	images.drawAliens(g, aliens, aliens2, aliens3, this);
            images.drawSpaceship(g, spaceship, this);
            images.drawMissile(g, missiles, this);
            images.drawAlienMissiles(g, alienMissiles, this);
        }  else if (state == STATE.MENU) {
        	images.drawMainMenu(g, mainmenu);
        } else if (state == STATE.GAMEOVER) {
            	images.drawGameOver(g, scoreboard, this);
            	try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	state = STATE.MENU;
        }
	}

	private void updateSpaceship() {
		if (spaceship.isVisible()) {
			if (left == true) {
				   spaceship.moveLeft();
			   }
			   else if (right == true) {
				   spaceship.moveRight();
			   } 
			   else if (down == true) {
				   spaceship.moveDown();
			   }
			   else if (up == true) {
				   spaceship.moveUp();
			   }
			   else {		   
			   }
			spaceship.setLocation(spaceship.getSonicDx(), spaceship.getSonicDy());
		}
	}
	
	//updates the position of powerUps if they are visible
	
	private void updatePowerUps() {
		for (int i=0; i< powerups.size(); i++) {
			PowerUp t = (PowerUp) powerups.get(i);
			
			if (t.isVisible()) {
				t.move();
			} else {
				powerups.remove(t);
			}
		}
	}
	
	//updates the position of aliens if they are visible

	public void updateAliens() {
		for (int i = 0; i < aliens.size(); i++) {
		Sprites alien = aliens.get(i);
		if (alien.isVisible()) {
			alien.move();			
		} else {
			aliens.remove(alien) ;
		}
		
		}
		for (int a = 0; a < aliens2.size(); a++) {
			Alien2 alien2 = aliens2.get(a);
			if (alien2.isVisible()) {
				alien2.move();
			} else {
				aliens2.remove(alien2);
			}
		}
		
		for (int b = 0; b < aliens3.size(); b++) {
			Alien3 alien3 = aliens3.get(b);
			if (alien3.isVisible()) {
				alien3.move();
				if (alien3.getyPos() > 0 && alien3.getyPos() < 600) {
				alien3.setMissileReady();
				if (alien3.getMissileReady()) {
					AlienMissile alienMissile = new AlienMissile(alien3.getxPos(), alien3.getyPos());
					alienMissiles.add(alienMissile);
				}
				}
			} else {
				aliens3.remove(alien3);
			}
		}
	}
	
	public void addMissile() {
		Missile missile = new Missile(spaceship.getSonicDx() + 10, spaceship.getSonicDy());	
		missiles.add(missile);
	}
	
	//updates the position of missiles if they are visible
	
	public void updateMissiles() {
		for (int i = 0; i < missiles.size(); i++) {
			Missile missile = missiles.get(i);
			missile.moveMissile();
			if (missile.getyPos() < 0 || missile.getyPos() > 600) {
				missile.setVisibility(false);
			}
		}
		
		for (int j= 0; j < alienMissiles.size(); j++) {
			AlienMissile alienMissile = alienMissiles.get(j);
			alienMissile.move();
		}
	}
	
	public void updateFinishLine() {
		finishline.moveFL();
	}
	
	/*check for collisions between aliens and the spaceship. When a spaceship and alien collide
	the visibility of that spaceship is set to false and the game state is set to false. If
	 a missile collides with an alien the alien and missile visibility are set to false. */
	
	private void checkCollisions() {
		Rectangle r2 = spaceship.getBounds();
	//	Rectangle r3 = finishline.getBounds();
		
		for (PowerUp t: powerups) {
			Rectangle r1 = t.getBounds();	
			if (r2.intersects(r1)) {
			scoreboard.updatePowerUps();;
			t.setVisible(false);
			}
		}
//		if (r2.intersects(r3)) {
//			ingame = false;
//		}
		
		for (Sprites b: aliens) {
			Rectangle r4 = b.getBounds();
			if (r4.intersects(r2)) {
				ingame = false;
			state = STATE.GAMEOVER;
			}
			for (Missile m: missiles) {
				Rectangle r5 = m.getBounds();
				if (m.isVisible()) {
				if (r5.intersects(r4)) {
					b.setVisibility(false);
					m.setVisibility(false);
					scoreboard.updateScoreA1();
				}
			}
		}
		}
		
		for (Alien2 c: aliens2) {
			Rectangle r6 = c.getBounds();
			if (r6.intersects(r2)) {
				ingame = false;
				state = STATE.GAMEOVER;
			}
		}
		
		for (Alien3 x: aliens3) {
			Rectangle r7 = x.getBounds();
			for (Missile m: missiles) {
				if (m.isVisible()) {
				Rectangle r8 = m.getBounds();
				if (r8.intersects(r7)) {
					x.setVisibility(false);
					m.setVisibility(false);
					scoreboard.updateScoreA3();
				}
				}
			}
		}
		for (AlienMissile am: alienMissiles) {
			if (am.isVisible()) {
				Rectangle r9 = am.getBounds();
				if (r9.intersects(r2)) {
					am.setVisibility(false);
					ingame = false;
					state = STATE.GAMEOVER;
				}
			}
		}
	}

	private class TAdapter extends KeyAdapter implements MouseListener {

        @Override
        public void keyReleased(KeyEvent e) {
        	 int key = e.getKeyCode();

             if (key == KeyEvent.VK_LEFT)
             {
             	left = false;
             }
             else if (key == KeyEvent.VK_RIGHT)
             {
             	right = false;
             }
             else if (key == KeyEvent.VK_UP)
             {
             	up = false;
             }
             else {
             	down = false;
             }
        }

        @Override
        public void keyPressed(KeyEvent e) {
        	int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                left = true;
            }
            else if (key == KeyEvent.VK_RIGHT) {
                right = true;
            }       
            else if (key == KeyEvent.VK_UP) {
            	up = true;
            }                   		
            else if (key == KeyEvent.VK_SPACE) {
    			addMissile();
    		}
            else if (key == KeyEvent.VK_DOWN) {
            	down = true;
            }
            else if (key == KeyEvent.VK_ENTER) {
            	if (state == STATE.MENU) {
            	state = STATE.GAME;
            }
            	else if (state == STATE.GAME) {
            		state = STATE.MENU;
            	}
        }
        }

		@Override
		public void mouseClicked(MouseEvent e) {
			int Xpos = e.getX();
			int Ypos = e.getY();
				
			if ((Xpos <= newGame.getMaxX() && Xpos >= newGame.getMinX()) && (Ypos <= newGame.getMaxY() && Ypos >= newGame.getMinY())) {
		ingame = true;
		state = STATE.GAME;
			System.out.println("I play Pokemon go everyday");
			}		
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    }
	
	// if the state of the game is GAME
	//updates the position of different objects in the game in the order the methods are called.
	
	public void animationCycle() {
		if (state == STATE.GAME) {
		updateSpaceship();
		updatePowerUps();
		updateAliens();
		updateMissiles();
		updateFinishLine();
		checkCollisions();
		}
	}
	
	// The current thread thats running
	@Override
	public void run() {
		long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();
        
       while (ingame) {
  
        	repaint();
        	animationCycle();
        	timeDiff = System.currentTimeMillis() - beforeTime;
        	sleep = DELAY - timeDiff;
        	 if (sleep < 0) 
                 sleep = 2;
             try {
                 Thread.sleep(sleep);
             } catch (InterruptedException e) {
                 System.out.println("interrupted");
             }
             beforeTime = System.currentTimeMillis();
         }
 //      gameOver();
       
        }

	public void addPowerUps() {
		Random rnd = new Random();
		int xVal = rnd.nextInt(0);
		for (int i = 0; i < 10; i++) {
			powerup = new PowerUp(xVal, 0);
			powerups.add(powerup);
		}		
	}
	
	public int randomNumberGenerator() {
		Random rand = new Random();
		return rand.nextInt(750);
	}
	public boolean getLeft() {
		return left;
	}
	public boolean getRight() {
		return right;
	}
	public boolean getUp() {
		return up;
	}
	public boolean getDown() {
		return down;
	}
	
}


