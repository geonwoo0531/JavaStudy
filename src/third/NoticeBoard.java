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
		System.out.println("1.회원가입");
		System.out.println("2.로그인");
		System.out.println("0.종료");
		System.out.println("---------");

		while (true) {
			try {
				System.out.print("▶메뉴선택 : ");
				menu = scan.nextInt();
				break;
			} catch (Exception e) {
				scan = new Scanner(System.in);
				System.out.println("예외발생, 숫자를 입력하세요.");
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
			System.out.println("1, 2, 0 중에 선택하세요.");
			MainPage();
		}
		return;
	}

	// 회원가입 화면
	public static void SignUp() {
		HashMap<String, String> users = new HashMap<String, String>();
		System.out.println("---------");
		System.out.print("▶아이디 입력 : ");
		String newId = scan.next();

		IdCheck(users, newId);

		System.out.println("---------");
		System.out.print("▶비밀번호 입력 : ");
		users.put("비밀번호", scan.next());
		System.out.println("---------");
		boolean nameChk = true;
		String userName = null;
		scan.nextLine();
		// 조건1. 이름 입력시 숫자 입력 예외 처리 (영어,한글만 가능 / 정규식 사용)
		while (nameChk) {
			System.out.print("▶이름 입력 : ");
			userName = scan.nextLine();
			if (nameChk = !Pattern.matches("^[ㄱ-ㅎ가-힣a-zA-Z]*$", userName)) {
				System.out.println("이름은 영어, 한글만 가능합니다.");
			} else
				nameChk = false;
		}
		users.put("이름", userName);
		System.out.println("---------");

		userList.add(users);
		System.out.println(users.get("이름") + "님 회원가입에 성공하였습니다.");
		try {
			MainPage();
		} catch (Exception e) {

		}
		return;
	}

	public static void IdCheck(HashMap users, String newId) {
		// 아이디 중복체크
		do {
			for (int i = 0; i < userList.size(); i++) {
				if (newId.equals(userList.get(i).get("아이디"))) {
					System.out.println("이미 사용중인 아이디입니다. 다른 아이디를 입력하세요.");
					System.out.println("---------");
					System.out.println("▶아이디 입력 : ");
					newId = scan.next();
					i = -1;
				}
			}
			users.put("아이디", newId);
			break;
		} while (true);
		return;
	}

	public static void SignIn() {
		// 조건1. 가입한 id의 비밀번호가 맞을 경우 로그인
		// 조건2. '환영합니다 이름(아이디)님' 인사말 출력 후 게시판 목록으로 이동"
		boolean loginchk = false;
		while (loginchk == false) {
			System.out.println("---------");
			System.out.println("▶아이디 입력 : ");
			String signInId = scan.next();
			System.out.println("---------");
			System.out.println("▶비밀번호 입력 : ");
			String signInPw = scan.next();
			System.out.println("---------");

			for (int i = 0; i < userList.size(); i++) {
				if (signInId.equals(userList.get(i).get("아이디"))) {
					if (signInPw.equals(userList.get(i).get("비밀번호"))) {
						loginchk = true;
					}

				} else {
					System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
				}
				loginUserName = userList.get(i).get("이름");
				loginUserId = userList.get(i).get("아이디");
			}
		}
		System.out.println("환영합니다 " + loginUserName + "(" + loginUserId + ")님");

		WritingListPage();
		return;
	}

	public static void WritingListPage() {
		int menu;
		System.out.println("------------------------------------");
		System.out.println("번호\t제목\t\t작성자\t작성날짜");
		System.out.println("------------------------------------");
		for (int i = 0; i < writingList.size(); i++) {
			System.out.println((Integer.parseInt(writingList.get(i).get("글 번호"))) + "\t"
					+ writingList.get(i).get("글 제목") + "\t\t" + loginUserName + "(" + loginUserId + ")" + "\t"
					+ sdFormat2.format(writingList.get(i).get("작성날짜")));
		}
		// 1 첫번째 글 제목 김사원(a001)
		// 2 두번째 글 제목 최사원(b001)
		// 3 세번째 글 제목 이사원(c001)

		System.out.println("--------------------------");
		System.out.println("1.새 글 작성");
		System.out.println("2.글 조회");
		System.out.println("0.로그아웃");
		System.out.println("--------------------------");
		while (true) {
			try {
				System.out.print("▶메뉴선택 : ");
				menu = scan.nextInt();
				System.out.println("--------------------------");
				break;
			} catch (Exception e) {
				scan = new Scanner(System.in);
				System.out.println("예외발생, 숫자를 입력하세요.");
			}
		}
		// 조건1. 게시판 목록에 글번호/제목/작성자 보여주기
		// 조건2. 작성자는 이름(아이디)로 보여주기
		// 조건3. 로그아웃 선택시 화면1로 이동

		switch (menu) {
		case 1:
			NewWritingPage();
			break;
		case 2:
			ChoiceWritingPage();
			break;
		case 0:
			System.out.println("로그아웃 되었습니다.");
			try {
				MainPage();
			} catch (Exception e) {

			}
			break;
		default:
			System.out.println("1,2,0중에 선택해주세요.");
			WritingListPage();
		}
		return;
	}

	public static void NewWritingPage() {
		HashMap<String, String> writings = new HashMap();
		writingNumber = Integer.parseInt(writingNumber) + 1 + "";
		System.out.println("---------------");
		System.out.print("▶글 제목 입력 : ");
		scan.nextLine();
		String title = scan.nextLine();
		System.out.println("----------------");
		System.out.print("▶글 내용 입력 : ");
		String content = scan.nextLine();
		System.out.println("----------------");
		Date dateTime = new Date();
		String writingDate = sdFormat2.format(dateTime);
		writings.put("글 번호", writingNumber + "");
		writings.put("글 제목", title);
		writings.put("글 내용", content);
		writings.put("작성자", loginUserName);
		writings.put("작성날짜", writingDate);
		// 조건1. 제목,내용을 작성 후 성공여부 보여주고 수정한 상세화면으로 이동
		// 조건2. 글 번호는 순서대로 매기고 작성자는 로그인 정보로 처리"
		writingList.add(writings);

		WritingListPage();
		return;
	}

	public static void ChoiceWritingPage() {
		int intWritingNumber;
		System.out.println("---------------");
		while (true) {
			try {
				System.out.print("▶글 번호선택 : ");
				intWritingNumber = scan.nextInt();
				System.out.println("---------------");
				break;
			} catch (Exception e) {
				scan = new Scanner(System.in);
				System.out.println("예외발생, 없는 글 번호입니다.");
			}
		}
		String writingNumber = String.valueOf(intWritingNumber);
		ReadWritingPage(writingNumber);
		return;
	}

	public static void ReadWritingPage(String writingNumber) {
		Collections.sort(writingList, Collections.reverseOrder());
		System.out.println("---------------------");
		// 1 첫번째 글 제목 김사원(a001)
		System.out.println(writingNumber + "\t" + writingList.get(Integer.parseInt(writingNumber) - 1).get("글 제목")
				+ "\t" + writingList.get(Integer.parseInt(writingNumber) - 1).get("작성자") + "(" + loginUserId + ")"
				+ "\t" + writingList.get(Integer.parseInt(writingNumber) - 1).get("작성날짜"));
		System.out.println("---------------------");
		// 내용은 한줄만보여줘도 됩니다. 글 내용 부분.
		System.out.println(writingList.get(Integer.parseInt(writingNumber) - 1).get("글 내용"));
		System.out.println("---------------------");
		// 조건1. 본인이 작성한 글일때 1.수정 2.삭제 메뉴에 나타내기
		// System.out.println("1.수정");
		// System.out.println("2.삭제");
		if (loginUserName.equals(writingList.get(Integer.parseInt(writingNumber) - 1).get("작성자"))) {
			System.out.println("1.수정");
			System.out.println("2.삭제");
		}
		System.out.println("0.뒤로");
		System.out.println("---------------------");
		int menu;
		scan = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("▶메뉴선택 : ");
				menu = scan.nextInt();
				break;
			} catch (Exception e) {
				scan = new Scanner(System.in);
				System.out.println("예외발생, 숫자를 입력하세요.");
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
			System.out.println("0,1,2 중에 선택하세요.");
			ReadWritingPage(writingNumber);
		}
		return;
	}

	// 글 수정 페이지 화면
	public static void ModifyWritingPage(String writingNumber) {
		// 조건1. 수정할 제목,내용을 작성 후 성공여부 보여주고 수정한 상세화면으로 이동
		System.out.println("----------------");
		System.out.println("▶글 제목 입력 : ");
		scan.nextLine();
		String title = scan.nextLine();
		System.out.println("----------------");
		System.out.println("▶글 내용 입력 : ");
		String content = scan.nextLine();
		System.out.println("----------------");
		writingList.get(Integer.parseInt(writingNumber) - 1).put("글 제목", title);
		writingList.get(Integer.parseInt(writingNumber) - 1).put("글 내용", content);
		writingList.get(Integer.parseInt(writingNumber) - 1).put("작성자", loginUserName);
		writingList.get(Integer.parseInt(writingNumber) - 1).put("작성날짜", sdFormat2.format(new Date()));

		System.out.println("수정되었습니다.");
		ReadWritingPage(writingNumber);
		return;
	}

	// 글 삭제 확인 페이지
	public static void DeleteWritingPage(String writingNumber) {
		// 조건1. 위와같이 삭제여부 한 번 더 묻기
		// 조건2. 삭제하려는 글의 번호를 보여주고(ex. 1번 글) 소문자 y 또는 n으로 삭제여부 입력
		// 조건3. 삭제 성공여부 보여주고 게시판 목록으로 이동"
		System.out.println("------------------");
		System.out.println("▶" + writingNumber + "번 글을 삭제하시겠습니까?(y/n) : ");
		String deleteChk = scan.next();
		scan = new Scanner(System.in);

		if ("y".equals(deleteChk)) {
			writingList.remove(Integer.parseInt(writingNumber) - 1);
			System.out.println("삭제되었습니다.");
			WritingListPage();
		} else if ("n".equals(deleteChk)) {
			System.out.println("삭제 취소되었습니다.");
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
		System.out.println("프로그램이 종료되었습니다.");
	}

}
