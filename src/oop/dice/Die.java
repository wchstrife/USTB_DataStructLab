package oop.dice;

import java.util.Random;

public class Die {
	
	int faceValue;
	
	int getFaceValue() {
		Random random = new Random();
		int j = random.nextInt(6);
		this.faceValue = j+1;
		
		return this.faceValue;
	}
}
