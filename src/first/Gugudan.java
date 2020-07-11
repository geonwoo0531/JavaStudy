package first;

import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {

		System.out.println("구구단프로그램입니다. 몇 단을 출력하겠습니까? (9단까지가능, 0입력시 종료)");
		Scanner scan = new Scanner(System.in);
		int dan = scan.nextInt();

		while (dan != 0) {	// 0을 입력할때까지 반복
			if (dan <= 9) {
				System.out.println(dan + "단 출력");

				for (int i = 1; i <= 9; i++) {
					System.out.printf("%d * %d = %d \n", dan, i, i * dan);
				}

			} else {
				System.out.println("9이하의 정수를 입력하세요.");
			}
			dan = scan.nextInt();

		}
		System.out.println("프로그램 종료");
	}
}
