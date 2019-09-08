package 웹다운로드;

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
 * 웹서버에 저장된 이미지 데이커를 프로그램으로 가져오는 기능
 * 가져온 이미지데이커를 하드 디스크에 저장하는 기능
 */

public class WebDownload {
	//웹서버 주소를 입력으로 이미지 데이터를 byte[]로 반환하는 메소드 생성
	public byte[] download(String url) {
		byte[] imageData = null;
		//InputStream으로 매개변수의 인터넷주소로 데이터를 가져옴
			try {
				//URL : 인터넷주소에 대한 접근을 할 수 있는 클래스
				URL Uri = new URL(url);
				//URL객체.openStream() : 인터넷주소로 얻을 수 있는 데이터를 접근하는 InputStream객체를 반환하는 메소드
				
				InputStream in = new BufferedInputStream(Uri.openStream());
				//1KB씩 이미지를 다운 받을 수 있도록 byte[] 생성
				byte[] buf = new byte[1024];
				int n = 0; //다운 받은 데이터의 크기를 저장할 변수
				ByteArrayOutputStream out = new ByteArrayOutputStream(); //바이트 배열을 하나 씩 쌓아 놓을 수 있는 ..
				
				//반복문 - 이미지를 전부 다운 받을 때까지 반복
				//InputStream객체.read(buf) 반환값은 수신받은 데이터의 크기
				//더이상 수신받을 데이터가 없는 경우 -1을 반환
				while(	(	n=in.read(buf)	)	!= -1	) {
					//1KB씩 다운받다가 1KB보다 작은 데이터를 다운받은경우를 고려해
					//0번 인덱스 부터 n까지의 바이트[]를 누적
					out.write(buf, 0, n);
				}
				//다운받은 이미지데이터를 보관한 out객체로 byte[] 추출
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
	//byte[]과 파일이름을 입력으로 하드 디스크에 파일을 저장하는 메소드
	public void saveImage(byte[] data, String filename) {
		try {
			//FileOutputStream 객체생성, 객체생성시 접근하는 파일은 매개변수 filename
			FileOutputStream fos = new FileOutputStream(filename);
			
			//객체.write로 매개변수 data를 파일에 입력
			fos.write(data);
			
			//객체닫기
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
