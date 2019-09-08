package 배열;
import java.util.Scanner;

public class Main12 {
	
	//정올 기초다지기 558번문제
	public static void main(String[] args) {
		//100개의 배열을 저장할 수 있는배열을 선언하라
		//정수를 차례대로 입력받다가 0이 입력되면 0을 제외
		//그 때까지 입력된 정수를 가장 나중에 입력된 정수부터 차례로 출력하는 프로그램
		
		
		int a[] = new int[100], i;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력해주세요. (최대 100개를 입력할 수 있고 0을 입력하면 종료됩니다.) : ");
		for(i=0; i<a.length; i++) {
			a[i] = sc.nextInt();
			//입력값이 0이되면 반복문을 종료
			if(a[i] == 0) {
				break; //가장안쪽의 반복문의 종료블록으로 이동
			}
		}
		for(i=i-1; i>=0; i--) { //여기서 중요한 것은 i변수를 0으로 초기화 하지 않는것임
			System.out.print(a[i] + "\t");
		}
		
		
		
	}

}
