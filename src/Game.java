import javax.swing.JPanel;

import images.Commons;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Game extends JFrame implements Commons  {
	
//CONSTANTS


	public Game() {
		
		add(new Background());
		setResizable(false);
		pack();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
	
	EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
             Game game = new Game();
            game.setVisible(true);
        }
    });
	}
}
