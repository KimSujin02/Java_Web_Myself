package ����_���ǹ�_�ݺ���;

public class Main02 {

	public static void main(String[] args) {

		/*
		 * Switch ~ case �� : Ư�� ����/�������� � ���� ������ �ִ����� ���� ������ �ڵ带 �з��ϴ� ����
		 * switch ���� ���� �ִ� ������ char, int ���� ������ ���� ����� �� ����
		 */
		
		int a =18;
		//switch case �� 
		//�� if������ ���߿� �� �ڵ��� �Ѵٳ�
		
		switch (a/2) {
		//������ �������� �������� ���õ�
			case 1 : // a/2�� ����� 1�� ��쿡 ���� ó��
				System.out.println("a�� 2�� ���� ���� 1�Դϴ�.");
				break;
				
			case 2 : //a/2�� ����� 2�� ��쿡 ���� ó��
				System.out.println("a�� 2�� ���� ���� 2�Դϴ�.");
				break;
			
			case 5 : //�̷��� ������ ���׹����̶� �����̴�.
				System.out.println("a�� 2�� ���� ���� 5�Դϴ�.");
				break;
				
			case 6:
			case 7:
			case 8:
			case 9:
				System.out.println("---Switch��---\ncase 6, 7, 8, 9�߿� �ϳ� �϶� ������ ��¹��Դϴ�. \na/2�� ������� 6, 7, 8, 9�߿� �ϳ� �Դϴ�.\n");
				break;
				
			case 100: 
				break;
				
			default :
				System.out.println("���� ��� case�� �ƴѰ�쿡 ������ �ڵ��Դϴ�.(default)");
		} //Switch�� �ݱ�
		
		if (a/2 ==1) {
			System.out.println("case 1�� ������ ���ǽ�(if)");
		}
		else if(6 <= a/2 && a/2 <= 9) {
			System.out.println("---if��---\na/2�� ������� 6���� ũ�ų� ����, 9���� �۰ų� ���� �� �Դϴ�. \n6<=a/2<=9 \ncase 6, 7, 8, 9�� ���� ���ǽ��� \n");
		} //else if�� �ݱ�
		
		
		
		
		
	}//main �ݱ�

}//class�ݱ���
