package 셀레니움;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Selenium 라이브러리로 유튜브 사이트에서 키워드 관련 동영상 시청프로그램
 */

public class Main17 {

	public static void main(String[] args) {
		
		//크롬드라이버 실행파일의 경로를 자바한테 알려줘야함
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		//크롬드라이버 로드
		WebDriver driver = new ChromeDriver(); //ChromeDriver클래스 객체 생성
		
		//이동할 사이트주소를 입력
		driver.get("https://www.youtube.com");
		
		WebElement search = driver.findElement(By.xpath("//*[@id=\"search\"]"));
		
		
		
		//검색키워드 입력
		//Scanner 클래스의 객체를 생성. 생성된 객체로 사용자입력을 자바로 불러옴
		Scanner sc = new Scanner (System.in);
		System.out.print("검색키워드를 입력하세오 : ");
		String keyword = sc.nextLine();
		
		//사용자가 입력한 문자열로 검색어 입력
		search.sendKeys(keyword);
		search.sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(1000); //1초동안 프로그램이 일시정지하는 메소드이다.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//동영상 목록 추출
		//*[@id="video-title"]
		//search = driver.findElement(By.xpath("//*[@id=\"video-title\"]"));
		
		//첫번째 동영상 요소르 왼쪽 클릭
		//search.click();
		
		
		
		//동영상 목록 추출 및 순차적인 동영상 시청
		//List 자료형 : 배열과 유사하게 하나의 변수에 여러개의 데이터를 저장할 수 있는 공간이다.
		//배열과 차이점 : 배열은 배열크기가 제한이 있지만 리스트는 크기제한이 없다.
		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"video-title\"]"));
		
		
		//추출된 요소의 갯수를 저장 -> 반복문 횟수로 사용
		int n = list.size(); //리스트 객체에 저장된 요소의 갯수 반환 메소드이다.
		
		//반복문 - 0부터 요소의 갯수 -1 반복
		for(int i = 0; i<n; i++) {
			
			//반복문에 사용되는 변수로 리스트 변수를 인덱싱 - WevElement객체 추출
			list.get(i); //1번째 인덱스에 저장된 WebElement객체를 반환하는 메소드
			
			//현재페이지 주소를 기억
			//WebDriver객체.getCurrentUrl() : 열려있는 현재페이지의 주소를 반환하는 메소드
			String url = driver.getCurrentUrl();
			
			//Click()메소드 호출
			search.click();
			
			//일정시간 대기
			try {
				Thread.sleep(5000); //10초동안 대기
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//동영상 목록페이지로 이동
			driver.get(url);
			
			//동영상 목록 추출 - 페이지 변환이 일어났기 때문에 기존의 요소추출 객체를 사용하지 못한다.
			list = driver.findElements(By.xpath("//*[@id=\"video-title\"]"));
		}
		
		
	}

}
