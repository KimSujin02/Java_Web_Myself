package ����_���ǹ�_�ݺ���;
import java.util.Scanner;

//���� 250�� ������

public class Main09 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է����ּ���(m/M , f/F) : ");
		String sung = sc.next();
		
		System.out.print("��������� �Է����ּ��� : ");
		int number = sc.nextInt();
		
		if(sung.equals("m") || sung.equals("M") ) {
			if(number >= 2000) {
				number = 3;
			}
			else {
				number = 1;
			}
		}
		
		else if(sung.equals("f") || sung.equals("F") ) {
			if(number >= 2000) {
				number = 4;
			}
			else {
				number = 2;
			}
		}
		
		System.out.print("�ֹε�Ϲ�ȣ ���ڸ� ù��° ��ȣ�� : " + number + "�Դϴ�.");
		
	}

}
