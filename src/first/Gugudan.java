package first;

import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {

		System.out.println("���������α׷��Դϴ�. �� ���� ����ϰڽ��ϱ�? (9�ܱ�������, 0�Է½� ����)");
		Scanner scan = new Scanner(System.in);
		int dan = scan.nextInt();

		while (dan != 0) {	// 0�� �Է��Ҷ����� �ݺ�
			if (dan <= 9) {
				System.out.println(dan + "�� ���");

				for (int i = 1; i <= 9; i++) {
					System.out.printf("%d * %d = %d \n", dan, i, i * dan);
				}

			} else {
				System.out.println("9������ ������ �Է��ϼ���.");
			}
			dan = scan.nextInt();

		}
		System.out.println("���α׷� ����");
	}
}
