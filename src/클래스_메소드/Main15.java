package 클래스_메소드;
/*
 * 클래스와 객체 기본 구조 설정 및 객체 생성예제
 */

public class Main15 {
	public static void main(String args[]) {
		//객체생성
		//만들어져있는 클래스(타인이 만들거나 본인이 만든 클래스)를 바탕으로
		//데이터를 저장하고 특정한 행동을 수행하는 변수들을 생성
		
		Human sujin = new Human(); //Human클래스 객체생성후 수진이라는 변수에 저장을 하겠다
		System.out.println(sujin);
		//new 클래스명(); -> 해당 클래스로 객체를 생성
		//생성된 객체를 담을 수 있는 변수는 클래스명과 동일한 자료형 생성
		//같은 클래스를 사용하더라도 각각 다른 방을 쓰고 있다. 독립적이다 이말임
		Human kyungsoo = new Human();
		System.out.println(kyungsoo);
		
		
		//***위의 주석을 증명하는 출력값. false가 출력되므로 증명이 가능하다***
		System.out.println(sujin == kyungsoo);
		//수진에 저장된 객체와 경수에 저장된 객체는 서로 다른 객체이기 때문에 ==(같다) 연산을 쓰면 당연히 false가 나온다 이말이야
		
		
		//객체 내부의 멤버변수를 접근, 수정
		//객테가 저장하고 있는 멤버변수값을 접근하려면 .(점)연산자로 전근해야함
		//객체변수.멤버변수이름(또는 멤버함수이름)
		sujin.age = 18;
		sujin.name = "김수진";
		sujin.phone = "01089029135";
		
		kyungsoo.name = "도경수";
		kyungsoo.age = 27;
		kyungsoo.phone = "01089025050";
		
		System.out.println("\n---메소드 출력---\n");
		
		sujin.intro();
		kyungsoo.intro();
	}
}
