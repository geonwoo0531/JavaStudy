package first;

public class First {
	int a = 123; // 기본형변수이며 멤버변수의 인스턴스변수
	static int b = 456; // 기본형변수이며 멤버변수의 클래스변수
	static int c = 789;

	public void changeA(int i) { // int i 는 매개변수(파라미터)이면서 지역변수
		System.out.println("매개변수 i 생성");
		this.a = i; // 인스턴스변수 a의 값이 매개변수(파라미터) i값으로 바뀜
		System.out.println("First인스턴스의 a값을 매개변수 i 값인 " + i + "로 변경");
		System.out.println("매개변수 i 소멸");
	}

	public void changeB(int j) { // int j 는 매개변수(파라미터)이면서 지역변수
		System.out.println("매개변수 j 생성");
		this.b = j; // 클래스변수 b의 값이 매개변수(파라미터) j값으로 바뀜
		System.out.println("First인스턴스의 b값을 매개변수 j 값인" + j + "로 변경");
		System.out.println("매개변수 j 소멸");

	}

	public static void main(String[] args) {

		int c = 987; // 지역변수

		First first = new First(); // 참조형변수
		First first2 = new First();

		System.out.println("지역변수 c : " + c);
		System.out.println("first의 c : " + first.c);

		// System.out.println(a); //오류 > 인스턴스객체를 통해 호출해야함
		System.out.println("클래스변수 b : " + b); // 인스턴스 없이 함수내 호출 가능

		first.changeA(321);
		System.out.println("first의 a : " + first.a);
		System.out.println("first2의 a : " + first2.a);
		// 인스턴스변수는 서로다른 저장공간을 부여

		first.changeB(654);
		System.out.println("first의 b : " + first.b);
		System.out.println("first2의 b : " + first2.b);
		// 클래스변수는 하나의 저장공간을 공유

	}

}
