package ����ó��_�����;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * �̹��� ������ ������ �̹����� �����Ű�� ����
 * �̹��� ����, ������������ �����͸� ��ȯ�ϴ� ��� -> ����ó��, ��ǻ�� ����
 */
public class Main24 {

	public static void main(String[] args) {
		//�̹��� �����͸� byte[]�� ����
		try {
			FileInputStream fis = new FileInputStream("a.RAW");
			
			//�̹��� ������ 256x256�� ���� �� �� �ִ� byte[] ����
			byte[] image_data = new byte[256*256];
			fis.read(image_data);
			fis.close();
			
			//�̹����� ��ȭ (��� ����, ���� ����)
			//��� �ε����� ������ �� ->�� ��->�� �����ϴ� ���� ����
			for(int i = 0; i < 256*256; i++) {
				//������
				//image_data[i] = (byte) (255 - image_data[i]);
				//��������
				//�ȼ� ���� � �����̻��� ��� ������� �̸��� ���  ��� ��ȯ
				
				if(image_data[i] >= (byte)0) {
					image_data[i] = (byte)255;
				}
				else {
					image_data[i] = (byte)0;
				}
			}
			
			
			//��ȭ�� ���� ���Ϸ� ����
			FileOutputStream fos = new FileOutputStream("result.RAW");
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//�̹����� ��ȭ(��� ����, ���� ����)
		
		//��ȭ�� ���� ���Ϸ� ����

	}

}
