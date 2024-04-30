package ch07;

import java.util.Arrays;
import java.util.Random;

public class RandomNumber {
	
	final int LOTTO_NUMBERS = 6;
	
	public int[] createNumber() {
		
		int[] lottoNumber = new int[LOTTO_NUMBERS];
		Random random = new Random();
		
		for (int i= 0; i< lottoNumber.length; i++) {
			lottoNumber[i] = random.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (lottoNumber[j] == lottoNumber[i]) {
					i--;
				}
			}
		}
		Arrays.sort(lottoNumber);
		return lottoNumber;
		
	}

}
