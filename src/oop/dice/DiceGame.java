package oop.dice;

public class DiceGame {
	
	Die die1 = new Die();
	
	Die die2 = new Die();
	
	public void play() {
		int i = die1.getFaceValue();
		int j = die2.getFaceValue();
		System.out.println("first die:" + i);
		System.out.println("second die:" + j);
		if (i + j == 7) {
			System.out.println("You win!");
		}else {
			System.out.println("You lose!");
		}
	}

	public static void main(String[] args) {
		DiceGame diceGame = new DiceGame();
		diceGame.play();
	}

}
