import images.Commons;

public class Scoreboard implements Commons {

int numPowerUps;
int score;

	public Scoreboard() {
		numPowerUps = 0/10;
		score = 0;
	}
	
	public void updateScoreA1() {
		score +=10;
	}
	
	public void updateScoreA3() {
		score +=20;
	}
	
	public void updatePowerUps() {
		numPowerUps +=1;
	}
	
	public int getPowerUps() {
		return numPowerUps;
	}
	
	public int getScore() {
		return score;
	}
	
}
