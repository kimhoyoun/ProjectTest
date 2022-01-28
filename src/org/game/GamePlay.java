package org.game;

import java.util.Random;

public class GamePlay {
	Random random;
	int number1;
	int number2;
	String[] sign = new String[] { "+", "-" }; // 부호
	int answer; // 정답
	String form; // 식

	public void makeRandomNumber() {
		random = new Random();
		number1 = random.nextInt(20) + 1;
		number2 = random.nextInt(15) + 1;
	}

	public String makeQuiz() {
		int randomSign = (int) (random.nextInt(10000)) % 2; // 부호 결정
		if (number1 > number2) { // 연산결과가 음수값이 나오지 않게 하기 위해 조건을 걸어줌
			form = String.format("%2d %s %2d",number1, sign[randomSign], number2);
		} else {
			form = String.format("%2d %s %2d",number1, sign[0], number2);
		}
		return form;
	}

	public int makeAnswer() {
		if (form.contains("+")) {
			answer = number1 + number2;
		} else {
			answer = number1 - number2;
		}
		return answer;
	}
}
