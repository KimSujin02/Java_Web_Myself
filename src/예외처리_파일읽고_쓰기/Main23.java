package 예외처리_파일읽고_쓰기;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * 직렬화(Serialize)
 * 역직렬화(DeSerialize)
 */

//직렬화가 허용된 클래스 정의
//직렬화를 시용할 수 있는 조건 : 자바개발자가 제공한 자료형만 멤버변수로 사용하는 경우만 가능

class Student implements Serializable {
	// 멤버변수 정의
	String name; //학생이름
	int phone; //핸드폰 넘버
	float score; //점수
	
	//Student 객체를 파일로 저장하는 정적 메소드
	public static void saveObject(Student stu) throws IOException {
		//저장할 파일을 쓰기모드로 접근
		FileOutputStream fos = new FileOutputStream("save.txt");
		
		//객체를 파일로 저장할 수 있는 객체 생성
		//ObjectOutputStream : 객체 정보를 파일이나 네트워크로 전송할때 사용하는 클래스 이다.
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//객체 저장 메소드 호출
		oos.writeObject(stu);
		
		//파일 닫기
		oos.flush(); //버퍼를 지우는 행위..
		fos.close();
	}
	
	//파일에 저장된 데이터로 Student 객체를 만드는 정적 메소드
	public static Student loadObject() {
		Student stu = null;
		//save.dat을 읽기모드로 접근
		try {
			FileInputStream fis = new FileInputStream("save.txt");
			
			//ObjectInputStream 객체 생성 및 파일의 바이트데이터를 객체로 변환메소드 호출
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			//ois.readObject() : 파일의 바이트데이터를  Object객체로 변환 및 반환 메소드 Object객체를 Student객체로 강제 형변환해 저장
			stu = (Student) ois.readObject();
			
			fis.close();
			
		} catch (FileNotFoundException e) {
			//save.dat파일이 없는 경우에 대한 예외 처리
			System.out.println("로드할 파일이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return stu;
	}
}

public class Main23 {
	public static void main(String srgs[]) {
		Student stu = new Student();
		stu.name = "김수진";
		stu.phone = 89029135;
		stu.score = 4.5f;
		
		try {
			//프로그램이 동작하는 중에 객체정보를 파일로 저장
			Student.saveObject(stu);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//파일에 데이터로 Student 객체 생성
		Student loadstu = Student.loadObject();

		System.out.println(loadstu.name);
		System.out.println(loadstu.phone);
		System.out.println(loadstu.score);
	}

}






















