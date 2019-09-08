package 기초_조건문_반복문;
import java.util.Scanner;

//정올 250번 문제임

public class Main09 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("성별을 입력해주세요(m/M , f/F) : ");
		String sung = sc.next();
		
		System.out.print("출생연도를 입력해주세요 : ");
		int number = sc.nextInt();
		
		if(sung.equals("m") || sung.equals("M") ) {
			if(number >= 2000) {
				number = 3;
			}
			else {
				number = 1;
			}
		}
		
		else if(sung.equals("f") || sung.equals("F") ) {
			if(number >= 2000) {
				number = 4;
			}
			else {
				number = 2;
			}
		}
		
		System.out.print("주민등록번호 뒷자리 첫번째 번호는 : " + number + "입니다.");
		
	}

}
