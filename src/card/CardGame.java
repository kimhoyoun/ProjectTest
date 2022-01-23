package card;

public class CardGame {
	private static final int RED = 0;
	private static final int BLUE = 1;
	private static final int GREEN = 2;

	private static final int MIN = 1;
	private static final int MAX = 7;

	private static int[] colors = new int[] { RED, BLUE, GREEN };
	static int c0 = 0;
	static int c1 = 0;
	static int c2 = 0;
	static int[][] arr = new int[3][3];

	public static void main(String[] args) {
		int n1 = 0, n2 = 0;

		// 3*3인 2차원 배열을 만들고
		// 변수를 선언후 색깔변수 갯수 세기
		// 정수를 랜덤하게 생성해 저장
		setArr();
		// 3x3 arr 결정됐고, c0, c1, c2의 갯수를 나타내는 값이 정해졌다.

		while (true) {
			// 3중 하나가 한번도 안나왔을 때
			if (!((c0 == 0 || c1 == 0 || c2 == 0)||((c0 == c1) && (c1 == c2))||((c0 == 1) && (c1 == c2))||((c1 == 1) && (c0 == c2))||((c2 == 1) && (c0 == c1)))) {
				break;
			}
//			// 3 3 3 일때
//			else if (!((c0 == c1) && (c1 == c2))) {
//				break;
//			}
//			// 1 4 4 일때
//			else if (!((c0 == 1) && (c1 == c2))) {
//				break;
//			}
//			else if (!((c1 == 1) && (c0 == c2))) {
//				break;
//			}
//			else if (!((c2 == 1) && (c0 == c1))) {
//				break;
//			}
			
			// 다시 arr 만든다.
			setArr();

		}
		
		System.out.println("RED의 개수 : "+ c0);
		System.out.println("BLUE의 개수 : "+c1);
		System.out.println("GREEN의 개수 : "+c2);
		
		// 정답
		int max = c0;
		String ans = "RED";
		if(max<c1) {
			max = c1;
			ans = "BLUE";
		}
		
		if(max < c2) {
			max = c2;
			ans = "GREEN";
		}
		
		System.out.println("정답 : "+ans);
	}
	
	// 배열 만들고 갯수 세기
	public static void setArr() {
		c0 = 0;
		c1 = 0;
		c2 = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int) (Math.random() * 3);

				if (arr[i][j] == 0) {
					c0++;
				} else if (arr[i][j] == 1) {
					c1++;
				} else {
					c2++;
				}
				System.out.print(arr[i][j]);
			}
			System.out.println(" ");

		}
	}

}
