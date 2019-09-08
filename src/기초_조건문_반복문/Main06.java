package 기초_조건문_반복문;
import java.util.Scanner;

/*
 * 반복문 예제
 * 반복문 : 특정 규칙, 일정한 결과를 반복적으로 수행하도록 코드흐름을 제어하는 문법
 * 반복문의 종류 : while 문  do~while 문  for문  for-each 문
 */
public class Main06 {
	public static void main(String[] args) {
		//while 문 : if문의 기능 + 반복
		//while의 용도 : 파일 다운로드가 끝날때까지 반복, 게임이끝날때까지 반복
		//사용자의 입력이 올바를때까지 반복, 등
		int n = 5;
		while( n > 0) // n이 0보다 큰 경우 반복문 실행. n값을 1씩 감소 
		{
			n=n-1;
			System.out.println("n : " + n);
		}
		//do-while 문 : if문 + 반복 + 1회무조건 반복
		//while(조건식) 문장이 반복문 끝에 작성이 되어있어서 무조건 1회는 반복
		//용도 : 사용자 입력이 정상적인 값이여야될때 사용
		Scanner sc = new Scanner(System.in);
		int input;
		//사용자 입력이 1~100 사이의 값이여하는 경우
		do
		{
			System.out.print("정수 값 입력 (1~100) : ");
			input = sc.nextInt();//사용자의 정수값입력을 input변수에 저장
		}while( input < 1 || input > 100 ); //do-while문에는 while끝에 ';'을 붙여 종료를 나타내야함
		System.out.println("사용자가 입력한 정상적인 값 : "+input);
		
		//for 문 : 초기식,조건식,증감식을 한줄로 표현한 반복문
		//for(초기식; 조건식; 증감식) {}
		//초기식 : for문을 처음 도달했을때 실행될 코드
		//조건식 : for문을 반복시킬지의 여부를 결정하는 비교&논리연산자조합
		//증감식 : for문을 반복시킨뒤 값을 변경할때 실행될 코드
		//초기식,조건식,증감식 모두 옵션
		//for문으로 while문을 쉽게 구현가능(초기식,증감식 옵션 제외)
		//조건식을 제외하면 무한반복 만들 수 있음
		//for 문을 사용하는 용도 : 특정규칙,횟수만큼 반복. while문의 사용용도.
		
		//for문의 모든 옵션을 사용해 특정횟수반복
		//int i;
		for(int i=0/* i = 0 */  ; i < 10 ; i++ /*i=i+1*/ )
		{
			System.out.println("for문의 i변수 : " + i);
		}
		//while문과 동일한 기능을 하는 for문
		n=5;
		for( ; n > 0 ;)//초기식과 증감식 제외
		{
			n=n-1;
			System.out.println("for문으로 while문같이 사용하기 : " + n);
		}
		//for문으로 정상적인 입력이 들어올때까지 반복
		for(  System.out.print("정수 값 입력 (1~100) : ");
				(input = sc.nextInt()) < 1 || input > 100;
				System.out.print("정수 값 입력 (1~100) : "));
		/*증감식을 제외
		 * for(  System.out.print("정수 값 입력 (1~100) : ");
				(input = sc.nextInt()) < 1 || input > 100;)
			{
				System.out.print("정수 값 입력 (1~100) : ")
			}
			초기식, 증감식을 제외
			System.out.print("정수 값 입력 (1~100) : ")
			for( ;(input = sc.nextInt()) < 1 || input > 100;)
			{
				System.out.print("정수 값 입력 (1~100) : ")
			}
			
			초기식, 증감식, 조건식 제외
			for( ; ; )
			{
				System.out.print("정수 값 입력 (1~100) : ")
				input = sc.nextInt();
				if( 1 <= input && input <= 100 )
				{
					break;
				}
			}
		 */
		
	}
}












