package ����_���ǹ�_�ݺ���;
import java.util.Scanner;

public class Main03 {

	public static void main(String[] args) {
		Scanner sc =new Scanner (System.in);
		System.out.print("�����Ը� �Է����ּ��� : ");
		double weight = sc.nextDouble();
		String result;
		
		if(weight <= 50.8) {
			System.out.println("Fly�� �Դϴ�.");
			result = "Flyweght";
		}
		else if(weight <= 61.23) { //else if ������ �� ���� : ���� �ִ� ������ �������� ���ϸ� false�� ó�� �Ǿ� ������ ������� �� �ʿ䰡 ��������. 
			System.out.println("Light�� �Դϴ�.");
			result = "Lightweight";
		}
		else if(weight <= 71.57) {
			System.out.println("Middle�� �Դϴ�.");
			result = "Middleweight";
		}
		else if(weight <= 88.45) {
			System.out.println("Cruiser�� �Դϴ�.");
			result = "Cruiserweight";
		}
		else {
			//���� �ִ� ���ǽĵ�� ���� �����԰� 88.45���� ū���� Ȯ���ߴ�.
			//if ( weight > 88.45 ) <<<<<�� ���ǽİ� ���ٰ� �Ҽ��ִ�.
			result = "Heavyweight";
		}
		
		System.out.println(result);
	}

}
