package ���ٿ�ε�;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.interactions.InputSource;

/*
 * �������� ����� �̹��� ����Ŀ�� ���α׷����� �������� ���
 * ������ �̹�������Ŀ�� �ϵ� ��ũ�� �����ϴ� ���
 */

public class WebDownload {
	//������ �ּҸ� �Է����� �̹��� �����͸� byte[]�� ��ȯ�ϴ� �޼ҵ� ����
	public byte[] download(String url) {
		byte[] imageData = null;
		//InputStream���� �Ű������� ���ͳ��ּҷ� �����͸� ������
			try {
				//URL : ���ͳ��ּҿ� ���� ������ �� �� �ִ� Ŭ����
				URL Uri = new URL(url);
				//URL��ü.openStream() : ���ͳ��ּҷ� ���� �� �ִ� �����͸� �����ϴ� InputStream��ü�� ��ȯ�ϴ� �޼ҵ�
				
				InputStream in = new BufferedInputStream(Uri.openStream());
				//1KB�� �̹����� �ٿ� ���� �� �ֵ��� byte[] ����
				byte[] buf = new byte[1024];
				int n = 0; //�ٿ� ���� �������� ũ�⸦ ������ ����
				ByteArrayOutputStream out = new ByteArrayOutputStream(); //����Ʈ �迭�� �ϳ� �� �׾� ���� �� �ִ� ..
				
				//�ݺ��� - �̹����� ���� �ٿ� ���� ������ �ݺ�
				//InputStream��ü.read(buf) ��ȯ���� ���Ź��� �������� ũ��
				//���̻� ���Ź��� �����Ͱ� ���� ��� -1�� ��ȯ
				while(	(	n=in.read(buf)	)	!= -1	) {
					//1KB�� �ٿ�޴ٰ� 1KB���� ���� �����͸� �ٿ������츦 �����
					//0�� �ε��� ���� n������ ����Ʈ[]�� ����
					out.write(buf, 0, n);
				}
				//�ٿ���� �̹��������͸� ������ out��ü�� byte[] ����
				imageData = out.toByteArray();
				in.close();
				out.close();
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		return imageData;
	}
	//byte[]�� �����̸��� �Է����� �ϵ� ��ũ�� ������ �����ϴ� �޼ҵ�
	public void saveImage(byte[] data, String filename) {
		try {
			//FileOutputStream ��ü����, ��ü������ �����ϴ� ������ �Ű����� filename
			FileOutputStream fos = new FileOutputStream(filename);
			
			//��ü.write�� �Ű����� data�� ���Ͽ� �Է�
			fos.write(data);
			
			//��ü�ݱ�
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		WebDownload download = new WebDownload();
		byte[] data = download.download("https://search.pstatic.net/common/?src=http%3A%2F%2Fcafefiles.naver.net%2F20120611_289%2Fkkas_nknk55_1339391180925I3qnD_JPEG%2F%25B0%25ED%25BE%25E7%25C0%25CC9.jpg&type=b400");
		download.saveImage(data, "download.jpg");
	}

}
