package 기초_조건문_반복문;
import java.util.Scanner;

/*
 * 0 이 입력될 때까지 정수를 계속 입력받아 3의 배수와 5의 배수를 
 * 제외한 수들의 개수를 출력하는 프로그램을 작성하시오.
 */
public class Main07 {
	public static void main(String[] args)
	{
		//변수 선언
		int cnt=0, input=0;
		Scanner sc = new Scanner(System.in);
		//for
		for(;;) 
		{
			//사용자입력을 변수에 저장
			input = sc.nextInt();
			//사용자입력이 0인경우 반복문 종료
			if (input == 0)
			{
				break;
			}
			//3의배수, 5의배수가 아닌 숫자는 횟수누적
			if( input % 3 != 0 && input % 5 != 0)
			{
				cnt++;
			}
		}
		//누적횟수 결과 출력
		System.out.println(cnt);
	}
}






