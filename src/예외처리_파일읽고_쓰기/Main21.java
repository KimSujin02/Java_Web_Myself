package 예외처리_파일읽고_쓰기;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 *파일 출력 예제
 *출력에 관한 클래스는 Output, Writer 같은 단어가 포함되어 있다.
 *FileOutputStrem :하드디스크에 새로운 파일을 생성하여 데이터를 저장하는 기능이 구형되어있다.
 *OutputStream 클래스를 상속받은 상태
 */

public class Main21 {
	public static void main(String args[]) {
		try {
			//text.txt파일을 쓰기모드로 접근하겠다.
			//만약 파일 존재하지 않는 경우 새로은 파일을 생성, 기존의 파일이 있는 경우
			//기존의 파일을 제거하고 데이터가 저장되있지 않은 새로운 파일을 생성
			//운영체제가 깔린 경로와 같은 관리자 권한이 필요한 경로에 파일을 생성할 경우
			//관리자 권한이 없을 때 실제 파일이 생성되지 않는다. -> FileNotFoundException 발생
			FileOutputStream fos = new FileOutputStream("test.txt");
			String input_str = "처음 사용하는 파일 입출력\n두번째줄";
			byte[] input_byte = input_str.getBytes();
			fos.write(input_byte);
			//파일 닫기
			fos.close(); //catch IOException을 추가하게 됨.
			
		} catch (FileNotFoundException e) { //Exception : 예외처리한다는 뜻
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//FileWriter :문자열 형태로 파일에 데이터를 저장할 수 있는 클래스
		//특정대상에 데이터를 입력하는 기능이 있는 클래스는 대부분 writer단어나 put단어가 
		//들어간 메소드로 그 기능을 사용 할 수 있음
		
		try {
			FileWriter fw = new FileWriter("test2.txt");
			
			fw.write("FileWriter객제를 활용한 파일 입력");
			fw.write("자동 줄바꿈 기능은 없기 때문에 줄바꿈 기호를 \n 입력해야함");
			
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//PrintWriter : 자바의 기본자료형을 파일에 그대로 저장할 수 있는 기능
		//+ 자동 줄바꿈기능이 있는 메소드 제공하는 클래스 이다.
		try {
			PrintWriter pw = new PrintWriter("test3.txt");
			for(int i = 1; i<11; i++) {
				String data = i+"번째 줄 입력";
				pw.println(data);
				pw.println(i);
			}
			pw.println(pw);//메모리 공간을 출력해 준다. 주소 같은건가.... 시발 모르겠다 어떤 메모리에 있었다.... 어떤 메모리 공간에 존재했다..라는 뜻이라네...
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
