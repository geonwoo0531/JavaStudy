package third;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class NoticeBoard {
	static ArrayList<HashMap<String, String>> userList = new ArrayList<HashMap<String, String>>();
	static Scanner scan = new Scanner(System.in);
	static ArrayList<HashMap<String, String>> writingList = new ArrayList<HashMap<String, String>>();
	static String loginUserName;
	static String loginUserId;
	static String writingNumber = "0";
	static SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
	static SimpleDateFormat sdFormat2 = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

	public static void MainPage() throws Exception {
		int menu;
		System.out.println("---------");
		System.out.println("1.ȸ������");
		System.out.println("2.�α���");
		System.out.println("0.����");
		System.out.println("---------");

		while (true) {
			try {
				System.out.print("���޴����� : ");
				menu = scan.nextInt();
				break;
			} catch (Exception e) {
				scan = new Scanner(System.in);
				System.out.println("���ܹ߻�, ���ڸ� �Է��ϼ���.");
			}
		}

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
			System.out.println("1, 2, 0 �߿� �����ϼ���.");
			MainPage();
		}
		return;
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
		boolean nameChk = true;
		String userName = null;
		scan.nextLine();
		// ����1. �̸� �Է½� ���� �Է� ���� ó�� (����,�ѱ۸� ���� / ���Խ� ���)
		while (nameChk) {
			System.out.print("���̸� �Է� : ");
			userName = scan.nextLine();
			if (nameChk = !Pattern.matches("^[��-����-�Ra-zA-Z]*$", userName)) {
				System.out.println("�̸��� ����, �ѱ۸� �����մϴ�.");
			} else
				nameChk = false;
		}
		users.put("�̸�", userName);
		System.out.println("---------");

		userList.add(users);
		System.out.println(users.get("�̸�") + "�� ȸ�����Կ� �����Ͽ����ϴ�.");
		try {
			MainPage();
		} catch (Exception e) {

		}
		return;
	}

	public static void IdCheck(HashMap users, String newId) {
		// ���̵� �ߺ�üũ
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
		return;
	}

	public static void SignIn() {
		// ����1. ������ id�� ��й�ȣ�� ���� ��� �α���
		// ����2. 'ȯ���մϴ� �̸�(���̵�)��' �λ縻 ��� �� �Խ��� ������� �̵�"
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
						loginchk = true;
					}

				} else {
					System.out.println("���̵� �Ǵ� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				}
				loginUserName = userList.get(i).get("�̸�");
				loginUserId = userList.get(i).get("���̵�");
			}
		}
		System.out.println("ȯ���մϴ� " + loginUserName + "(" + loginUserId + ")��");

		WritingListPage();
		return;
	}

	public static void WritingListPage() {
		int menu;
		System.out.println("------------------------------------");
		System.out.println("��ȣ\t����\t\t�ۼ���\t�ۼ���¥");
		System.out.println("------------------------------------");
		for (int i = 0; i < writingList.size(); i++) {
			System.out.println((Integer.parseInt(writingList.get(i).get("�� ��ȣ"))) + "\t"
					+ writingList.get(i).get("�� ����") + "\t\t" + loginUserName + "(" + loginUserId + ")" + "\t"
					+ sdFormat2.format(writingList.get(i).get("�ۼ���¥")));
		}
		// 1 ù��° �� ���� ����(a001)
		// 2 �ι�° �� ���� �ֻ��(b001)
		// 3 ����° �� ���� �̻��(c001)

		System.out.println("--------------------------");
		System.out.println("1.�� �� �ۼ�");
		System.out.println("2.�� ��ȸ");
		System.out.println("0.�α׾ƿ�");
		System.out.println("--------------------------");
		while (true) {
			try {
				System.out.print("���޴����� : ");
				menu = scan.nextInt();
				System.out.println("--------------------------");
				break;
			} catch (Exception e) {
				scan = new Scanner(System.in);
				System.out.println("���ܹ߻�, ���ڸ� �Է��ϼ���.");
			}
		}
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
			try {
				MainPage();
			} catch (Exception e) {

			}
			break;
		default:
			System.out.println("1,2,0�߿� �������ּ���.");
			WritingListPage();
		}
		return;
	}

	public static void NewWritingPage() {
		HashMap<String, String> writings = new HashMap();
		writingNumber = Integer.parseInt(writingNumber) + 1 + "";
		System.out.println("---------------");
		System.out.print("���� ���� �Է� : ");
		scan.nextLine();
		String title = scan.nextLine();
		System.out.println("----------------");
		System.out.print("���� ���� �Է� : ");
		String content = scan.nextLine();
		System.out.println("----------------");
		Date dateTime = new Date();
		String writingDate = sdFormat2.format(dateTime);
		writings.put("�� ��ȣ", writingNumber + "");
		writings.put("�� ����", title);
		writings.put("�� ����", content);
		writings.put("�ۼ���", loginUserName);
		writings.put("�ۼ���¥", writingDate);
		// ����1. ����,������ �ۼ� �� �������� �����ְ� ������ ��ȭ������ �̵�
		// ����2. �� ��ȣ�� ������� �ű�� �ۼ��ڴ� �α��� ������ ó��"
		writingList.add(writings);

		WritingListPage();
		return;
	}

	public static void ChoiceWritingPage() {
		int intWritingNumber;
		System.out.println("---------------");
		while (true) {
			try {
				System.out.print("���� ��ȣ���� : ");
				intWritingNumber = scan.nextInt();
				System.out.println("---------------");
				break;
			} catch (Exception e) {
				scan = new Scanner(System.in);
				System.out.println("���ܹ߻�, ���� �� ��ȣ�Դϴ�.");
			}
		}
		String writingNumber = String.valueOf(intWritingNumber);
		ReadWritingPage(writingNumber);
		return;
	}

	public static void ReadWritingPage(String writingNumber) {
		Collections.sort(writingList, Collections.reverseOrder());
		System.out.println("---------------------");
		// 1 ù��° �� ���� ����(a001)
		System.out.println(writingNumber + "\t" + writingList.get(Integer.parseInt(writingNumber) - 1).get("�� ����")
				+ "\t" + writingList.get(Integer.parseInt(writingNumber) - 1).get("�ۼ���") + "(" + loginUserId + ")"
				+ "\t" + writingList.get(Integer.parseInt(writingNumber) - 1).get("�ۼ���¥"));
		System.out.println("---------------------");
		// ������ ���ٸ������൵ �˴ϴ�. �� ���� �κ�.
		System.out.println(writingList.get(Integer.parseInt(writingNumber) - 1).get("�� ����"));
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
		int menu;
		scan = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("���޴����� : ");
				menu = scan.nextInt();
				break;
			} catch (Exception e) {
				scan = new Scanner(System.in);
				System.out.println("���ܹ߻�, ���ڸ� �Է��ϼ���.");
			}
		}
		System.out.println("---------------------");
		switch (menu) {
		case 1:
			ModifyWritingPage(writingNumber);
			break;
		case 2:
			DeleteWritingPage(writingNumber);
			break;
		case 0:
			WritingListPage();
			break;
		default:
			System.out.println("0,1,2 �߿� �����ϼ���.");
			ReadWritingPage(writingNumber);
		}
		return;
	}

	// �� ���� ������ ȭ��
	public static void ModifyWritingPage(String writingNumber) {
		// ����1. ������ ����,������ �ۼ� �� �������� �����ְ� ������ ��ȭ������ �̵�
		System.out.println("----------------");
		System.out.println("���� ���� �Է� : ");
		scan.nextLine();
		String title = scan.nextLine();
		System.out.println("----------------");
		System.out.println("���� ���� �Է� : ");
		String content = scan.nextLine();
		System.out.println("----------------");
		writingList.get(Integer.parseInt(writingNumber) - 1).put("�� ����", title);
		writingList.get(Integer.parseInt(writingNumber) - 1).put("�� ����", content);
		writingList.get(Integer.parseInt(writingNumber) - 1).put("�ۼ���", loginUserName);
		writingList.get(Integer.parseInt(writingNumber) - 1).put("�ۼ���¥", sdFormat2.format(new Date()));

		System.out.println("�����Ǿ����ϴ�.");
		ReadWritingPage(writingNumber);
		return;
	}

	// �� ���� Ȯ�� ������
	public static void DeleteWritingPage(String writingNumber) {
		// ����1. ���Ͱ��� �������� �� �� �� ����
		// ����2. �����Ϸ��� ���� ��ȣ�� �����ְ�(ex. 1�� ��) �ҹ��� y �Ǵ� n���� �������� �Է�
		// ����3. ���� �������� �����ְ� �Խ��� ������� �̵�"
		System.out.println("------------------");
		System.out.println("��" + writingNumber + "�� ���� �����Ͻðڽ��ϱ�?(y/n) : ");
		String deleteChk = scan.next();
		scan = new Scanner(System.in);

		if ("y".equals(deleteChk)) {
			writingList.remove(Integer.parseInt(writingNumber) - 1);
			System.out.println("�����Ǿ����ϴ�.");
			WritingListPage();
		} else if ("n".equals(deleteChk)) {
			System.out.println("���� ��ҵǾ����ϴ�.");
			WritingListPage();
		}
		return;

	}

	public static void sortDate(ArrayList<HashMap<String, String>> temp) {
		Collections.sort(temp, Collections.reverseOrder());
	}

	public static void EndProgram() {
		System.exit(0);
	}

	public static void main(String[] args) {
		try {
			MainPage();
		} catch (Exception e) {
		}
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
	}

}
