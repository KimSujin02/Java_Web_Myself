package ����ó��_�����а�_����;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * ���� �Է� ����
 * ���Ͽ� ����ִ� ���� �ҷ����� �� ���� �ֿܼ�... �Ƹ���
 * �����ϸ� Main21���� ���� test.txt�� ���� �����͸� �о�´�.
 */

public class Main22 {

	public static void main(String[] args) {
		
		
		//FileInputStream : ������ �б� ���� ������ ����Ʈ ������ �д� Ŭ�����̴�.
		//File : �ϵ��Ʈ�� ����� ���Ͽ� ���� ������ �������ϴ� Ŭ���� �̴�.
		try {
			FileInputStream fis = new FileInputStream(new File("test.txt"));
			
			byte[] output_bytes = new byte[fis.available()]; //�б⸦ �Ϸ��� ����ũ �迭�� �ʿ��ϴ�. ���ڸ� �ϳ��ϳ� �ҷ��;� �ϳ�...
			//fis.read[byte[]) : �޼ҵ��� ���ڰ����� ���� byte[]�� ���� �����͸� �����ϴ� �޼ҵ� �̴�.
			//���� ũ�⺸�� ���� byte[]�� �°��, byte[]�� �����͸� ä��� ���� ���� �����͸� ������ �� �ֵ��� Ŀ����ġ�� �̵���.
			fis.read(output_bytes);
			
			System.out.println(new String(output_bytes));
			
			fis.close(); //catch IOException�� �߰��ϰ� ��
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//BufferedReader : byte�����͸� ��Ƽ� ���ڿ��� ��ȯ���ִ� Ŭ����
		//BufferedReader�� �����ڴ� xxxxReader Ŭ������ ��ü�� ���ڷ� �����.
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
			
			br.readLine();//������� �о� ���̰ڴ�.
			
			br.close(); //catch�� �ȿ� IOException �� �߰��ϰ� �ȴ�. 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
