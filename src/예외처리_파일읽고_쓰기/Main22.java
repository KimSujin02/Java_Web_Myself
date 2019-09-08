package 예외처리_파일읽고_쓰기;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * 파일 입력 예제
 * 파일에 들어있는 값을 불러오는 거 같음 콘솔에... 아마도
 * 실행하면 Main21에서 만든 test.txt에 넣은 데이터를 읽어온다.
 */

public class Main22 {

	public static void main(String[] args) {
		
		
		//FileInputStream : 파일을 읽기 모드로 접근해 바이트 단위로 읽는 클래스이다.
		//File : 하드디스트에 저장된 파일에 대한 정보를 엽ㄹ람하는 클래스 이다.
		try {
			FileInputStream fis = new FileInputStream(new File("test.txt"));
			
			byte[] output_bytes = new byte[fis.available()]; //읽기를 하려면 바이크 배열이 필요하다. 글자를 하나하나 불러와야 하나...
			//fis.read[byte[]) : 메소드의 인자값으로 넣은 byte[]에 파일 데이터를 저장하는 메소드 이다.
			//파일 크기보다 작은 byte[]이 온경우, byte[]에 데이터를 채우고 나서 남은 데이터를 접근할 수 있도록 커서위치를 이동함.
			fis.read(output_bytes);
			
			System.out.println(new String(output_bytes));
			
			fis.close(); //catch IOException을 추가하게 됨
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//BufferedReader : byte데이터를 모아서 문자열로 변환해주는 클래스
		//BufferedReader의 생성자는 xxxxReader 클래스의 객체를 인자로 사용함.
		try {
			BufferedReader br = new BufferedReader(new FileReader("test2.txt"));
			
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				else {
					System.out.println(line);
				}
			}
			
			br.readLine();//즐단위로 읽어 들이겠다.
			
			br.close(); //catch문 안에 IOException 을 추가하게 된다. 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
