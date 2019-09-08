package 셀레니움;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//셀레니움(Selenium)참고 위키독스
//https://wikidocs.net/35954
//
//셀레니움 공식 사이트(다운로드)
//https://www.seleniumhq.org/download/
//
//셀레니움 자바(웹페이지 관련 가이드/셀레니움에 대한 설명)
//https://gdtbgl93.tistory.com/154

public class Main16 {
/*
 * Selenium 라이브러리로 크롬브라우저 조종 예제
 * Selenium : 웹자동화 기능이 구현되있는 라이브러리
 * 라이브러리 : 어떤 기능을 구현하기 위해 처리해야하는 작업들이 이미 구현되어 있는 클래스 모음
 * Selenium 환경설정
 * 1. 셀레니움 구글에 검색하고 공식 사이트에 들어가, JAVA언어 라이브러리 다운로드 및 압축풀기
 * 2. 프로젝트 우 클릭 - properties - java build path - Libraries - add external jars (jar파일 한개와 라이브러리 속에 있는 파일 모두)
 * 3. 구글에 크롬버전을 확인하고, 크롬 브라우저 공식 사이트에 가서 크롬 드라이버 다운로드
 *     ->프로젝트 폴더에 .exe 실행파일 압축풀기
 */
	public static void main(String[] args) {
		//크롬드라이버 로드
		WebDriver driver; //웹브라우저 조종 변수
		
		//크롬드라이버 실행파일의 경로를 자바한테 알려줘야함
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver(); //ChromeDriver클래스 객체 생성
		
		//이동할 사이트주소를 입력
		driver.get("http://www.naver.com");
		
		//우리가 찾고자하는 버튼/그림/글 등을 추출
		//현재 크롬브라우저에 열려있는 페이지에서 버튼/그림/입력공간들을 선택하려면
		//XPath를 통해 선택을 할 수 있음
		//크롬브라우저 - F12으로 검사화면 열기 - 요소 찾기버튼클릭 - 원하는 그림/입력공간 클릭
		// -> 선택된 텍스트에 오른쪽 클릭 후 Copy -> Copy XPath 선택
		//*[@id="query"]
		//현재 네이버 메인페이지에서 검색창을 찾아, search변수에 저장하겠다.
		WebElement search = driver.findElement(By.xpath("//*[@id=\"query\"]")); //현재페이지에서 요소를 찾을 때 사용하는 메소드이다.
		//WebElement객체.sendKeys(입력할 문자열);
		//-> 해당요소에 키보드입력을 수행함
		//WebElement객체.click(); -> 해당요소를 마우스 왼쪽 클릭
		search.sendKeys("현재날씨"); //헐 네이버 검색창에 현재날씨라고 적어줌;;; 근데 아직 엔터 기능 안넣어서 넘어가진 않았음
		search.sendKeys(Keys.ENTER); //이거 해야 엔터기능이 되서 현재날씨 입력하고 엔터치고 페이지 넘어가는 프로그램이 되는 거임..
		
		
		
		//페이지 변환이 일어나면 기존에 추출한 요소들을 사용할 수 없다
		//'현재날씨'로 검색한 결과창에서 온도 요소를 추출 및 자바 콘솔창에 출력
		//*[@id="main_pack"]/div[2]/div[2]/div[2]/div[1]/div[3]/div[1]/div/p/span[1]
		//이것이 바로 현재날씨 온도 요소를 추출해온거임
		WebElement temp = driver.findElement(By.xpath("//*[@id=\"main_pack\"]/div[2]/div[2]/div[2]/div[1]/div[3]/div[1]/div/p/span[1]"));
		
		//WebElement객체.getText() : 선택한 요소에 작성된 글자를 추출하는 메소드
		String str_temp = temp.getText();
		System.out.println("현재온도 : " + str_temp);
		
	}

}
