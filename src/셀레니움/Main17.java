package �����Ͽ�;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Selenium ���̺귯���� ��Ʃ�� ����Ʈ���� Ű���� ���� ������ ��û���α׷�
 */

public class Main17 {

	public static void main(String[] args) {
		
		//ũ�ҵ���̹� ���������� ��θ� �ڹ����� �˷������
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		//ũ�ҵ���̹� �ε�
		WebDriver driver = new ChromeDriver(); //ChromeDriverŬ���� ��ü ����
		
		//�̵��� ����Ʈ�ּҸ� �Է�
		driver.get("https://www.youtube.com");
		
		WebElement search = driver.findElement(By.xpath("//*[@id=\"search\"]"));
		
		
		
		//�˻�Ű���� �Է�
		//Scanner Ŭ������ ��ü�� ����. ������ ��ü�� ������Է��� �ڹٷ� �ҷ���
		Scanner sc = new Scanner (System.in);
		System.out.print("�˻�Ű���带 �Է��ϼ��� : ");
		String keyword = sc.nextLine();
		
		//����ڰ� �Է��� ���ڿ��� �˻��� �Է�
		search.sendKeys(keyword);
		search.sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(1000); //1�ʵ��� ���α׷��� �Ͻ������ϴ� �޼ҵ��̴�.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//������ ��� ����
		//*[@id="video-title"]
		//search = driver.findElement(By.xpath("//*[@id=\"video-title\"]"));
		
		//ù��° ������ ��Ҹ� ���� Ŭ��
		//search.click();
		
		
		
		//������ ��� ���� �� �������� ������ ��û
		//List �ڷ��� : �迭�� �����ϰ� �ϳ��� ������ �������� �����͸� ������ �� �ִ� �����̴�.
		//�迭�� ������ : �迭�� �迭ũ�Ⱑ ������ ������ ����Ʈ�� ũ�������� ����.
		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"video-title\"]"));
		
		
		//����� ����� ������ ���� -> �ݺ��� Ƚ���� ���
		int n = list.size(); //����Ʈ ��ü�� ����� ����� ���� ��ȯ �޼ҵ��̴�.
		
		//�ݺ��� - 0���� ����� ���� -1 �ݺ�
		for(int i = 0; i<n; i++) {
			
			//�ݺ����� ���Ǵ� ������ ����Ʈ ������ �ε��� - WevElement��ü ����
			list.get(i); //1��° �ε����� ����� WebElement��ü�� ��ȯ�ϴ� �޼ҵ�
			
			//���������� �ּҸ� ���
			//WebDriver��ü.getCurrentUrl() : �����ִ� ������������ �ּҸ� ��ȯ�ϴ� �޼ҵ�
			String url = driver.getCurrentUrl();
			
			//Click()�޼ҵ� ȣ��
			search.click();
			
			//�����ð� ���
			try {
				Thread.sleep(5000); //10�ʵ��� ���
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//������ ����������� �̵�
			driver.get(url);
			
			//������ ��� ���� - ������ ��ȯ�� �Ͼ�� ������ ������ ������� ��ü�� ������� ���Ѵ�.
			list = driver.findElements(By.xpath("//*[@id=\"video-title\"]"));
		}
		
		
	}

}
