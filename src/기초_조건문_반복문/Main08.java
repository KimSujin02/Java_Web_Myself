package ����_���ǹ�_�ݺ���;
/* �Ʒ��� ���
2 3 4 5 6
3 4 5 6 7
4 5 6 7 8
5 6 7 8 9
6 7 8 9 10
 */
public class Main08 {
	public static void main(String args[])
	{
		//�࿡ �ش��ϴ� �ݺ��� 2~6
		for(int row = 2; row<=6; row++)
		{
			//���� �ش��ϴ� �ݺ��� 0-4 5ȸ
			for(int col = 0; col <= 4; col++) 
			{
				//���� ���
				System.out.print( (row + col) + " " );
			}
			//�ٹٲ�
			System.out.println();
		}
	}
}



