package ����_���ǹ�_�ݺ���;
import java.util.Scanner;

/*
 * �⵵�� �Է¹޾� ����(leap year)���� ���(common year)���� �Ǵ��ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 *400���� ����������� �����̴�.
 *�Ǵ� 4�� ����������� 100���� ����������� ������ �����̴�.
 *�������� ��� ����̴�.
 */
public class Main04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�⵵�� �Է����ּ��� : ");
		int year;
		year = sc.nextInt();
		
		String result;
		
		if(year%400 == 0) {
			System.out.println("�����Դϴ�.");
			result = "leap year";
		}
		else if(year%4 == 0 && year%100 == 0) {
			System.out.println("����Դϴ�.");
			result = "common year";
		}
		else if(year%4 == 0 && year%100 != 0) {
			System.out.println("�����Դϴ�.");
			result = "leap year";
		}
		else {
			System.out.println("����Դϴ�.");
			result = "common year";
		}
		
		System.out.println(result);
	}
	
	/*
	 * 400���� ������ �������� ���
	 * 4�� ������ �������� 100���� ������ �������� ���
	 * 4�� ������ �������� 100���� ������ �������� ������ ���
	 */


}
