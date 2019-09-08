package 셀레니움_웹크롤링;

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

import 웹_이미지_다운로드.WebDownload;

/*
 * 구글 사이트에 사용자가 입력한 키워드와 관련한 이미지를 하드 디스크에 자동 저장하는 프로그램
 */
public class Main25 {
	public static void main(String[] args) {
		//크롬드라이버의 실행파일 위치를 등록해야댐
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		
		//WebDriver 객체 생성
		WebDriver driver = new ChromeDriver();
		
		//객체.get 메소드로 이동하 사이트 호출
		//https://www.google.com/search?&source=lnms&tbm=isch&sa=X&ved=0ahUKEwi396_y-cDkAhWHfd4KHaErDhoQ_AUIEigB&biw=929&bih=888
		//검색어를 통한 관련이미지 페이지로 바로 이동 할 수 있도록 인터넷주소를 수정하였다. 나는 눈호강을 위해 박찬열 이미지 검색창을 크롤링하였다.
		String url = "https://www.google.com/search?&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiBgqf2-sDkAhXDA4gKHXBXCDEQ_AUIEigB&biw=1920&bih=925&q=" + "박찬열";
		driver.get(url);
		
		//*[@id="rg_s"]/div[1] / div[2]
		
		//무한반복 - 반복횟수를 저장하는 i변수 증가
		
		for(int i =1;;i++) {
			String xpath = "//*[@id=\"rg_s\"]/div[" + i + "]";
			//현재 웹페이지에서 Xpath를 통한 요소 선택
			WebElement div = driver.findElement(By.xpath(xpath));
			
			//구글사이트는 스크롤을 내려야 아래 이미지를 로드해 주기 때문에 키보드의 'PageDown'을 웹페이지에 입력
			//키보드의 'pagedown'을 웹페이지에 입력
			if(i % 5 ==0) {
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			}
			
			try {
			//선택한 요소에 포함된 img태그를 추출
			WebElement img = div.findElement(By.tagName("img"));
			
			//img태그에 src속성을 추출
			String src = img.getAttribute("src");
			String filename = "download_" + i + ".jpg";
			
			//조건문 - src 속성값이 base64형태인지 인터넷주소인지 파악
			if(src.contains("base64")) {
				//이미지 데이터 중 데이터 설명부분을 제외하기 위해 ','를 찾음
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
			
			
			}catch(Exception e) {//추출한 div에서 이미지태그가 없을때에 대한 예외처리
				continue;
			}
			
			//한개의 이미지를 다운받고 잠시 정지 1초간
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
