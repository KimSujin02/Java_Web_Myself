package 배열;
import java.util.Scanner;

public class Main13 {
	//정올 기초다지기 560번 문제임
	public static void main(String[] args) {
		//100 이하의 자연수를 입력받아 첫 번째 항은 100으로 두 번째 항은 입력받은 수로 초기화하고
		//다음 항부터는 전전항에서 전항을 뺀 수로 채워나가는 수열을 작성하여 그 수가 음수가 나올 때까지 출력하는 프로그램을 작성하시오.
		
		
		
		//배열변수와 반복문변수를 선언
		//반복문은 연산결과가 음수가 나올때까지 반복한다.
			//현재인덱스 = 전전인덱스 - 전인덱스
			//현재인덱스에 음수값이 저장된 경우 반복문 종료
		//반복문 - 0~이전반복문의 변수값까지 반복
		
		Scanner sc = new Scanner(System.in);
		
		int a[]= new int[100], i, j;
		a[0]=100;
		System.out.print("입력해주세요 : ");
		a[1]=sc.nextInt();
		
		for(i=2; ; i++) { //종료조건을 넣지 않으면 무한하게 반복이 된다. 어차피 break;문 넣을거라서 ㄱㅊ음
			a[i] = a[i-2] - a[i-1];
			if(a[i] < 0) {
				break;
			}
		}
		for(j=0; j<=i; j++) {
			System.out.print(a[j] + "\t");
		}
		
		
	}

}
