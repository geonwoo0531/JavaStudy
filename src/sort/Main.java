package sort;

import java.util.Scanner;

// 제가 처음 짠 정렬 방식은 case 1번의 선택정렬이었습니다.
public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("1. 선택정렬");
		System.out.println("2. 버블정렬");
		System.out.println("3. 삽입정렬");
		System.out.println("어떤 방법으로 정렬하시겠습니까?");
		int menu = scan.nextInt(); // 정렬 방법

		System.out.println("1. 오름차순");
		System.out.println("2. 내림차순");
		System.out.println("오름차순은 1번, 내림차순은 2번을 입력하세요.");
		int sorting = scan.nextInt(); // 오름차순, 내림차순 방법

		System.out.println("숫자 5개 입력 : ");
		//int[] array = { 6, 3, 9, 1, 7 };
		int[] array = new int[5];

		// 숫자 중복 체크
		for (int i = 0; i < array.length; i++) {
			array[i] = scan.nextInt();
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					System.out.println("중복된 숫자입니다! 다시입력하세요");
					i--;
				}
			}
		}

		int temp = 0; // 데이터 임시 저장용 변수

		switch (menu) {
		case 1:
			System.out.println("====== 선택 정렬 ======");
			for (int i = 0; i < array.length - 1; i++) {
				for (int j = i + 1; j < array.length; j++) {

					if (sorting == 1) { // 오름차순
						if (array[i] > array[j]) {
							temp = array[i];
							array[i] = array[j];
							array[j] = temp;
						}
					} else if (sorting == 2) { // 내림차순
						if (array[i] < array[j]) {
							temp = array[i];
							array[i] = array[j];
							array[j] = temp;
						}
					}
				}
				System.out.print((i + 1) + "회전 : ");
				showArray(array); // i번째 데이터 출력
			}
			break;
		case 2:
			System.out.println("====== 버블 정렬 ======");
			for (int i = 0; i < array.length - 1; i++) {
				for (int j = 0; j < array.length - i - 1; j++) {

					if (sorting == 1) { // 오름차순
						if (array[j] > array[j + 1]) {
							temp = array[j];
							array[j] = array[j + 1];
							array[j + 1] = temp;
						}
					} else if (sorting == 2) { // 내림차순
						if (array[j] < array[j + 1]) {
							temp = array[j];
							array[j] = array[j + 1];
							array[j + 1] = temp;
						}
					}
				}
				System.out.print((i + 1) + "회전 : ");
				showArray(array); // i+1번째 데이터 출력
			}
			break;

		case 3:
			System.out.println("====== 삽입 정렬 ======");
			for (int i = 1; i < array.length; i++) {
				temp = array[i];
				for (int j = i - 1; j >= 0; j--) {
					
					if (sorting == 1) { // 오름차순
						if (array[j] > temp)
							array[j + 1] = array[j];
						else
							break;
						array[j] = temp;
						
					} else if (sorting == 2) { // 내림차순
						if (array[j] < temp)
							array[j + 1] = array[j];
						else
							break;
						array[j] = temp;
					}
				}
				System.out.print((i) + "회전 : ");
				showArray(array); // i번째 데이터 출력
			}
			break;
		}

		System.out.println("====== 정렬 결과 ======");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + "  ");
	}

	// 회전시마다 배열상태를 보기위한 메서드
	private static void showArray(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "  ");
		}
		System.out.println();
	}

}
