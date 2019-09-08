package 기초_조건문_반복문;
/* 아래를 출력
2 3 4 5 6
3 4 5 6 7
4 5 6 7 8
5 6 7 8 9
6 7 8 9 10
 */
public class Main08 {
	public static void main(String args[])
	{
		//행에 해당하는 반복문 2~6
		for(int row = 2; row<=6; row++)
		{
			//열에 해당하는 반복문 0-4 5회
			for(int col = 0; col <= 4; col++) 
			{
				//숫자 출력
				System.out.print( (row + col) + " " );
			}
			//줄바꿈
			System.out.println();
		}
	}
}



