package 기초_조건문_반복문;
import java.util.Scanner;

/*
 * 년도를 입력받아 윤년(leap year)인지 평년(common year)인지 판단하는 프로그램을 작성하시오.
 * 
 *400으로 나누어떨어지면 윤년이다.
 *또는 4로 나누어떨어지고 100으로 나누어떨어지지 않으면 윤년이다.
 *나머지는 모두 평년이다.
 */
public class Main04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("년도를 입력해주세요 : ");
		int year;
		year = sc.nextInt();
		
		String result;
		
		if(year%400 == 0) {
			System.out.println("윤년입니다.");
			result = "leap year";
		}
		else if(year%4 == 0 && year%100 == 0) {
			System.out.println("평년입니다.");
			result = "common year";
		}
		else if(year%4 == 0 && year%100 != 0) {
			System.out.println("윤년입니다.");
			result = "leap year";
		}
		else {
			System.out.println("평년입니다.");
			result = "common year";
		}
		
		System.out.println(result);
	}
	
	/*
	 * 400으로 나누어 떨어지면 운년
	 * 4로 나누어 떨어지고 100으로 나누어 떨어지면 평년
	 * 4로 나누어 떨어지고 100으로 나누어 떨어지지 않으면 운년
	 */


}
