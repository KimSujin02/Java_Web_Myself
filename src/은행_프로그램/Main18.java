package ����_���α׷�;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Ŭ������ �޼ҵ����� ���
 * �޼ҵ� : Ŭ������ �ൿ�� ���. �޼ҵ� ���ο� ���, ��������, ��ü������
 * ���� ���� ����� ������ ����
 * �޼ҵ�� �Է°� ����� �ɼ����� ������ �� ����.
 * �޼ҵ� ���� : �Է°� ����� ���°��, �Է��� ������ ����̾��°��, ����������� �Է�X
 * �Է��� �������� ���, ��� ���°� ��ü�� �Ѱ��ִ°��
 */
public class Main18 {

	public static void main(String[] args) {
		Bank a = new Bank("ȫ�浿����");//new Ŭ������() -> �ش� Ŭ���� ��ü ����
		//a.name = "ȫ�浿����";
		a.Welcome(); //��ȯ���� �����Ƿ� �޼ҵ� ȣ������ ������ �����Ҽ�����
		//a.name name ��������� private�� �����߱� ������ 
		//��ü�� ������ �������� ������ ���� ����
		
		
		//��ü������������ ������ �޼ҵ带 �������� ���ϵ��� ���ƾ��ϵǴ� ���
		//���������ڸ� ���� ������ �޼ҵ��� ������ ������ �� ����
		//a.account[0].balance += 2000;
		
		Scanner scan = new Scanner(System.in);
		int num;
		//��ũ �ý����� ���α׷����� �Է������� ����ϴ� �ݺ���
		while(true)
		{
			System.out.println("1. ���»��� 2. �Ա� 3. ��� 4. �۱� 5.���α׷����� 6. ������ȸ");
			System.out.print("�޴� ���� : ");
			num = scan.nextInt();
			if(num == 1)
			{
				//������ ������ �����ָ� �Է¹ޱ�
				System.out.print("������ ������ ������ �Է� : ");
				String new_name = scan.next();
				//���»��� �޼ҵ� ȣ��
				a.createAccount(new_name);
			}
			else if(num == 2)
			{
				//����ڷκ��� �Ա��� ���� ������ �̸��� �Ա� �ݾ��� �Է�
				System.out.print("�Ա��� ���� ������ �̸� �Է� : ");
				String account_name = scan.next();
				System.out.print("�Ա��� �ݾ� �Է� : ");
				int deposit_money = scan.nextInt();
				a.deposit(account_name, deposit_money);
			}
			else if(num == 3)
			{
				//����ڷκ��� ������ �̸��� ����� �ݾ��� �Է�
				System.out.print("����� ���� ������ �̸� �Է� : ");
				String account_name = scan.next();
				System.out.print("����� �ݾ� �Է� : ");
				int withdraw_money = scan.nextInt();
				//��ݸ޼ҵ� ȣ��
				a.withdraw(account_name, withdraw_money);
			}
			else if(num == 4)
			{
				//���� ���� ������ ������ �̸�, ���� ���� ������ ������ �̸�, �۱��� �ݾ��� �Է�
				String Recv_name, Send_name;
				int remit_money;
				System.out.print("���� ���� ������ ������ �Է� : ");
				Send_name = scan.next();
				System.out.print("���� ���� ������ ������ �Է� : ");
				Recv_name = scan.next();
				System.out.print("�۱��� �ݾ� �Է� : ");
				remit_money = scan.nextInt();
				a.remit(Send_name, Recv_name, remit_money);
			}
			else if(num == 5)
			{
				System.out.println("���α׷� ����");
				break;
			}
			else if(num == 6)
			{
				//���� ��ȸ ����� ������ �̸� �Է�
				System.out.print("������ ��ȸ�� ������ ������ : ");
				String name = scan.next();
				a.showRecord(name);
			}
		}
	}
}
//���ο� Ŭ���� ����
class Account //���������� �����ϴ� Ŭ������ ����
{
	//������ �̸�, �ܾ�, ����ݳ���, ���¹�ȣ ������� ����
	//bank��ü��  Account ��ü�� ������ ���к��ϰ� �������� ���ϵ��� �����鼭
	//�ش� ������ ����ִ� ���� ��ȸ�� �� �ֵ��� �����Ϸ��� ���������
	//private Ű����� ������ �����ϰ�, ����������� ��ȯ�ϴ� getter�޼ҵ带 �����ؾ���
	private String name, address, record="";
	private int balance;
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getRecord() {
		return record;
	}

	public int getBalance() {
		return balance;
	}

	//Ŭ���� ����, Ŭ���� �޼ҵ带 ���� ���¹�ȣ �ڵ� ���� ��� ����
	/*Ŭ���� ���� : ��ü�� �����Ҷ����� ��������� �����Ҽ��ִ� ������ ����� �Ϳ� ����
	 * Ŭ������ ��������� ����� ��簴ü�� ������ ��������� �����ϵ��� ������ ����
	 * Ŭ���� �޼ҵ� : ��ü ���� �޼ҵ尡 �����Ǵ� ���� �ƴ� Ŭ���� ���ο� �����
	 * �޼ҵ带 ��簴ü�� �����ϰ� �����ϴ� �޼ҵ�
	 * Ŭ���� ����, Ŭ���� �޼ҵ�� ��ü�� ����������� �ʴ��� ������ �� ����
	 * ��, Ŭ���� �޼ҵ� �ȿ� �ڵ忡���� ��ü�� ����� ��������� ����� �� ����
	 * -> ��ü�� �������� �ʾƵ� ����� �� �ִ� �޼ҵ��̹Ƿ� ��ü ������ �Һи��ϱ⶧��
	 */
	static int account_num = 0;
	public static String makeAddress()
	{
		//Ŭ���� ������ ������ ���¹�ȣ ���ڿ��� ����
		//Ŭ���� ���� ���� ���ڿ��� ��ȯ
		String address = String.valueOf(account_num);
		//��ȯ�� ���ڿ��� ���̸� 8�ڸ��� ���� -�ݺ����̿�
		//���ڿ�����.length() : �ش纯���� �������ִ� ���ڿ� ���̸� ��ȯ�ϴ¸޼ҵ�
		for( ;address.length() < 8; )//while(address.length()<8)
		{
			address = "0" + address;
		}
		//Ŭ���� ������ +1 ����
		account_num ++;
		//�ϼ��� ���¹�ȣ ��ȯ
		return address;
	}
	
	//������ : ��ü�� ������ �� (new Ŭ������()) ���� ���� ȣ��Ǵ� �޼ҵ�
	//�����ڴ� �ݵ�� �ش� Ŭ������ ��ü�� ��ȯ�ؾ��ϹǷ� ��ȯŸ���� �ۼ���������
	//+ return�� ����� �� ����
	//�����ڴ� ��ü�� �����ɶ� ������� ���� �ʱ�ȭ�ϴ� �ڵ带 �ۼ��� �� ����
	//Ŭ���� ���ο� ������ �޼ҵ带 �������� ������ �����Ϸ��� �ڵ����� �Ű�����������
	//������ �޼ҵ带 ������.
	
	//Account ������ ����
	//�������� �̸��� Ŭ������� �����ϰ� �ۼ��ؾ���
	public Account(String name)
	{
		//���� ������ ��ü�� ������� name�� �Ű����� name ���� ����
		this.name = name;
		this.address = Account.makeAddress();
		//�����ڴ� ��ü�� ���� ��������� �޼ҵ尡 �Ҵ�� ���¿��� ȣ��Ǳ⶧����
		//Ŭ������ ���ǵ� �ٸ� �޼ҵ���� ȣ���� �� ����.
		recording(2000);
	}
	
	
	/*
	 * �޼��� �����ε� : ������ �̸��� �޼��带 �����ϸ鼭 �Ű������� �ڷ���, ��, ������ ��ȭ�� ���� �Է��� �ٸ� �޼��带 �����ϴ� ���.
	 * �޼��� �����ε��� ����ϴ� �� : ������ ����� �پ��� �Է����¸� �����ϸ鼭 ��� �� �� �ֵ��� �������ִ� �޼ҵ�
	 * (String Ŭ������ valueOf()�޼ҵ�� �Է��ڷ����� ���� ���ڿ��� ��ȯ�� )
	 * ������ �����ε� : �پ��� ��ü������ �����ϱ� ���� �������� �Ű������� ��ȭ��Ű�� ��
	 * 
	 */
	//Account ��ü ������ ������ �̸��� �ʱ��ڻ��� �Է¹޾� ������� �ʱ�ȭ�� ���
	public Account(String name, int balance) {
		this.name = name;
		this.address = Account.makeAddress();
		recording(balance);
	}
	
	
	//����ݳ����� �ۼ��ϴ� �޼ҵ� ����
	public void recording(int changedBalance)//�������� ���:�Ա��̳� �۱�, ���� : ���
	{
		//���ǹ� - ������� �������� �Ǵ�
		if(changedBalance >= 0) 
		{
			//����ΰ�� �Ա� �ݾ� �Ѿ� ������ ����
			balance += changedBalance;
			record += "�Ա�  " + changedBalance + "  �Ѿ� : " + balance;
		}
		else 
		{
			//�����ΰ�� ��� �ݾ� �Ѿ� ������ ����
			balance += changedBalance;
			record += "��� " + (changedBalance*-1) + "  �Ѿ� : " +balance;
		}
		record += "\n";
	}
}
class Bank
{
	/*
	 * ���������� : public, protected, private�� �������, Ŭ����, �޼ҵ带 ���� �� �� ���� �� �ִ� Ű����.
	 * ���� �����ڴ� ���� ��ġ(����, Ŭ����)�� ���� �żҵ峪 Ŭ����, ������� ���� ��ȸ, �������� ���ϵ��� ���� ���
	 * public : ��� ��ġ�� ���ؼ� ������ ���
	 * private : �ڽ��� Ŭ���� ���ο����� ������ ���
	 */
	private String name;
	//Account ��ü���� ������ ���� ����
	//Account ��ü 10���� ������ �� �ִ� �迭 ����
	
	//private Account[] accounts = new Account[10];
	
	//ArrayList : �����ؾߵǴ� �������� ������ �������� ���, ������ ������ ���� ��������� ũ�⸦ �ڵ����� �������ִ� ����� ���Ե� ������ ���� Ŭ����
	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	//�迭�� ���° �ε������� Account��ü�� �������ִ��� Ȯ���ϱ�����
	//int max_account = 0;
	//max_account ��� Account Ŭ������ Ŭ���� ������ account_numȰ��
	
	
	public Bank(String string) {
		name = string;
	}
	//�Է°� ����� ���� �޼ҵ� ����
	// : ��ü ���ο� ����� �ɹ������� �ݺ����� �ڵ� ������ �����ؾߵɶ� ����
	//��ȯ�ڷ����� void�� �ۼ��ϸ� returnŰ���带 �ۼ����� �ʾƵ� ������ �߻���������
	//return�� ����� �������� return�� �����ʿ� ���� �ۼ��� �� ����
	//�޼ҵ� ���� public ��ȯ�ڷ��� �޼ҵ��̸�(�Ű�����)
	public void Welcome()
	{
		System.out.println(name + "�� ���Ű��� ȯ���մϴ�!");
	}
	public void showRecord(String name) {
		int i;
		//�ݺ��� - 0~max_account-1 �ݺ�
		//for(i=0;i<max_account;i++)
		for(i=0; i < Account.account_num ; i++)
		{
			//���ǹ� - account�� �ݺ������ε����� name �ɹ�������
			//name �Ű�������������Ȯ��
			//if( accounts[i].getName().equals(name) ) 
			if( accounts.get(i).getName().equals(name) ) 
			{
				//�ݺ��� ���� ����
				break;
			}
		}
		//���ǹ� - �ݺ��� �������� max_account������?
		//if(i < max_account)
		if(i < Account.account_num)
		{
			//accounts�� �ݺ������ε����� record �ɹ������� �ֿܼ� ���
			System.out.println(accounts.get(i).getRecord());
		}
		//�ƴѰ�� - ���°� �������� ������ ���
		else 
		{
			System.out.println("���������ʴ� �����Դϴ�.");
		}
	}
	//�۱� �޼ҵ� ����
	//�۱� - �Է� : ���� ����� ������ ������ ��, ���� �Ա��� ������ ������ ��, �۱ݾ�
	//��� : true - ��������ó��, false - ����������ó��
	public boolean remit(String Send_account, 
			             String Recv_account,int remit_money)
	{
		//���ǹ� - �۱ݾ��� ������� Ȯ��
		if(remit_money > 0) {
			int i;
			//	�ݺ��� - �Ա��� ���¸� ã��
			//for(i=0;i<max_account; i++)
			for(i=0;i<Account.account_num;i++)
			{
				if(Recv_account.equals(accounts.get(i).getName()))
				{ break; } 
			}
			//���ǹ� - �Աݰ��°� �����ϴ��� Ȯ��
			//if(i < max_account)
			if(i < Account.account_num)
			{
				//��� �޼ҵ带 ȣ�� - ȣ���� ����� ������ ����
				boolean isSuccess=withdraw(Send_account, remit_money);
				//���ǹ� - ��� �޼ҵ� ȣ������ ���ΰ��
				if(isSuccess) {//if(isSuccess == true)
					//�Ա� �޼ҵ� ȣ��
					deposit(Recv_account, remit_money);
					//�������� ó���� true ��ȯ
					return true;
				}
			}
			//�ƴѰ�� - �Աݰ��°� �������������� ���
			else {
				System.out.println("�Ա� ���°� �������� ����.");
			}
		}
		//�ƴѰ�� - ������� �Է��ؾߵǴ� ���� ���
		else {
			System.out.println("�۱ݾ��� ���������.");
		}
		return false;
	}
	
	public boolean withdraw(String account_name, int withdraw_money) {
		//���ǹ� - ��ݱݾ��� ������� Ȯ��
		if( withdraw_money > 0) {
			int i;
			//�ݺ��� - ����ã��
			//for(i=0;i<max_account;i++)
			for(i=0;i<Account.account_num;i++)
			{
				if( accounts.get(i).getName().equals(account_name)  )
				{
					break;
				}
			}
			//���ǹ� - ���°� �����ϴ��� Ȯ��
			//if(i < max_account)
			if(i < Account.account_num)
			{
				//���ǹ� - �ش� ���¿� ���� ������� �� �ܾ��� 0�̻����� Ȯ��
				if(accounts.get(i).getBalance() >= withdraw_money) {
					//recording �޼ҵ� ȣ��� ��ݱ�� ����
					withdraw_money *=-1;//������ ����
					accounts.get(i).recording(withdraw_money);
					return true;
				}
				//�ƴѰ�� - �ܾ� ������ ���
				else {
					System.out.println("�ܾ��� �����մϴ�.");
				}
			}
			//�ƴѰ�� - ���°� �������������� ���
			else {
				System.out.println("���°� �������� �ʽ��ϴ�.");
			}
		}
		//�ƴѰ�쿡 ���� ���� ���
		else {
			System.out.println("��ݾ��� ��������մϴ�.");
		}
		return false; //���������� ��� ó���� ���� false ��ȯ
	}
	//����� �ִ� �޼ҵ� ����
	// : �ɹ������� �ܺο��� ���ٵǴ� ���� ������ ���� ��, �������� ��ü�� ������
	//��ġ���� �ް����� �� ���.
	//name ������ ����ִ� ���� ��ȯ�ϴ� �޼ҵ�
	//�ܺο� ������ ���� �ɹ������� ���� �����ϴ� �޼ҵ�� �޼ҵ������ get�������� ���
	//�ϴ°��� ��������. 
	//�ܺ� ������ ���� ��������� ���� �����ϴ� �޼ҵ�� set�������� �����
	//��������� ���� get�� set�� �ڵ����� : Ŭ���� ���Ƕ��� ������Ŭ��->source->
	//generate getter/setter ���� �� ������ ������� ����
	public String getName() {
		return name;
	}
	
	//�Է°��� �ִ� �޼ҵ� ����
	//�ܺ����� ���ѵ� �ɹ����� ����, ����� �Է��� �������� ���ο��길 ����Ǵ� ���
	//������� �����̸��� �������� ���ο� ���¸� �����ϴ� �޼ҵ�
	public void createAccount(String name)
	{
		//���ǹ� - max_account�� ���� �迭ũ�⺸�� ������� ���»���
		//if( max_account < accounts.length)
		//if(Account.account_num < accounts.length)
		//{
			//Account ��ü ���� - ������ ��ü�� max_account ��° �ε����� ����
			//accounts[max_account] = new Account();
			//���� ������ ��ü�� name �ɹ������� ���� �Ű����� name���� ����
			//accounts[max_account].name = name;
			//�����ڸ� �������� ���� ������ ��ü�� name �ɹ������� ���� �ʱ�ȭ�ѻ��·�
			//��ȯ��.
			
//			accounts[Account.account_num] = new Account(name);
			//accounts ��ü�� ���ο� Account ��ü�� ���� -> size�� �þ
			accounts.add(new Account(name));
			//max_account ���� 1����
			//max_account ++;
			System.out.println(
					this.name + "���� " + name + "�� ���ο� ���� ����");
		//}
		//else 
		//{
			//�ƴѰ�� - ���»��� ����� ����
			//System.out.println("���°����� �����ʽ��ϴ�. �����ڿ��� �����ϼ���.");
		//}
		
	}
	//�Է°� ��� ��� �ִ� �޼ҵ� ����
	//�Ա� ����� ������ �Ա��� �ݾ��� �Է¹޾� ���¿� �ܰ� ������Ű�� �޼ҵ�
	public boolean deposit(String name, int money)
	{
		//���ǹ� - �Ա��� �ݾ��� ������� Ȯ��
		if(money > 0)
		{
			int i;
			//�ݺ��� - �Ű����� name�� ������ ���� ���� Account��ü�� ã��
			//for(i=0;i < max_account; i++) //i: 0~max_account-1 �ݺ�
			for(i=0;i<Account.account_num;i++)
			{
				//i��° �ε����� Account��ü�� name������ �Ű�����name����?
				if( name.equals(accounts.get(i).getName()) )
				{
					break;
				}
			}
			//���ǹ� - �ش� ���°� �������� �ʴ°��
			//if( i == max_account)
			if( i==Account.account_num)
			{
				//���°� �������������� ���
				System.out.println("�������� �ʴ� �����Դϴ�.");
				return false; //���������� ó���� ���� �� ��ȯ
			}
			//ã�� Account��ü�� recording �޼ҵ� ȣ��
			accounts.get(i).recording(money);
			System.out.println(name+"�� "+ money + "���� �Աݵ�.");
			return true; //�������� ó���� ���� �� ��ȯ
		}
		//�����ų� 0�ΰ��
		else 
		{
			//�Է��� �߸������� ���
			System.out.println("�Ա� �ݾ��� ������� �մϴ�.");
		}
		
		return false;
	}
}









