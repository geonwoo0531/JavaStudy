package third;

import java.util.*;

public class NoticeBoard {
	static ArrayList<HashMap<String, String>> userList = new ArrayList<HashMap<String, String>>();
	static Scanner scan = new Scanner(System.in);
	static ArrayList<HashMap<String, String>> writingList = new ArrayList<HashMap<String, String>>();
	static String loginUserName;
	static String loginUserId;

	public static void MainPage() {
		int menu;
		System.out.println("---------");
		System.out.println("1.ȸ������");
		System.out.println("2.�α���");
		System.out.println("0.����");
		System.out.println("---------");
		System.out.print("���޴����� : ");

		menu = scan.nextInt();

		System.out.println("---------");
		switch (menu) {
		case 1:
			SignUp();
			break;
		case 2:
			SignIn();
			break;
		case 0:
			EndProgram();
			break;
		default:
			System.out.println("1, 2, 0 �߿� ������ �ּ���.");
			MainPage();

		}

	}

	public static void WritingListPage() {
		int menu;
		System.out.println("-------------------------");
		System.out.println("��ȣ\t����\t\t�ۼ���");
		System.out.println("--------------------------");
		for (int i = 0; i < writingList.size(); i++) {
			System.out.println((Integer.parseInt(writingList.get(i).get("�� ��ȣ")) + 1) + "\t" + writingList.get(i).get("�� ����") + "\t\t"
					+ loginUserName + "(" + loginUserId + ")");
		}
		// 1 ù��° �� ���� ����(a001)
		// 2 �ι�° �� ���� �ֻ��(b001)
		// 3 ����° �� ���� �̻��(c001)

		System.out.println("--------------------------");
		System.out.println("1.�� �� �ۼ�");
		System.out.println("2.�� ��ȸ");
		System.out.println("0.�α׾ƿ�");
		System.out.println("--------------------------");
		System.out.println("���޴� ���� : ");
		menu = scan.nextInt();
		System.out.println("--------------------------");
		// ����1. �Խ��� ��Ͽ� �۹�ȣ/����/�ۼ��� �����ֱ�
		// ����2. �ۼ��ڴ� �̸�(���̵�)�� �����ֱ�
		// ����3. �α׾ƿ� ���ý� ȭ��1�� �̵�

		switch (menu) {
		case 1:
			NewWritingPage();
			break;
		case 2:
			ChoiceWritingPage();
			break;
		case 0:
			System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
			MainPage();
			break;
		default:
			System.out.println("1,2,0�߿� �������ּ���.");
			WritingListPage();
		}

	}

	public static void NewWritingPage() {
		HashMap<String, String> writings = new HashMap();
		String writingnum = writingList.size() + "";
		System.out.println("---------------");
		System.out.print("���� ���� �Է� : ");
		scan.nextLine();
		String title = scan.nextLine();
		System.out.println("----------------");
		System.out.print("���� ���� �Է� : ");
		String content = scan.nextLine();
		System.out.println("----------------");
		writings.put("�� ��ȣ", writingnum + "");
		writings.put("�� ����", title);
		writings.put("�� ����", content);
		writings.put("�ۼ���", loginUserName);
		// ����1. ������ ����,������ �ۼ� �� �������� �����ְ� ������ ��ȭ������ �̵�
		// ����2. �� ��ȣ�� ������� �ű�� �ۼ��ڴ� �α��� ������ ó��"
		writingList.add(writings);

		System.out.println(writingList);

		WritingListPage();

	}

	public static void ChoiceWritingPage() {
		System.out.println("---------------");
		System.out.println("���� ��ȣ ���� : ");
		String writingNumber = scan.next();
		System.out.println("---------------");
		// ����1. �� ��ȣ �Է��Ͽ� ����

		ReadWritingPage(writingNumber);
	}

	public static void ReadWritingPage(String writingNumber) {
		System.out.println("---------------------");
		// 1 ù��° �� ���� ����(a001)
		System.out.println(writingNumber + "\t" + writingList.get(Integer.parseInt(writingNumber) - 1).get("�� ����")
				+ "\t" + writingList.get(Integer.parseInt(writingNumber) - 1).get("�ۼ���") + loginUserName);
		System.out.println("---------------------");
		// ������ ���ٸ������൵ �˴ϴ�. �� ���� �κ�.
		writingList.get(Integer.parseInt(writingNumber) - 1).get("�� ����");
		System.out.println("---------------------");
		// ����1. ������ �ۼ��� ���϶� 1.���� 2.���� �޴��� ��Ÿ����
		// System.out.println("1.����");
		// System.out.println("2.����");
		if (loginUserName.equals(writingList.get(Integer.parseInt(writingNumber) - 1).get("�ۼ���"))) {
			System.out.println("1.����");
			System.out.println("2.����");
		}
		System.out.println("0.�ڷ�");
		System.out.println("---------------------");
		System.out.println("���޴� ���� : ");
		int menu = scan.nextInt();
		switch (menu) {
		case 1:
			ModifyWritingPage();
			break;
		case 2:
			DeleteWritingPage(writingNumber);
			break;
		case 0:
			ChoiceWritingPage();
			break;
		default:
			System.out.println("0,1,2 �߿� �����ϼ���.");
			ReadWritingPage(writingNumber);
		}
		System.out.println("---------------------");
	}

	// �� ���� ������ ȭ��
	public static void ModifyWritingPage() {
		System.out.println("----------------");
		System.out.println("���� ���� �Է� : ");
		String title = scan.nextLine();
		System.out.println("----------------");
		System.out.println("���� ���� �Է� : ");
		String content = scan.nextLine();
		System.out.println("----------------");
		// ����1. ������ ����,������ �ۼ� �� �������� �����ְ� ������ ��ȭ������ �̵�
	}

	// �� ���� Ȯ�� ������
	public static void DeleteWritingPage(String writingNum) {
		System.out.println("------------------");
		System.out.println("��" + writingNum + "�� ���� �����Ͻðڽ��ϱ�?(y/n) : ");
		String deleteChk = scan.next();

		if ("y".equals(deleteChk)) {

		} else if ("n".equals(deleteChk)) {

		}

		// ����1. ���Ͱ��� �������� �� �� �� ����
		// ����2. �����Ϸ��� ���� ��ȣ�� �����ְ�(ex. 1�� ��) �ҹ��� y �Ǵ� n���� �������� �Է�
		// ����3. ���� �������� �����ְ� �Խ��� ������� �̵�"
	}

	// ȸ������ ȭ��
	public static void SignUp() {
		HashMap<String, String> users = new HashMap<String, String>();
		System.out.println("---------");
		System.out.print("�����̵� �Է� : ");
		String newId = scan.next();

		IdCheck(users, newId);

		System.out.println("---------");
		System.out.print("����й�ȣ �Է� : ");
		users.put("��й�ȣ", scan.next());
		System.out.println("---------");
		System.out.print("���̸� �Է� : ");
		users.put("�̸�", scan.next());
		System.out.println("---------");

		userList.add(users);
		loginUserName = users.get("�̸�");
		loginUserId = users.get("���̵�");
		System.out.println(loginUserName + "�� ȸ�����Կ� �����Ͽ����ϴ�.");
		MainPage();
	}

	// ���̵� �ߺ�üũ
	public static void IdCheck(HashMap users, String newId) {

		do {
			for (int i = 0; i < userList.size(); i++) {
				if (newId.equals(userList.get(i).get("���̵�"))) {
					System.out.println("�̹� ������� ���̵��Դϴ�. �ٸ� ���̵� �Է��ϼ���.");
					System.out.println("---------");
					System.out.println("�����̵� �Է� : ");
					newId = scan.next();
					i = -1;
				}
			}
			users.put("���̵�", newId);
			break;
		} while (true);
	}

	public static void SignIn() {
		boolean loginchk = false;
		while (loginchk == false) {
			System.out.println("---------");
			System.out.println("�����̵� �Է� : ");
			String signInId = scan.next();
			System.out.println("---------");
			System.out.println("����й�ȣ �Է� : ");
			String signInPw = scan.next();
			System.out.println("---------");

			for (int i = 0; i < userList.size(); i++) {
				if (signInId.equals(userList.get(i).get("���̵�"))) {
					if (signInPw.equals(userList.get(i).get("��й�ȣ"))) {
						System.out.println("ȯ���մϴ� " + userList.get(i).get("�̸�") + "��");
						loginchk = true;
					}
				} else {
					System.out.println("���̵� �Ǵ� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				}
			}
		}

		WritingListPage();
	}

	// ����1. ������ id�� ��й�ȣ�� ���� ��� �α���
	// ����2. 'ȯ���մϴ� �̸�(���̵�)��' �λ縻 ��� �� �Խ��� ������� �̵�"

	public static void EndProgram() {
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
	}

	public static void main(String[] args) {
		MainPage();
		System.out.println(userList);
	}

}
