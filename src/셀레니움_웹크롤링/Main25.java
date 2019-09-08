package �����Ͽ�_��ũ�Ѹ�;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ��_�̹���_�ٿ�ε�.WebDownload;

/*
 * ���� ����Ʈ�� ����ڰ� �Է��� Ű����� ������ �̹����� �ϵ� ��ũ�� �ڵ� �����ϴ� ���α׷�
 */
public class Main25 {
	public static void main(String[] args) {
		//ũ�ҵ���̹��� �������� ��ġ�� ����ؾߴ�
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		
		//WebDriver ��ü ����
		WebDriver driver = new ChromeDriver();
		
		//��ü.get �޼ҵ�� �̵��� ����Ʈ ȣ��
		//https://www.google.com/search?&source=lnms&tbm=isch&sa=X&ved=0ahUKEwi396_y-cDkAhWHfd4KHaErDhoQ_AUIEigB&biw=929&bih=888
		//�˻�� ���� �����̹��� �������� �ٷ� �̵� �� �� �ֵ��� ���ͳ��ּҸ� �����Ͽ���. ���� ��ȣ���� ���� ������ �̹��� �˻�â�� ũ�Ѹ��Ͽ���.
		String url = "https://www.google.com/search?&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiBgqf2-sDkAhXDA4gKHXBXCDEQ_AUIEigB&biw=1920&bih=925&q=" + "������";
		driver.get(url);
		
		//*[@id="rg_s"]/div[1] / div[2]
		
		//���ѹݺ� - �ݺ�Ƚ���� �����ϴ� i���� ����
		
		for(int i =1;;i++) {
			String xpath = "//*[@id=\"rg_s\"]/div[" + i + "]";
			//���� ������������ Xpath�� ���� ��� ����
			WebElement div = driver.findElement(By.xpath(xpath));
			
			//���ۻ���Ʈ�� ��ũ���� ������ �Ʒ� �̹����� �ε��� �ֱ� ������ Ű������ 'PageDown'�� ���������� �Է�
			//Ű������ 'pagedown'�� ���������� �Է�
			if(i % 5 ==0) {
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			}
			
			try {
			//������ ��ҿ� ���Ե� img�±׸� ����
			WebElement img = div.findElement(By.tagName("img"));
			
			//img�±׿� src�Ӽ��� ����
			String src = img.getAttribute("src");
			String filename = "download_" + i + ".jpg";
			
			//���ǹ� - src �Ӽ����� base64�������� ���ͳ��ּ����� �ľ�
			if(src.contains("base64")) {
				//�̹��� ������ �� ������ ����κ��� �����ϱ� ���� ','�� ã��
				src = src.split(",")[1];
				byte[] imageBytes = DatatypeConverter.parseBase64Binary(src);
				BufferedImage bufImg = ImageIO.read(new ByteArrayInputStream(imageBytes));
				ImageIO.write(bufImg, "jpg", new File(filename));
			}
			else {
				WebDownload download = new WebDownload();
				byte[] datas = download.download(src);
				download.saveImage(datas, filename);
			}
			
			
			}catch(Exception e) {//������ div���� �̹����±װ� �������� ���� ����ó��
				continue;
			}
			
			//�Ѱ��� �̹����� �ٿ�ް� ��� ���� 1�ʰ�
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
