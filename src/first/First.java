package first;

public class First {
	int a = 123; // �⺻�������̸� ��������� �ν��Ͻ�����
	static int b = 456; // �⺻�������̸� ��������� Ŭ��������
	static int c = 789;

	public void changeA(int i) { // int i �� �Ű�����(�Ķ����)�̸鼭 ��������
		System.out.println("�Ű����� i ����");
		this.a = i; // �ν��Ͻ����� a�� ���� �Ű�����(�Ķ����) i������ �ٲ�
		System.out.println("First�ν��Ͻ��� a���� �Ű����� i ���� " + i + "�� ����");
		System.out.println("�Ű����� i �Ҹ�");
	}

	public void changeB(int j) { // int j �� �Ű�����(�Ķ����)�̸鼭 ��������
		System.out.println("�Ű����� j ����");
		this.b = j; // Ŭ�������� b�� ���� �Ű�����(�Ķ����) j������ �ٲ�
		System.out.println("First�ν��Ͻ��� b���� �Ű����� j ����" + j + "�� ����");
		System.out.println("�Ű����� j �Ҹ�");

	}

	public static void main(String[] args) {

		int c = 987; // ��������

		First first = new First(); // ����������
		First first2 = new First();

		System.out.println("�������� c : " + c);
		System.out.println("first�� c : " + first.c);

		// System.out.println(a); //���� > �ν��Ͻ���ü�� ���� ȣ���ؾ���
		System.out.println("Ŭ�������� b : " + b); // �ν��Ͻ� ���� �Լ��� ȣ�� ����

		first.changeA(321);
		System.out.println("first�� a : " + first.a);
		System.out.println("first2�� a : " + first2.a);
		// �ν��Ͻ������� ���δٸ� ��������� �ο�

		first.changeB(654);
		System.out.println("first�� b : " + first.b);
		System.out.println("first2�� b : " + first2.b);
		// Ŭ���������� �ϳ��� ��������� ����

	}

}
