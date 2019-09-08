package �߻�Ŭ����;
/*
 * �߻�Ŭ���� ����
 * �߻�Ŭ���� : �ڽ�Ŭ������ ���������� ����ϴ� �������,�޼ҵ带 ������ Ŭ����.
 * �߻����� �������� �ڽ�Ŭ������ �ʿ��� ����� ����. �߻�Ŭ������ ��ü ������ ����������
 * ���� ����. ��, ��Ӱ� ���� �θ�Ŭ������ �ڷ������� �ڽ�Ŭ������ ��ü�� �����Ҽ����� 
 */
//Phone �߻�Ŭ���� ����
abstract class Phone{
	public String owner;
	//������
	public Phone(String _owner)
	{
		this.owner = _owner;
	}
	//�޼ҵ�
	public void turnOn()
	{
		System.out.println("�� ������ �մϴ�.");
	}
	public void turnOff()
	{
		System.out.println("�� ������ ���ϴ�.");
	}
}
//Phone Ŭ������ ��ӹ޴� SmartPhoneŬ���� ����
class SmartPhone extends Phone
{
	public SmartPhone(String owner)
	{
		super(owner);
	}
	public void internetSearch()
	{
		System.out.println("���ͳ� �˻��� �մϴ�.");
	}
}

/*
 * �߻�޼ҵ� : �߻�Ŭ���� ���ο� �ۼ��� �� �ִ� ���·� ���� �ڵ�κ��� �������ִ� �޼ҵ�.
 * �߻�Ŭ������ ��ӹ��� �ڽ�Ŭ������ �߻�޼ҵ带 �ݵ�� �������̵��ؾߵ�.
 */
//Animal
abstract class Animal{
	public String kind;
	public void breathe()
	{
		System.out.println("�� ����");
	}
	public abstract void sound(); //(�ɼ�)
}
//Dog
class Dog extends Animal
{
	public Dog()
	{
		this.kind = "������";
	}
	@Override
	public void sound() {
		System.out.println("�۸�");
	}
}
//Cat
class Cat extends Animal{
	public Cat()
	{
		this.kind = "������";
	}
	@Override
	public void sound() {
		System.out.println("�߿�");
	}
}
public class Main19 {
	public static void main(String[] args) {
		//new Phone(); //Error �߻�Ŭ������ �ν��Ͻ�(��ü)�� ������ ������.
		//SmartPhone phone = new SmartPhone("ȫ�浿");
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.sound();
		cat.sound();
		Animal animal;
		animal = dog; //�ڽ�Ŭ������ ��ü�� �θ�Ŭ������ ��ü�� ����ȯ
		animal.sound();//�ڽ�Ŭ������ ������ sound�޼ҵ� ȣ��(DogŬ����)
		animalSound(dog);//�θ�Ŭ������ AnimalŬ������ ����ȯ
		animalSound(cat);
		animalSound(new Dog());
	}
	//Animal �ڷ����� �Ű������� ����ϴ� ���� �޼ҵ�
	public static void animalSound(Animal animal)
	{
		animal.sound();
	}
}




