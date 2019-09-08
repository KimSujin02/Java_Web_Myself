package �����Ͽ�;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//�����Ͽ�(Selenium)���� ��Ű����
//https://wikidocs.net/35954
//
//�����Ͽ� ���� ����Ʈ(�ٿ�ε�)
//https://www.seleniumhq.org/download/
//
//�����Ͽ� �ڹ�(�������� ���� ���̵�/�����Ͽ� ���� ����)
//https://gdtbgl93.tistory.com/154

public class Main16 {
/*
 * Selenium ���̺귯���� ũ�Һ����� ���� ����
 * Selenium : ���ڵ�ȭ ����� �������ִ� ���̺귯��
 * ���̺귯�� : � ����� �����ϱ� ���� ó���ؾ��ϴ� �۾����� �̹� �����Ǿ� �ִ� Ŭ���� ����
 * Selenium ȯ�漳��
 * 1. �����Ͽ� ���ۿ� �˻��ϰ� ���� ����Ʈ�� ��, JAVA��� ���̺귯�� �ٿ�ε� �� ����Ǯ��
 * 2. ������Ʈ �� Ŭ�� - properties - java build path - Libraries - add external jars (jar���� �Ѱ��� ���̺귯�� �ӿ� �ִ� ���� ���)
 * 3. ���ۿ� ũ�ҹ����� Ȯ���ϰ�, ũ�� ������ ���� ����Ʈ�� ���� ũ�� ����̹� �ٿ�ε�
 *     ->������Ʈ ������ .exe �������� ����Ǯ��
 */
	public static void main(String[] args) {
		//ũ�ҵ���̹� �ε�
		WebDriver driver; //�������� ���� ����
		
		//ũ�ҵ���̹� ���������� ��θ� �ڹ����� �˷������
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver(); //ChromeDriverŬ���� ��ü ����
		
		//�̵��� ����Ʈ�ּҸ� �Է�
		driver.get("http://www.naver.com");
		
		//�츮�� ã�����ϴ� ��ư/�׸�/�� ���� ����
		//���� ũ�Һ������� �����ִ� ���������� ��ư/�׸�/�Է°������� �����Ϸ���
		//XPath�� ���� ������ �� �� ����
		//ũ�Һ����� - F12���� �˻�ȭ�� ���� - ��� ã���ưŬ�� - ���ϴ� �׸�/�Է°��� Ŭ��
		// -> ���õ� �ؽ�Ʈ�� ������ Ŭ�� �� Copy -> Copy XPath ����
		//*[@id="query"]
		//���� ���̹� �������������� �˻�â�� ã��, search������ �����ϰڴ�.
		WebElement search = driver.findElement(By.xpath("//*[@id=\"query\"]")); //�������������� ��Ҹ� ã�� �� ����ϴ� �޼ҵ��̴�.
		//WebElement��ü.sendKeys(�Է��� ���ڿ�);
		//-> �ش��ҿ� Ű�����Է��� ������
		//WebElement��ü.click(); -> �ش��Ҹ� ���콺 ���� Ŭ��
		search.sendKeys("���糯��"); //�� ���̹� �˻�â�� ���糯����� ������;;; �ٵ� ���� ���� ��� �ȳ־ �Ѿ�� �ʾ���
		search.sendKeys(Keys.ENTER); //�̰� �ؾ� ���ͱ���� �Ǽ� ���糯�� �Է��ϰ� ����ġ�� ������ �Ѿ�� ���α׷��� �Ǵ� ����..
		
		
		
		//������ ��ȯ�� �Ͼ�� ������ ������ ��ҵ��� ����� �� ����
		//'���糯��'�� �˻��� ���â���� �µ� ��Ҹ� ���� �� �ڹ� �ܼ�â�� ���
		//*[@id="main_pack"]/div[2]/div[2]/div[2]/div[1]/div[3]/div[1]/div/p/span[1]
		//�̰��� �ٷ� ���糯�� �µ� ��Ҹ� �����ؿ°���
		WebElement temp = driver.findElement(By.xpath("//*[@id=\"main_pack\"]/div[2]/div[2]/div[2]/div[1]/div[3]/div[1]/div/p/span[1]"));
		
		//WebElement��ü.getText() : ������ ��ҿ� �ۼ��� ���ڸ� �����ϴ� �޼ҵ�
		String str_temp = temp.getText();
		System.out.println("����µ� : " + str_temp);
		
	}

}
