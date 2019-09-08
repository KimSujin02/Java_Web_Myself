package 기초_조건문_반복문;

public class Main02 {

	public static void main(String[] args) {

		/*
		 * Switch ~ case 문 : 특정 변수/연산결과가 어떤 값을 가지고 있는지에 따라 실행할 코드를 분류하는 문법
		 * switch 문에 들어갈수 있는 변수는 char, int 같은 정수형 값만 사용할 수 있음
		 */
		
		int a =18;
		//switch case 문 
		//을 if문으로 나중에 또 코딩을 한다네
		
		switch (a/2) {
		//정수값 연산결과를 바탕으로 선택됨
			case 1 : // a/2의 결과가 1인 경우에 대한 처리
				System.out.println("a를 2로 나눈 몫은 1입니다.");
				break;
				
			case 2 : //a/2의 결과가 2인 경우에 대한 처리
				System.out.println("a를 2로 나눈 몫은 2입니다.");
				break;
			
			case 5 : //이렇게 순서가 뒤죽박죽이라도 ㅇㅋ이다.
				System.out.println("a를 2로 나눈 몫은 5입니다.");
				break;
				
			case 6:
			case 7:
			case 8:
			case 9:
				System.out.println("---Switch문---\ncase 6, 7, 8, 9중에 하나 일때 나오는 출력문입니다. \na/2의 결과값은 6, 7, 8, 9중에 하나 입니다.\n");
				break;
				
			case 100: 
				break;
				
			default :
				System.out.println("위의 모든 case가 아닌경우에 실행할 코드입니다.(default)");
		} //Switch문 닫기
		
		if (a/2 ==1) {
			System.out.println("case 1과 동일한 조건식(if)");
		}
		else if(6 <= a/2 && a/2 <= 9) {
			System.out.println("---if문---\na/2의 결과값은 6보다 크거나 같고, 9보다 작거나 같은 수 입니다. \n6<=a/2<=9 \ncase 6, 7, 8, 9와 같은 조건식임 \n");
		} //else if문 닫기
		
		
		
		
		
	}//main 닫기

}//class닫기임
