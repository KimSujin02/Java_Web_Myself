package 추상클래스;

/*
 * 인터페이스 예제
 * 인터페이스 : 상수값과 추상메소드로 구현된 틀.
 * 인터페이스를 통해 개발 코드가 객체종류에 무관하게 특정 메소드를 호출하는 역할
 * 상속이나 추상클래스와 같이 다형성을 구현할 수 있음.
 */
interface RemoteControl{
	//상수
	int max_volume = 10; //컴파일러가 자동으로 public static final을 붙여줌
	int min_volume = 0;
	//추상 메소드
	void turnOn();//컴파일러가 자동으로 public abstract를 붙여줌
	void turnOff();
	void setVolume(int volume);
	void mute();
}
interface Battery{
	void changeBattery(int battery);
}

//완성된 인터페이스를 구현한 티비리모콘 클래스 정의
class TVRemote implements RemoteControl, Battery{
	@Override
	public void turnOn() {
		System.out.println("티비를 킨다.");
	}
	@Override
	public void turnOff() {
		System.out.println("티비를 끈다.");
	}
	@Override
	public void setVolume(int volume) {
		if( RemoteControl.min_volume<=volume 
				&& volume<=RemoteControl.max_volume) {
			System.out.println("볼륨 설정 : "+volume);
		}
		else {
			System.out.println("잘못된 볼륨 값 입니다.");
		}
	}
	@Override
	public void changeBattery(int battery) {
		System.out.println("배터리 교체 : "+ battery);
	}
	@Override
	public void mute() {
		System.out.println("음소거");
		
	}
}
public class Main20 {

	public static void main(String[] args) {
		//new RemoteControl(); 인터페이스로 객체를 생성할 수 없음.
		TVRemote remote = new TVRemote();
		remote.turnOn();
		//해당 객체가 특정 인터페이스를 구현했는지 확인하는 방법으로 instanceof 연산자를 사용
		//객체를 담은 변수 instanceof 클래스명이나 인터페이스명
		if(remote instanceof RemoteControl)
		{
			//인터페이스를 구현한 클래스의 객체는 인터페이스 자료형으로 자동형변환이 일어남
			RemoteControl rc = remote;
			rc.turnOff();
		}
		
		//인터페이스를 구현한 클래스 없이 인터페이스로 직접 객체생성
		new RemoteControl() {
			//임의로 멤버변수나 메소드를 추가 정의할 수 있으나, 객체.메소드,
			//객체.멤버변수로는 접근할 수 없음(해당 익명객체에만 존재하는 멤버변수,메소드이기때문)
			String RemoteControlName;
			public void Intro()
			{
				
			}
			@Override
			public void turnOn() {
				
			}
			@Override
			public void turnOff() {
				
			}
			@Override
			public void setVolume(int volume) {
				
			}
			@Override
			public void mute() {
				
			}
		};
		
		
	}

}




