package ����_���ǹ�_�ݺ���;
import java.util.Scanner;

public class Main10 {
	public static void main(String args[]) {
		//���� 134�� ����(���ʴ�����)
		Scanner sc = new Scanner(System.in);
		
		int even = 0, odd = 0, i;
		int a;
		
		System.out.print("���� 10���� �Է����ּ��� : ");
		for (i = 0; i < 10; i++) {
			a = sc.nextInt();
			if(a%2==0) {//¦���϶�
				even++;
			}
			else {
				odd++;
			}
		}
		
		System.out.println("¦���� ���� : " + even + "\nȦ���� ���� : " + odd);
		
		
	}
}
