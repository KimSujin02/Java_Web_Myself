package 기초_조건문_반복문;
import java.util.Scanner;

public class Main10 {
	public static void main(String args[]) {
		//정올 134번 문제(기초다지기)
		Scanner sc = new Scanner(System.in);
		
		int even = 0, odd = 0, i;
		int a;
		
		System.out.print("정수 10개를 입력해주세요 : ");
		for (i = 0; i < 10; i++) {
			a = sc.nextInt();
			if(a%2==0) {//짝수일때
				even++;
			}
			else {
				odd++;
			}
		}
		
		System.out.println("짝수의 개수 : " + even + "\n홀수의 개수 : " + odd);
		
		
	}
}
