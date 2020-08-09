package sort;

import java.util.Scanner;

// ���� ó�� § ���� ����� case 1���� ���������̾����ϴ�.
public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("1. ��������");
		System.out.println("2. ��������");
		System.out.println("3. ��������");
		System.out.println("� ������� �����Ͻðڽ��ϱ�?");
		int menu = scan.nextInt(); // ���� ���

		System.out.println("1. ��������");
		System.out.println("2. ��������");
		System.out.println("���������� 1��, ���������� 2���� �Է��ϼ���.");
		int sorting = scan.nextInt(); // ��������, �������� ���

		System.out.println("���� 5�� �Է� : ");
		//int[] array = { 6, 3, 9, 1, 7 };
		int[] array = new int[5];

		// ���� �ߺ� üũ
		for (int i = 0; i < array.length; i++) {
			array[i] = scan.nextInt();
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					System.out.println("�ߺ��� �����Դϴ�! �ٽ��Է��ϼ���");
					i--;
				}
			}
		}

		int temp = 0; // ������ �ӽ� ����� ����

		switch (menu) {
		case 1:
			System.out.println("====== ���� ���� ======");
			for (int i = 0; i < array.length - 1; i++) {
				for (int j = i + 1; j < array.length; j++) {

					if (sorting == 1) { // ��������
						if (array[i] > array[j]) {
							temp = array[i];
							array[i] = array[j];
							array[j] = temp;
						}
					} else if (sorting == 2) { // ��������
						if (array[i] < array[j]) {
							temp = array[i];
							array[i] = array[j];
							array[j] = temp;
						}
					}
				}
				System.out.print((i + 1) + "ȸ�� : ");
				showArray(array); // i��° ������ ���
			}
			break;
		case 2:
			System.out.println("====== ���� ���� ======");
			for (int i = 0; i < array.length - 1; i++) {
				for (int j = 0; j < array.length - i - 1; j++) {

					if (sorting == 1) { // ��������
						if (array[j] > array[j + 1]) {
							temp = array[j];
							array[j] = array[j + 1];
							array[j + 1] = temp;
						}
					} else if (sorting == 2) { // ��������
						if (array[j] < array[j + 1]) {
							temp = array[j];
							array[j] = array[j + 1];
							array[j + 1] = temp;
						}
					}
				}
				System.out.print((i + 1) + "ȸ�� : ");
				showArray(array); // i+1��° ������ ���
			}
			break;

		case 3:
			System.out.println("====== ���� ���� ======");
			for (int i = 1; i < array.length; i++) {
				temp = array[i];
				for (int j = i - 1; j >= 0; j--) {
					
					if (sorting == 1) { // ��������
						if (array[j] > temp)
							array[j + 1] = array[j];
						else
							break;
						array[j] = temp;
						
					} else if (sorting == 2) { // ��������
						if (array[j] < temp)
							array[j + 1] = array[j];
						else
							break;
						array[j] = temp;
					}
				}
				System.out.print((i) + "ȸ�� : ");
				showArray(array); // i��° ������ ���
			}
			break;
		}

		System.out.println("====== ���� ��� ======");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + "  ");
	}

	// ȸ���ø��� �迭���¸� �������� �޼���
	private static void showArray(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "  ");
		}
		System.out.println();
	}

}
