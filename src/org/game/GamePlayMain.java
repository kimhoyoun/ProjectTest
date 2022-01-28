package org.game;

import java.util.Scanner;

public class GamePlayMain {
	int count = 0; // 문제 정답 카운트
	String question; //문제
	int answer = 0; // 정답
	int[] answerArr = new int[4]; //4개의 정답 선지를 담는 배열
	
	public GamePlayMain() {
		run();
	}

	public void run() {
		Scanner scan = new Scanner(System.in);
		GamePlay gamePlay = new GamePlay();

//		for (int gameCnt = 0; gameCnt < 10; gameCnt++) {
			gamePlay.makeRandomNumber();
//			System.out.println((gameCnt + 1) + "번째 문제");
			question = gamePlay.makeQuiz();
//			System.out.print("문제 >> ");
//			System.out.print(question);
//			System.out.println();

			answer = gamePlay.makeAnswer();
//			System.out.println(answer); //정답 출력해봄
			int choice = (int)(Math.random() * 4); // 4개의 선지의 위치를 랜덤으로 하기 위해서
			int index = 0;
			for (int i = 0; i < 4; i++) {
				if (choice == i) {
					answerArr[i] = answer;
					index = i;
				} else {
					answerArr[i] = (int)(Math.random() * 1000 % 35);
					if (answerArr[i] == answer) { // 정답 중복제거
						i--;
						continue;
					}
					for (int j = 0; j < i; j++) { // 정답을 제외한 나머지 중복제거
						if (answerArr[j] == answerArr[i]) {
							i--;
							break;
						}
					}
				}
			}
			
			// 콘솔에 띄우는 부분이라 주석처리
//			for (int i = 0; i < 4; i++) {
//				System.out.print("[" + answerArr[i] + "]");
//			}
			
//			System.out.println();
//			System.out.print("정답입력 >> ");
//			int answerNum = scan.nextInt() - 1; // 인덱스와 일치 시키기 위해서 -1
//			if (answerNum == index) { // 정답 인덱스와 입력한 숫자와 같으면
//				System.out.println("정답입니다!");
//				count += 1;
//			} else {
//				System.out.println("틀렸습니다!");
//			}
			// 함수 10개 만든 다음에 i값에 t/f 를 넣어서 정답 오답 개수 출력
			// 지역 변수를 만든 뒤 10번을 다 돌고 난 다음에 카운트 하게 , 중간에 나가게 되면 카운트가 안 되게
//		} //end of for문
			
//		System.out.println(count); //정답 개수 출력해봄
//		System.out.println("종료합니다.");
	}

	public static void main(String[] args) {
		new GamePlayMain();
	}
}