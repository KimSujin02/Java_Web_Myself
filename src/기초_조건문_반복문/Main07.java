package ����_���ǹ�_�ݺ���;
import java.util.Scanner;

/*
 * 0 �� �Էµ� ������ ������ ��� �Է¹޾� 3�� ����� 5�� ����� 
 * ������ ������ ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */
public class Main07 {
	public static void main(String[] args)
	{
		//���� ����
		int cnt=0, input=0;
		Scanner sc = new Scanner(System.in);
		//for
		for(;;) 
		{
			//������Է��� ������ ����
			input = sc.nextInt();
			//������Է��� 0�ΰ�� �ݺ��� ����
			if (input == 0)
			{
				break;
			}
			//3�ǹ��, 5�ǹ���� �ƴ� ���ڴ� Ƚ������
			if( input % 3 != 0 && input % 5 != 0)
			{
				cnt++;
			}
		}
		//����Ƚ�� ��� ���
		System.out.println(cnt);
	}
}






