package 배열;
import java.util.Scanner;

public class Main14 {
	//정올 기초다지기 161번 문제임
	public static void main(String[] args) {
		//학생들의 점수를 입력을 받다가 0이 입력되면 
		//그 때까지 입력받은 점수를 10점 단위로 구분하여
		//점수대별 학생 수를 출력하는 프로그램을 작성하시오.
		//(1명도 없는 점수는 출력하지 않는다.)학생은 최대 100명이하이다.
		
		Scanner sc = new Scanner(System.in);
		int a;
		int n[] = new int[11];
		int i;
		
		System.out.print("점수를 입력하세요(0이 입력되면 종료됩니다.) : ");
		for(i=0; i<100; i++) {
			a = sc.nextInt();
				if(a == 0) {
					break;
				}
			n[a/10]++;
			
		}
		
		
		for(i=10; i>=0; i--) {
			if(n[i] != 0) {
				System.out.println((i*10) + "점대 : " + n[i] + "명");
			}
		}
		

	}

}
