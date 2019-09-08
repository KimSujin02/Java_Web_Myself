package 추상클래스;
/*
 * 추상클래스 예제
 * 추상클래스 : 자식클래스가 공통적으로 사용하는 멤버변수,메소드를 정의한 클래스.
 * 추상적인 개념으로 자식클래스에 필요한 기능을 정의. 추상클래스는 객체 생성을 직접적으로
 * 하지 못함. 단, 상속과 같이 부모클래스의 자료형으로 자식클래스의 객체를 보관할수있음 
 */
//Phone 추상클래스 정의
abstract class Phone{
	public String owner;
	//생성자
	public Phone(String _owner)
	{
		this.owner = _owner;
	}
	//메소드
	public void turnOn()
	{
		System.out.println("폰 전원을 켭니다.");
	}
	public void turnOff()
	{
		System.out.println("폰 전원을 끕니다.");
	}
}
//Phone 클래스를 상속받는 SmartPhone클래스 정의
class SmartPhone extends Phone
{
	public SmartPhone(String owner)
	{
		super(owner);
	}
	public void internetSearch()
	{
		System.out.println("인터넷 검색을 합니다.");
	}
}

/*
 * 추상메소드 : 추상클래스 내부에 작성할 수 있는 형태로 실제 코드부분이 생략되있는 메소드.
 * 추상클래스를 상속받은 자식클래스는 추상메소드를 반드시 오버라이딩해야됨.
 */
//Animal
abstract class Animal{
	public String kind;
	public void breathe()
	{
		System.out.println("숨 쉬기");
	}
	public abstract void sound(); //(옵션)
}
//Dog
class Dog extends Animal
{
	public Dog()
	{
		this.kind = "포유류";
	}
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
//Cat
class Cat extends Animal{
	public Cat()
	{
		this.kind = "포유류";
	}
	@Override
	public void sound() {
		System.out.println("야옹");
	}
}
public class Main19 {
	public static void main(String[] args) {
		//new Phone(); //Error 추상클래스의 인스턴스(객체)를 생성할 수없음.
		//SmartPhone phone = new SmartPhone("홍길동");
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.sound();
		cat.sound();
		Animal animal;
		animal = dog; //자식클래스의 객체를 부모클래스의 객체로 형변환
		animal.sound();//자식클래스에 구현된 sound메소드 호출(Dog클래스)
		animalSound(dog);//부모클래스인 Animal클래스로 형변환
		animalSound(cat);
		animalSound(new Dog());
	}
	//Animal 자료형을 매개변수로 사용하는 정적 메소드
	public static void animalSound(Animal animal)
	{
		animal.sound();
	}
}




