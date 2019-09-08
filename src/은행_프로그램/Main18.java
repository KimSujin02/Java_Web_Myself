package 은행_프로그램;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 클래스에 메소드정의 방법
 * 메소드 : 클래스의 행동을 담당. 메소드 내부에 제어문, 변수생성, 객체생성을
 * 통한 실제 기능이 구현된 단위
 * 메소드는 입력과 출력을 옵션으로 선택할 수 있음.
 * 메소드 형태 : 입력과 출력이 없는경우, 입력은 있으나 출력이없는경우, 출력이있으나 입력X
 * 입력이 여러개인 경우, 출력 형태가 객체를 넘겨주는경우
 */
public class Main18 {

	public static void main(String[] args) {
		Bank a = new Bank("홍길동은행");//new 클래스명() -> 해당 클래스 객체 생성
		//a.name = "홍길동은행";
		a.Welcome(); //반환값이 없으므로 메소드 호출결과를 변수에 저장할수없음
		//a.name name 멤버변수를 private로 설정했기 때문에 
		//객체를 생성한 지점에서 접근을 하지 못함
		
		
		//객체생성지점에서 변수나 메소드를 접근하지 못하도록 막아야하되는 경우
		//접근제어자를 통해 변수나 메소드의 접근을 설정할 수 있음
		//a.account[0].balance += 2000;
		
		Scanner scan = new Scanner(System.in);
		int num;
		//뱅크 시스템을 프로그램종료 입력전까지 사용하는 반복문
		while(true)
		{
			System.out.println("1. 계좌생성 2. 입금 3. 출금 4. 송금 5.프로그램종료 6. 내역조회");
			System.out.print("메뉴 선택 : ");
			num = scan.nextInt();
			if(num == 1)
			{
				//생성할 계좌의 소유주를 입력받기
				System.out.print("생성된 계좌의 소유주 입력 : ");
				String new_name = scan.next();
				//계좌생성 메소드 호출
				a.createAccount(new_name);
			}
			else if(num == 2)
			{
				//사용자로부터 입금할 계좌 소유주 이름과 입금 금액을 입력
				System.out.print("입금할 계좌 소유주 이름 입력 : ");
				String account_name = scan.next();
				System.out.print("입금할 금액 입력 : ");
				int deposit_money = scan.nextInt();
				a.deposit(account_name, deposit_money);
			}
			else if(num == 3)
			{
				//사용자로부터 소유주 이름과 출금할 금액을 입력
				System.out.print("출금할 계좌 소유주 이름 입력 : ");
				String account_name = scan.next();
				System.out.print("출금할 금액 입력 : ");
				int withdraw_money = scan.nextInt();
				//출금메소드 호출
				a.withdraw(account_name, withdraw_money);
			}
			else if(num == 4)
			{
				//돈을 보낼 계좌의 소유주 이름, 돈을 받을 계좌의 소유주 이름, 송금할 금액을 입력
				String Recv_name, Send_name;
				int remit_money;
				System.out.print("돈을 보낼 계좌의 소유주 입력 : ");
				Send_name = scan.next();
				System.out.print("돈을 받을 계좌의 소유주 입력 : ");
				Recv_name = scan.next();
				System.out.print("송금할 금액 입력 : ");
				remit_money = scan.nextInt();
				a.remit(Send_name, Recv_name, remit_money);
			}
			else if(num == 5)
			{
				System.out.println("프로그램 종료");
				break;
			}
			else if(num == 6)
			{
				//내역 조회 대상의 소유주 이름 입력
				System.out.print("내역을 조회할 계좌의 소유주 : ");
				String name = scan.next();
				a.showRecord(name);
			}
		}
	}
}
//새로운 클래스 정의
class Account //계좌정보를 관리하는 클래스를 정의
{
	//소유주 이름, 잔액, 입출금내역, 계좌번호 멤버변수 선언
	//bank객체가  Account 객체의 정보를 무분별하게 수정하지 못하도록 막으면서
	//해당 변수에 들어있는 값만 조회할 수 있도록 설정하려면 멤버변수는
	//private 키워드로 접근을 제한하고, 멤버변수값을 반환하는 getter메소드를 제공해야함
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

	//클래스 변수, 클래스 메소드를 통한 계좌번호 자동 생성 기능 구현
	/*클래스 변수 : 객체를 생성할때마다 멤버변수를 저장할수있는 공간이 생기는 것에 반해
	 * 클래스에 저장공간을 만들어 모든객체가 동일한 저장공간을 접근하도록 설정한 변수
	 * 클래스 메소드 : 객체 마다 메소드가 생성되는 것이 아닌 클래스 내부에 저장된
	 * 메소드를 모든객체가 동일하게 접근하는 메소드
	 * 클래스 변수, 클래스 메소드는 객체가 만들어져있지 않더라도 접근할 수 있음
	 * 단, 클래스 메소드 안에 코드에서는 객체에 저장된 멤버변수를 사용할 수 없음
	 * -> 객체를 생성하지 않아도 사용할 수 있는 메소드이므로 객체 정보가 불분명하기때문
	 */
	static int account_num = 0;
	public static String makeAddress()
	{
		//클래스 변수의 값으로 계좌번호 문자열을 생성
		//클래스 변수 값을 문자열로 변환
		String address = String.valueOf(account_num);
		//변환된 문자열의 길이를 8자리로 맞춤 -반복문이용
		//문자열변수.length() : 해당변수가 가지고있는 문자열 길이를 반환하는메소드
		for( ;address.length() < 8; )//while(address.length()<8)
		{
			address = "0" + address;
		}
		//클래스 변수에 +1 누적
		account_num ++;
		//완성된 계좌번호 반환
		return address;
	}
	
	//생성자 : 객체를 생성할 때 (new 클래스명()) 가장 먼저 호출되는 메소드
	//생성자는 반드시 해당 클래스의 객체를 반환해야하므로 반환타입을 작성하지않음
	//+ return를 사용할 수 없음
	//생성자는 객체가 생성될때 멤버변수 값을 초기화하는 코드를 작성할 수 있음
	//클래스 내부에 생성자 메소드를 정의하지 않으면 컴파일러가 자동으로 매개변수가없는
	//생성자 메소드를 생성함.
	
	//Account 생성자 정의
	//생성자의 이름은 클래스명과 동일하게 작성해야함
	public Account(String name)
	{
		//새로 생성된 객체의 멤버변수 name에 매개변수 name 값이 대입
		this.name = name;
		this.address = Account.makeAddress();
		//생성자는 객체에 대한 멤버변수와 메소드가 할당된 상태에서 호출되기때문에
		//클래스에 정의된 다른 메소드들을 호출할 수 있음.
		recording(2000);
	}
	
	
	/*
	 * 메서드 오버로딩 : 동일한 이름의 메서드를 정의하면서 매개변수의 자료형, 수, 순서의 변화를 통해 입력이 다른 메서드를 정의하는 방법.
	 * 메서드 오버로딩을 사용하는 예 : 동일한 기능을 다양한 입력형태를 제공하면서 사용 할 수 있도록 제공해주는 메소드
	 * (String 클래스의 valueOf()메소드는 입력자료형에 따라 문자열을 반환함 )
	 * 생성자 오버로딩 : 다양한 객체생성을 제공하기 위해 생성자의 매개변수를 변화시키는 것
	 * 
	 */
	//Account 객체 생성시 소유주 이름과 초기자산을 입력받아 멤버변수 초기화에 사용
	public Account(String name, int balance) {
		this.name = name;
		this.address = Account.makeAddress();
		recording(balance);
	}
	
	
	//입출금내역을 작성하는 메소드 정의
	public void recording(int changedBalance)//변동사항 양수:입금이나 송금, 음수 : 출금
	{
		//조건문 - 양수인지 음수인지 판단
		if(changedBalance >= 0) 
		{
			//양수인경우 입금 금액 총액 순으로 저장
			balance += changedBalance;
			record += "입금  " + changedBalance + "  총액 : " + balance;
		}
		else 
		{
			//음수인경우 출금 금액 총액 순으로 저장
			balance += changedBalance;
			record += "출금 " + (changedBalance*-1) + "  총액 : " +balance;
		}
		record += "\n";
	}
}
class Bank
{
	/*
	 * 접근제어자 : public, protected, private를 멤버변수, 클래스, 메소드를 정의 할 때 붙일 수 있는 키워드.
	 * 접근 제어자는 접근 위치(파일, 클래스)에 따라 매소드나 클래스, 멤버변수 값을 조회, 수정하지 못하도록 막는 기능
	 * public : 모든 위치에 대해서 접근을 허용
	 * private : 자신의 클래스 내부에서만 접근을 허용
	 */
	private String name;
	//Account 객체들을 저장한 변수 생성
	//Account 객체 10개를 저장할 수 있는 배열 생성
	
	//private Account[] accounts = new Account[10];
	
	//ArrayList : 저장해야되는 데이터의 개수가 가변적인 경우, 데이터 개수에 맞춰 저장공간의 크기를 자동으로 변경해주는 기능이 포함된 데이터 저장 클래스
	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	//배열에 몇번째 인덱스까지 Account객체가 생성되있는지 확인하기위함
	//int max_account = 0;
	//max_account 대신 Account 클래스에 클래스 변수인 account_num활용
	
	
	public Bank(String string) {
		name = string;
	}
	//입력과 출력이 없는 메소드 정의
	// : 객체 내부에 저장된 맴버변수나 반복적인 코드 동작을 수행해야될때 정의
	//반환자료형을 void로 작성하면 return키워드를 작성하지 않아도 에러가 발생하지않음
	//return는 사용할 수있으나 return의 오른쪽에 값을 작성할 수 없음
	//메소드 정의 public 반환자료형 메소드이름(매개변수)
	public void Welcome()
	{
		System.out.println(name + "에 오신것을 환영합니다!");
	}
	public void showRecord(String name) {
		int i;
		//반복문 - 0~max_account-1 반복
		//for(i=0;i<max_account;i++)
		for(i=0; i < Account.account_num ; i++)
		{
			//조건문 - account의 반복변수인덱스에 name 맴버변수가
			//name 매개변수가같은지확인
			//if( accounts[i].getName().equals(name) ) 
			if( accounts.get(i).getName().equals(name) ) 
			{
				//반복문 강제 종료
				break;
			}
		}
		//조건문 - 반복문 변수값이 max_account작은가?
		//if(i < max_account)
		if(i < Account.account_num)
		{
			//accounts의 반복변수인덱스에 record 맴버변수를 콘솔에 출력
			System.out.println(accounts.get(i).getRecord());
		}
		//아닌경우 - 계좌가 존재하지 않음을 출력
		else 
		{
			System.out.println("존재하지않는 계좌입니다.");
		}
	}
	//송금 메소드 정의
	//송금 - 입력 : 돈을 출금할 계좌의 소유주 명, 돈을 입금할 계좌의 소유주 명, 송금액
	//출력 : true - 정상적인처리, false - 비정상적인처리
	public boolean remit(String Send_account, 
			             String Recv_account,int remit_money)
	{
		//조건문 - 송금액이 양수인지 확인
		if(remit_money > 0) {
			int i;
			//	반복문 - 입금할 계좌를 찾기
			//for(i=0;i<max_account; i++)
			for(i=0;i<Account.account_num;i++)
			{
				if(Recv_account.equals(accounts.get(i).getName()))
				{ break; } 
			}
			//조건문 - 입금계좌가 존재하는지 확인
			//if(i < max_account)
			if(i < Account.account_num)
			{
				//출금 메소드를 호출 - 호출의 결과를 변수에 저장
				boolean isSuccess=withdraw(Send_account, remit_money);
				//조건문 - 출금 메소드 호출결과가 참인경우
				if(isSuccess) {//if(isSuccess == true)
					//입금 메소드 호출
					deposit(Recv_account, remit_money);
					//정상적인 처리로 true 반환
					return true;
				}
			}
			//아닌경우 - 입금계좌가 존재하지않음을 출력
			else {
				System.out.println("입금 계좌가 존재하지 않음.");
			}
		}
		//아닌경우 - 양수값을 입력해야되는 것을 출력
		else {
			System.out.println("송금액은 양수여야함.");
		}
		return false;
	}
	
	public boolean withdraw(String account_name, int withdraw_money) {
		//조건문 - 출금금액이 양수인지 확인
		if( withdraw_money > 0) {
			int i;
			//반복문 - 계좌찾기
			//for(i=0;i<max_account;i++)
			for(i=0;i<Account.account_num;i++)
			{
				if( accounts.get(i).getName().equals(account_name)  )
				{
					break;
				}
			}
			//조건문 - 계좌가 존재하는지 확인
			//if(i < max_account)
			if(i < Account.account_num)
			{
				//조건문 - 해당 계좌에 돈을 출금했을 때 잔액이 0이상인지 확인
				if(accounts.get(i).getBalance() >= withdraw_money) {
					//recording 메소드 호출로 출금기능 수행
					withdraw_money *=-1;//음수로 변경
					accounts.get(i).recording(withdraw_money);
					return true;
				}
				//아닌경우 - 잔액 부족을 출력
				else {
					System.out.println("잔액이 부족합니다.");
				}
			}
			//아닌경우 - 계좌가 존재하지않음을 출력
			else {
				System.out.println("계좌가 존재하지 않습니다.");
			}
		}
		//아닌경우에 대한 에러 출력
		else {
			System.out.println("출금액은 양수여야합니다.");
		}
		return false; //비정상적인 모든 처리에 대해 false 반환
	}
	//출력이 있는 메소드 정의
	// : 맴버변수가 외부에서 접근되는 것이 허용되지 않을 때, 변수값을 객체를 생성한
	//위치에서 받고자할 때 사용.
	//name 변수에 들어있는 값을 반환하는 메소드
	//외부에 접근을 막은 맴버변수의 값을 전달하는 메소드는 메소드명으로 get변수명을 사용
	//하는것이 보편적임. 
	//외부 접근을 막은 멤버변수의 값을 설정하는 메소드는 set변수명을 사용함
	//멤버변수에 대한 get과 set을 자동생성 : 클래스 정의란에 오른쪽클릭->source->
	//generate getter/setter 선택 후 생성할 멤버변수 선택
	public String getName() {
		return name;
	}
	
	//입력값만 있는 메소드 정의
	//외부접근 제한된 맴버변수 설정, 사용자 입력을 바탕으로 내부연산만 수행되는 경우
	//사용자의 계좌이름을 바탕으로 새로운 계좌를 생성하는 메소드
	public void createAccount(String name)
	{
		//조건문 - max_account의 값이 배열크기보다 작은경우 계좌생성
		//if( max_account < accounts.length)
		//if(Account.account_num < accounts.length)
		//{
			//Account 객체 생성 - 생성된 객체를 max_account 번째 인덱스에 저장
			//accounts[max_account] = new Account();
			//새로 생성된 객체에 name 맴버변수의 값을 매개변수 name으로 대입
			//accounts[max_account].name = name;
			//생성자를 바탕으로 새로 생성된 객체의 name 맴버변수에 값을 초기화한상태로
			//반환됨.
			
//			accounts[Account.account_num] = new Account(name);
			//accounts 객체에 새로운 Account 객체를 저장 -> size가 늘어남
			accounts.add(new Account(name));
			//max_account 값을 1증가
			//max_account ++;
			System.out.println(
					this.name + "에서 " + name + "로 새로운 계좌 생성");
		//}
		//else 
		//{
			//아닌경우 - 계좌생성 기능을 막음
			//System.out.println("계좌개설이 되지않습니다. 관리자에게 문의하세요.");
		//}
		
	}
	//입력과 출력 모두 있는 메소드 정의
	//입금 대상의 정보와 입금할 금액을 입력받아 계좌에 잔고를 증가시키는 메소드
	public boolean deposit(String name, int money)
	{
		//조건문 - 입금할 금액이 양수인지 확인
		if(money > 0)
		{
			int i;
			//반복문 - 매개변수 name과 동일한 값을 가진 Account객체를 찾기
			//for(i=0;i < max_account; i++) //i: 0~max_account-1 반복
			for(i=0;i<Account.account_num;i++)
			{
				//i번째 인덱스의 Account객체에 name변수가 매개변수name동일?
				if( name.equals(accounts.get(i).getName()) )
				{
					break;
				}
			}
			//조건문 - 해당 계좌가 존재하지 않는경우
			//if( i == max_account)
			if( i==Account.account_num)
			{
				//계좌가 존재하지않음을 출력
				System.out.println("존재하지 않는 계좌입니다.");
				return false; //비정상적인 처리에 대한 값 반환
			}
			//찾은 Account객체에 recording 메소드 호출
			accounts.get(i).recording(money);
			System.out.println(name+"에 "+ money + "원이 입금됨.");
			return true; //정상적인 처리에 대한 값 반환
		}
		//음수거나 0인경우
		else 
		{
			//입력이 잘못됬음을 출력
			System.out.println("입금 금액은 양수여야 합니다.");
		}
		
		return false;
	}
}









