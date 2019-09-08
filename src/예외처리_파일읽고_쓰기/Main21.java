package ����ó��_�����а�_����;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 *���� ��� ����
 *��¿� ���� Ŭ������ Output, Writer ���� �ܾ ���ԵǾ� �ִ�.
 *FileOutputStrem :�ϵ��ũ�� ���ο� ������ �����Ͽ� �����͸� �����ϴ� ����� �����Ǿ��ִ�.
 *OutputStream Ŭ������ ��ӹ��� ����
 */

public class Main21 {
	public static void main(String args[]) {
		try {
			//text.txt������ ������� �����ϰڴ�.
			//���� ���� �������� �ʴ� ��� ������ ������ ����, ������ ������ �ִ� ���
			//������ ������ �����ϰ� �����Ͱ� ��������� ���� ���ο� ������ ����
			//�ü���� �� ��ο� ���� ������ ������ �ʿ��� ��ο� ������ ������ ���
			//������ ������ ���� �� ���� ������ �������� �ʴ´�. -> FileNotFoundException �߻�
			FileOutputStream fos = new FileOutputStream("test.txt");
			String input_str = "ó�� ����ϴ� ���� �����\n�ι�°��";
			byte[] input_byte = input_str.getBytes();
			fos.write(input_byte);
			//���� �ݱ�
			fos.close(); //catch IOException�� �߰��ϰ� ��.
			
		} catch (FileNotFoundException e) { //Exception : ����ó���Ѵٴ� ��
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//FileWriter :���ڿ� ���·� ���Ͽ� �����͸� ������ �� �ִ� Ŭ����
		//Ư����� �����͸� �Է��ϴ� ����� �ִ� Ŭ������ ��κ� writer�ܾ put�ܾ 
		//�� �޼ҵ�� �� ����� ��� �� �� ����
		
		try {
			FileWriter fw = new FileWriter("test2.txt");
			
			fw.write("FileWriter������ Ȱ���� ���� �Է�");
			fw.write("�ڵ� �ٹٲ� ����� ���� ������ �ٹٲ� ��ȣ�� \n �Է��ؾ���");
			
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//PrintWriter : �ڹ��� �⺻�ڷ����� ���Ͽ� �״�� ������ �� �ִ� ���
		//+ �ڵ� �ٹٲޱ���� �ִ� �޼ҵ� �����ϴ� Ŭ���� �̴�.
		try {
			PrintWriter pw = new PrintWriter("test3.txt");
			for(int i = 1; i<11; i++) {
				String data = i+"��° �� �Է�";
				pw.println(data);
				pw.println(i);
			}
			pw.println(pw);//�޸� ������ ����� �ش�. �ּ� �����ǰ�.... �ù� �𸣰ڴ� � �޸𸮿� �־���.... � �޸� ������ �����ߴ�..��� ���̶��...
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
