package 영상처리_입출력;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 이미지 파일을 접근해 이미지를 변경시키는 예제
 * 이미지 파일, 동영상파일의 데이터를 변환하는 기법 -> 영상처리, 컴퓨터 비젼
 */
public class Main24 {

	public static void main(String[] args) {
		//이미지 데이터를 byte[]에 저장
		try {
			FileInputStream fis = new FileInputStream("a.RAW");
			
			//이미지 사이즈 256x256을 저장 할 수 있는 byte[] 생성
			byte[] image_data = new byte[256*256];
			fis.read(image_data);
			fis.close();
			
			//이미지의 변화 (흑백 반전, 이진 영상)
			//모든 인덱스를 접근해 백 ->흑 흑->백 변경하는 연산 수행
			for(int i = 0; i < 256*256; i++) {
				//흑백반전
				//image_data[i] = (byte) (255 - image_data[i]);
				//이진영상
				//픽셀 값이 어떤 기준이상인 경우 백색으로 미만인 경우  흑색 변환
				
				if(image_data[i] >= (byte)0) {
					image_data[i] = (byte)255;
				}
				else {
					image_data[i] = (byte)0;
				}
			}
			
			
			//변화한 값을 파일로 저장
			FileOutputStream fos = new FileOutputStream("result.RAW");
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//이미지의 변화(흑백 반전, 이진 영상)
		
		//변화한 값을 파일로 저장

	}

}
