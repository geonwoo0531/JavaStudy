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
		System.out.println("1.È¸¿ø°¡ÀÔ");
		System.out.println("2.·Î±×ÀÎ");
		System.out.println("0.Á¾·á");
		System.out.println("---------");

		while (true) {
			try {
				System.out.print("¢º¸Ş´º¼±ÅÃ : ");
				menu = scan.nextInt();
				break;
			} catch (Exception e) {
				scan = new Scanner(System.in);
				System.out.println("¿¹¿Ü¹ß»ı, ¼ıÀÚ¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
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
			System.out.println("1, 2, 0 Áß¿¡ ¼±ÅÃÇÏ¼¼¿ä.");
			MainPage();
		}
		return;
	}

	// È¸¿ø°¡ÀÔ È­¸é
	public static void SignUp() {
		HashMap<String, String> users = new HashMap<String, String>();
		System.out.println("---------");
		System.out.print("¢º¾ÆÀÌµğ ÀÔ·Â : ");
		String newId = scan.next();

		IdCheck(users, newId);

		System.out.println("---------");
		System.out.print("¢ººñ¹Ğ¹øÈ£ ÀÔ·Â : ");
		users.put("ºñ¹Ğ¹øÈ£", scan.next());
		System.out.println("---------");
		boolean nameChk = true;
		String userName = null;
		scan.nextLine();
		// Á¶°Ç1. ÀÌ¸§ ÀÔ·Â½Ã ¼ıÀÚ ÀÔ·Â ¿¹¿Ü Ã³¸® (¿µ¾î,ÇÑ±Û¸¸ °¡´É / Á¤±Ô½Ä »ç¿ë)
		while (nameChk) {
			System.out.print("¢ºÀÌ¸§ ÀÔ·Â : ");
			userName = scan.nextLine();
			if (nameChk = !Pattern.matches("^[¤¡-¤¾°¡-ÆRa-zA-Z]*$", userName)) {
				System.out.println("ÀÌ¸§Àº ¿µ¾î, ÇÑ±Û¸¸ °¡´ÉÇÕ´Ï´Ù.");
			} else
				nameChk = false;
		}
		users.put("ÀÌ¸§", userName);
		System.out.println("---------");

		userList.add(users);
		System.out.println(users.get("ÀÌ¸§") + "´Ô È¸¿ø°¡ÀÔ¿¡ ¼º°øÇÏ¿´½À´Ï´Ù.");
		try {
			MainPage();
		} catch (Exception e) {

		}
		return;
	}

	public static void IdCheck(HashMap users, String newId) {
		// ¾ÆÀÌµğ Áßº¹Ã¼Å©
		do {
			for (int i = 0; i < userList.size(); i++) {
				if (newId.equals(userList.get(i).get("¾ÆÀÌµğ"))) {
					System.out.println("ÀÌ¹Ì »ç¿ëÁßÀÎ ¾ÆÀÌµğÀÔ´Ï´Ù. ´Ù¸¥ ¾ÆÀÌµğ¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
					System.out.println("---------");
					System.out.println("¢º¾ÆÀÌµğ ÀÔ·Â : ");
					newId = scan.next();
					i = -1;
				}
			}
			users.put("¾ÆÀÌµğ", newId);
			break;
		} while (true);
		return;
	}

	public static void SignIn() {
		// Á¶°Ç1. °¡ÀÔÇÑ idÀÇ ºñ¹Ğ¹øÈ£°¡ ¸ÂÀ» °æ¿ì ·Î±×ÀÎ
		// Á¶°Ç2. 'È¯¿µÇÕ´Ï´Ù ÀÌ¸§(¾ÆÀÌµğ)´Ô' ÀÎ»ç¸» Ãâ·Â ÈÄ °Ô½ÃÆÇ ¸ñ·ÏÀ¸·Î ÀÌµ¿"
		boolean loginchk = false;
		while (loginchk == false) {
			System.out.println("---------");
			System.out.println("¢º¾ÆÀÌµğ ÀÔ·Â : ");
			String signInId = scan.next();
			System.out.println("---------");
			System.out.println("¢ººñ¹Ğ¹øÈ£ ÀÔ·Â : ");
			String signInPw = scan.next();
			System.out.println("---------");

			for (int i = 0; i < userList.size(); i++) {
				if (signInId.equals(userList.get(i).get("¾ÆÀÌµğ"))) {
					if (signInPw.equals(userList.get(i).get("ºñ¹Ğ¹øÈ£"))) {
						loginchk = true;
					}

				} else {
					System.out.println("¾ÆÀÌµğ ¶Ç´Â ºñ¹Ğ¹øÈ£°¡ Æ²·È½À´Ï´Ù.");
				}
				loginUserName = userList.get(i).get("ÀÌ¸§");
				loginUserId = userList.get(i).get("¾ÆÀÌµğ");
			}
		}
		System.out.println("È¯¿µÇÕ´Ï´Ù " + loginUserName + "(" + loginUserId + ")´Ô");

		WritingListPage();
		return;
	}

	public static void WritingListPage() {
		int menu;
		System.out.println("------------------------------------");
		System.out.println("¹øÈ£\tÁ¦¸ñ\t\tÀÛ¼ºÀÚ\tÀÛ¼º³¯Â¥");
		System.out.println("------------------------------------");
		for (int i = 0; i < writingList.size(); i++) {
			System.out.println((Integer.parseInt(writingList.get(i).get("±Û ¹øÈ£"))) + "\t"
					+ writingList.get(i).get("±Û Á¦¸ñ") + "\t\t" + loginUserName + "(" + loginUserId + ")" + "\t"
					+ sdFormat2.format(writingList.get(i).get("ÀÛ¼º³¯Â¥")));
		}
		// 1 Ã¹¹øÂ° ±Û Á¦¸ñ ±è»ç¿ø(a001)
		// 2 µÎ¹øÂ° ±Û Á¦¸ñ ÃÖ»ç¿ø(b001)
		// 3 ¼¼¹øÂ° ±Û Á¦¸ñ ÀÌ»ç¿ø(c001)

		System.out.println("--------------------------");
		System.out.println("1.»õ ±Û ÀÛ¼º");
		System.out.println("2.±Û Á¶È¸");
		System.out.println("0.·Î±×¾Æ¿ô");
		System.out.println("--------------------------");
		while (true) {
			try {
				System.out.print("¢º¸Ş´º¼±ÅÃ : ");
				menu = scan.nextInt();
				System.out.println("--------------------------");
				break;
			} catch (Exception e) {
				scan = new Scanner(System.in);
				System.out.println("¿¹¿Ü¹ß»ı, ¼ıÀÚ¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
			}
		}
		// Á¶°Ç1. °Ô½ÃÆÇ ¸ñ·Ï¿¡ ±Û¹øÈ£/Á¦¸ñ/ÀÛ¼ºÀÚ º¸¿©ÁÖ±â
		// Á¶°Ç2. ÀÛ¼ºÀÚ´Â ÀÌ¸§(¾ÆÀÌµğ)·Î º¸¿©ÁÖ±â
		// Á¶°Ç3. ·Î±×¾Æ¿ô ¼±ÅÃ½Ã È­¸é1·Î ÀÌµ¿

		switch (menu) {
		case 1:
			NewWritingPage();
			break;
		case 2:
			ChoiceWritingPage();
			break;
		case 0:
			System.out.println("·Î±×¾Æ¿ô µÇ¾ú½À´Ï´Ù.");
			try {
				MainPage();
			} catch (Exception e) {

			}
			break;
		default:
			System.out.println("1,2,0Áß¿¡ ¼±ÅÃÇØÁÖ¼¼¿ä.");
			WritingListPage();
		}
		return;
	}

	public static void NewWritingPage() {
		HashMap<String, String> writings = new HashMap();
		writingNumber = Integer.parseInt(writingNumber) + 1 + "";
		System.out.println("---------------");
		System.out.print("¢º±Û Á¦¸ñ ÀÔ·Â : ");
		scan.nextLine();
		String title = scan.nextLine();
		System.out.println("----------------");
		System.out.print("¢º±Û ³»¿ë ÀÔ·Â : ");
		String content = scan.nextLine();
		System.out.println("----------------");
		Date dateTime = new Date();
		String writingDate = sdFormat2.format(dateTime);
		writings.put("±Û ¹øÈ£", writingNumber + "");
		writings.put("±Û Á¦¸ñ", title);
		writings.put("±Û ³»¿ë", content);
		writings.put("ÀÛ¼ºÀÚ", loginUserName);
		writings.put("ÀÛ¼º³¯Â¥", writingDate);
		// Á¶°Ç1. Á¦¸ñ,³»¿ëÀ» ÀÛ¼º ÈÄ ¼º°ø¿©ºÎ º¸¿©ÁÖ°í ¼öÁ¤ÇÑ »ó¼¼È­¸éÀ¸·Î ÀÌµ¿
		// Á¶°Ç2. ±Û ¹øÈ£´Â ¼ø¼­´ë·Î ¸Å±â°í ÀÛ¼ºÀÚ´Â ·Î±×ÀÎ Á¤º¸·Î Ã³¸®"
		writingList.add(writings);

		WritingListPage();
		return;
	}

	public static void ChoiceWritingPage() {
		int intWritingNumber;
		System.out.println("---------------");
		while (true) {
			try {
				System.out.print("¢º±Û ¹øÈ£¼±ÅÃ : ");
				intWritingNumber = scan.nextInt();
				System.out.println("---------------");
				break;
			} catch (Exception e) {
				scan = new Scanner(System.in);
				System.out.println("¿¹¿Ü¹ß»ı, ¾ø´Â ±Û ¹øÈ£ÀÔ´Ï´Ù.");
			}
		}
		String writingNumber = String.valueOf(intWritingNumber);
		ReadWritingPage(writingNumber);
		return;
	}

	public static void ReadWritingPage(String writingNumber) {
		Collections.sort(writingList, Collections.reverseOrder());
		System.out.println("---------------------");
		// 1 Ã¹¹øÂ° ±Û Á¦¸ñ ±è»ç¿ø(a001)
		System.out.println(writingNumber + "\t" + writingList.get(Integer.parseInt(writingNumber) - 1).get("±Û Á¦¸ñ")
				+ "\t" + writingList.get(Integer.parseInt(writingNumber) - 1).get("ÀÛ¼ºÀÚ") + "(" + loginUserId + ")"
				+ "\t" + writingList.get(Integer.parseInt(writingNumber) - 1).get("ÀÛ¼º³¯Â¥"));
		System.out.println("---------------------");
		// ³»¿ëÀº ÇÑÁÙ¸¸º¸¿©Áàµµ µË´Ï´Ù. ±Û ³»¿ë ºÎºĞ.
		System.out.println(writingList.get(Integer.parseInt(writingNumber) - 1).get("±Û ³»¿ë"));
		System.out.println("---------------------");
		// Á¶°Ç1. º»ÀÎÀÌ ÀÛ¼ºÇÑ ±ÛÀÏ¶§ 1.¼öÁ¤ 2.»èÁ¦ ¸Ş´º¿¡ ³ªÅ¸³»±â
		// System.out.println("1.¼öÁ¤");
		// System.out.println("2.»èÁ¦");
		if (loginUserName.equals(writingList.get(Integer.parseInt(writingNumber) - 1).get("ÀÛ¼ºÀÚ"))) {
			System.out.println("1.¼öÁ¤");
			System.out.println("2.»èÁ¦");
		}
		System.out.println("0.µÚ·Î");
		System.out.println("---------------------");
		int menu;
		scan = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("¢º¸Ş´º¼±ÅÃ : ");
				menu = scan.nextInt();
				break;
			} catch (Exception e) {
				scan = new Scanner(System.in);
				System.out.println("¿¹¿Ü¹ß»ı, ¼ıÀÚ¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
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
			System.out.println("0,1,2 Áß¿¡ ¼±ÅÃÇÏ¼¼¿ä.");
			ReadWritingPage(writingNumber);
		}
		return;
	}

	// ±Û ¼öÁ¤ ÆäÀÌÁö È­¸é
	public static void ModifyWritingPage(String writingNumber) {
		// Á¶°Ç1. ¼öÁ¤ÇÒ Á¦¸ñ,³»¿ëÀ» ÀÛ¼º ÈÄ ¼º°ø¿©ºÎ º¸¿©ÁÖ°í ¼öÁ¤ÇÑ »ó¼¼È­¸éÀ¸·Î ÀÌµ¿
		System.out.println("----------------");
		System.out.println("¢º±Û Á¦¸ñ ÀÔ·Â : ");
		scan.nextLine();
		String title = scan.nextLine();
		System.out.println("----------------");
		System.out.println("¢º±Û ³»¿ë ÀÔ·Â : ");
		String content = scan.nextLine();
		System.out.println("----------------");
		writingList.get(Integer.parseInt(writingNumber) - 1).put("±Û Á¦¸ñ", title);
		writingList.get(Integer.parseInt(writingNumber) - 1).put("±Û ³»¿ë", content);
		writingList.get(Integer.parseInt(writingNumber) - 1).put("ÀÛ¼ºÀÚ", loginUserName);
		writingList.get(Integer.parseInt(writingNumber) - 1).put("ÀÛ¼º³¯Â¥", sdFormat2.format(new Date()));

		System.out.println("¼öÁ¤µÇ¾ú½À´Ï´Ù.");
		ReadWritingPage(writingNumber);
		return;
	}

	// ±Û »èÁ¦ È®ÀÎ ÆäÀÌÁö
	public static void DeleteWritingPage(String writingNumber) {
		// Á¶°Ç1. À§¿Í°°ÀÌ »èÁ¦¿©ºÎ ÇÑ ¹ø ´õ ¹¯±â
		// Á¶°Ç2. »èÁ¦ÇÏ·Á´Â ±ÛÀÇ ¹øÈ£¸¦ º¸¿©ÁÖ°í(ex. 1¹ø ±Û) ¼Ò¹®ÀÚ y ¶Ç´Â nÀ¸·Î »èÁ¦¿©ºÎ ÀÔ·Â
		// Á¶°Ç3. »èÁ¦ ¼º°ø¿©ºÎ º¸¿©ÁÖ°í °Ô½ÃÆÇ ¸ñ·ÏÀ¸·Î ÀÌµ¿"
		System.out.println("------------------");
		System.out.println("¢º" + writingNumber + "¹ø ±ÛÀ» »èÁ¦ÇÏ½Ã°Ú½À´Ï±î?(y/n) : ");
		String deleteChk = scan.next();
		scan = new Scanner(System.in);

		if ("y".equals(deleteChk)) {
			writingList.remove(Integer.parseInt(writingNumber) - 1);
			System.out.println("»èÁ¦µÇ¾ú½À´Ï´Ù.");
			WritingListPage();
		} else if ("n".equals(deleteChk)) {
			System.out.println("»èÁ¦ Ãë¼ÒµÇ¾ú½À´Ï´Ù.");
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
		System.out.println("ÇÁ·Î±×·¥ÀÌ Á¾·áµÇ¾ú½À´Ï´Ù.");
	}

}
