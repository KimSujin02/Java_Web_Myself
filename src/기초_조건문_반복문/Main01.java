package 기초_조건문_반복문;
import java.util.Scanner;

/*
 * 프로그램 제어하는 제어문 - 조건문
 * 조건문 : boolean 타입의 데이터 값이 true인 경우에 실행할 코드를 분리할 수 있는 문법이다.
 * if문 : if(관계식 또는 변수값) -> true값이 연산되면 if안에서 실행할 코드를 지정할 수 있는 문법
 * if문이 만족했을때 실행 할 코드는 중괄호 안에 작성한다.
 */
public class Main01 {

	public static void main(String[] args) {
		System.out.println("------Scanner 실습------ \n");
		//사용자 입력을 처리하는 코드
		//Scanner : 사용자 입력을 콘솔창에서 받기 위해 생성한 자료형
		Scanner sc = new Scanner(System.in);
		//사용자 입력이 홀수인지 짝수인지 확인
		int num;
		System.out.print("원하는 숫자값을 입력해주세요 : ");
		num = sc.nextInt(); //사용자가 입력한 숫자값을 num 변수에 저장한다.
		System.out.println("사용자 입력값 : " + num + "\n\n");
		//사용자 입력값이 홀수인지 짝수인지 구분
		
		System.out.println("------if문 실습-----\n");
		
		if(num%2 == 1) { // %는 나머지를 구하는 연산자 이다. 연산의 뜻은 num을 2로 나눠서 나머지가 1이면,,
			System.out.println(num + "은 홀수 입니다.\n\n");
		}
		
		else {
			System.out.println(num + "은 짝수 입니다.\n\n");
		}
		
		
		//else if(관계식) : if문에 옵션으로 위 조건들을 만족하지 않을때,
		//관계식이 만족하는지 확인하는 문법
		/*
		 * if(관계식1) {
		 * 	실행문1
		 * }
		 * else if(관계식2) {
		 * 	실행문2
		 * }
		 * else if(관계식3) {
		 * 	실행문3
		 * }
		 * else {
		 * 	실행문4
		 * }
		 * 
		 * 따라서 else if문은 관계식을 넣을 수 있으며, 여러개 사용이 가능하다.
		 */
		
		
		System.out.println("------if문과 Scanner 실습------\n");
		
		//사용자로 부터 성을 입력받아 분류하기(여/남)
		String name; //문자열을 저장하는 name 변수생성
		System.out.print("본인의 이름 입력 : ");
		name = sc.next();
		
		//name 입력값을 홍길동이냐 아니냐를 분류할 것임 아니면 도경수 아니면 김수진 모든게 아니면 그런 사람 없음
		
		if(name.equals("홍길동")) {
			System.out.println("홍길동님 안녕하세요\n\n");
		}
		else if(name.equals("도경수")) {
			System.out.println("도경수님 안녕하세요 ♥\n\n");
		}
		else if(name.equals("김수진")) {
			System.out.println("김수진님 안녕하세요 ♥\n\n");
		}
		else {
			System.out.println("회원이 아니십니다.\n\n");
		}
	}

}
