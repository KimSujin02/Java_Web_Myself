package 기초_조건문_반복문;
import java.util.Scanner;

public class Main03 {

	public static void main(String[] args) {
		Scanner sc =new Scanner (System.in);
		System.out.print("몸무게를 입력해주세요 : ");
		double weight = sc.nextDouble();
		String result;
		
		if(weight <= 50.8) {
			System.out.println("Fly급 입니다.");
			result = "Flyweght";
		}
		else if(weight <= 61.23) { //else if 조건을 쓴 이유 : 위에 있는 조건을 만족하지 못하면 false로 처리 되어 복잡한 연산식을 쓸 필요가 없어진다. 
			System.out.println("Light급 입니다.");
			result = "Lightweight";
		}
		else if(weight <= 71.57) {
			System.out.println("Middle급 입니다.");
			result = "Middleweight";
		}
		else if(weight <= 88.45) {
			System.out.println("Cruiser급 입니다.");
			result = "Cruiserweight";
		}
		else {
			//위에 있는 조건식들로 인해 몸무게가 88.45보다 큰것을 확인했다.
			//if ( weight > 88.45 ) <<<<<요 조건식과 같다고 할수있다.
			result = "Heavyweight";
		}
		
		System.out.println(result);
	}

}
