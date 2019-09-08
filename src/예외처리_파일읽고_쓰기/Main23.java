package ����ó��_�����а�_����;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * ����ȭ(Serialize)
 * ������ȭ(DeSerialize)
 */

//����ȭ�� ���� Ŭ���� ����
//����ȭ�� �ÿ��� �� �ִ� ���� : �ڹٰ����ڰ� ������ �ڷ����� ��������� ����ϴ� ��츸 ����

class Student implements Serializable {
	// ������� ����
	String name; //�л��̸�
	int phone; //�ڵ��� �ѹ�
	float score; //����
	
	//Student ��ü�� ���Ϸ� �����ϴ� ���� �޼ҵ�
	public static void saveObject(Student stu) throws IOException {
		//������ ������ ������� ����
		FileOutputStream fos = new FileOutputStream("save.txt");
		
		//��ü�� ���Ϸ� ������ �� �ִ� ��ü ����
		//ObjectOutputStream : ��ü ������ �����̳� ��Ʈ��ũ�� �����Ҷ� ����ϴ� Ŭ���� �̴�.
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//��ü ���� �޼ҵ� ȣ��
		oos.writeObject(stu);
		
		//���� �ݱ�
		oos.flush(); //���۸� ����� ����..
		fos.close();
	}
	
	//���Ͽ� ����� �����ͷ� Student ��ü�� ����� ���� �޼ҵ�
	public static Student loadObject() {
		Student stu = null;
		//save.dat�� �б���� ����
		try {
			FileInputStream fis = new FileInputStream("save.txt");
			
			//ObjectInputStream ��ü ���� �� ������ ����Ʈ�����͸� ��ü�� ��ȯ�޼ҵ� ȣ��
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			//ois.readObject() : ������ ����Ʈ�����͸�  Object��ü�� ��ȯ �� ��ȯ �޼ҵ� Object��ü�� Student��ü�� ���� ����ȯ�� ����
			stu = (Student) ois.readObject();
			
			fis.close();
			
		} catch (FileNotFoundException e) {
			//save.dat������ ���� ��쿡 ���� ���� ó��
			System.out.println("�ε��� ������ �����ϴ�.");
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
		stu.name = "�����";
		stu.phone = 89029135;
		stu.score = 4.5f;
		
		try {
			//���α׷��� �����ϴ� �߿� ��ü������ ���Ϸ� ����
			Student.saveObject(stu);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//���Ͽ� �����ͷ� Student ��ü ����
		Student loadstu = Student.loadObject();

		System.out.println(loadstu.name);
		System.out.println(loadstu.phone);
		System.out.println(loadstu.score);
	}

}






















