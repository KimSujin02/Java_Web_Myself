package �߻�Ŭ����;

/*
 * �������̽� ����
 * �������̽� : ������� �߻�޼ҵ�� ������ Ʋ.
 * �������̽��� ���� ���� �ڵ尡 ��ü������ �����ϰ� Ư�� �޼ҵ带 ȣ���ϴ� ����
 * ����̳� �߻�Ŭ������ ���� �������� ������ �� ����.
 */
interface RemoteControl{
	//���
	int max_volume = 10; //�����Ϸ��� �ڵ����� public static final�� �ٿ���
	int min_volume = 0;
	//�߻� �޼ҵ�
	void turnOn();//�����Ϸ��� �ڵ����� public abstract�� �ٿ���
	void turnOff();
	void setVolume(int volume);
	void mute();
}
interface Battery{
	void changeBattery(int battery);
}

//�ϼ��� �������̽��� ������ Ƽ�񸮸��� Ŭ���� ����
class TVRemote implements RemoteControl, Battery{
	@Override
	public void turnOn() {
		System.out.println("Ƽ�� Ų��.");
	}
	@Override
	public void turnOff() {
		System.out.println("Ƽ�� ����.");
	}
	@Override
	public void setVolume(int volume) {
		if( RemoteControl.min_volume<=volume 
				&& volume<=RemoteControl.max_volume) {
			System.out.println("���� ���� : "+volume);
		}
		else {
			System.out.println("�߸��� ���� �� �Դϴ�.");
		}
	}
	@Override
	public void changeBattery(int battery) {
		System.out.println("���͸� ��ü : "+ battery);
	}
	@Override
	public void mute() {
		System.out.println("���Ұ�");
		
	}
}
public class Main20 {

	public static void main(String[] args) {
		//new RemoteControl(); �������̽��� ��ü�� ������ �� ����.
		TVRemote remote = new TVRemote();
		remote.turnOn();
		//�ش� ��ü�� Ư�� �������̽��� �����ߴ��� Ȯ���ϴ� ������� instanceof �����ڸ� ���
		//��ü�� ���� ���� instanceof Ŭ�������̳� �������̽���
		if(remote instanceof RemoteControl)
		{
			//�������̽��� ������ Ŭ������ ��ü�� �������̽� �ڷ������� �ڵ�����ȯ�� �Ͼ
			RemoteControl rc = remote;
			rc.turnOff();
		}
		
		//�������̽��� ������ Ŭ���� ���� �������̽��� ���� ��ü����
		new RemoteControl() {
			//���Ƿ� ��������� �޼ҵ带 �߰� ������ �� ������, ��ü.�޼ҵ�,
			//��ü.��������δ� ������ �� ����(�ش� �͸�ü���� �����ϴ� �������,�޼ҵ��̱⶧��)
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




