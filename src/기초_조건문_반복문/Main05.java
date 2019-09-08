package 기초_조건문_반복문;
import java.util.Scanner;

/*
 * 두 개의 실수를 입력받아 모두 4.0 이상이면 "A", 모두 3.0 이상이면 "B", 아니면 "C" 라고 출력하는 프로그램을 작성하시오.
 */
public class Main05 {
	public static void main(String[] args) {
		
		double a;
		double b;
		String result;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 실수를 입력해주세요 : ");
		a = sc.nextDouble(); //<<<아 이거 주의 하자..... Int로 썼다가 오류먹어서 개쪽당함
		
		System.out.print("두번째 실수를 입력해주세요 : ");
		b = sc.nextDouble();
		
		if (a >= 4.0 && b >= 4.0) {
			result = "A";
		}
		else if (a >= 3.0 && b >= 3.0) {
			result = "B";
		}
		else {
			result = "C";
		}
		System.out.println("결과값 : " + result);
		
		
		
		
		
	}

}
