package ����_���ǹ�_�ݺ���;
import java.util.Scanner;

/*
 * �� ���� �Ǽ��� �Է¹޾� ��� 4.0 �̻��̸� "A", ��� 3.0 �̻��̸� "B", �ƴϸ� "C" ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */
public class Main05 {
	public static void main(String[] args) {
		
		double a;
		double b;
		String result;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù��° �Ǽ��� �Է����ּ��� : ");
		a = sc.nextDouble(); //<<<�� �̰� ���� ����..... Int�� ��ٰ� �����Ծ ���ʴ���
		
		System.out.print("�ι�° �Ǽ��� �Է����ּ��� : ");
		b = sc.nextDouble();
		
		if (a >= 4.0 && b >= 4.0) {
			result = "A";
		}
		else if (a >= 3.0 && b >= 3.0) {
			result = "B";
		}
		else {
			result = "C";
		}
		System.out.println("����� : " + result);
		
		
		
		
		
	}

}
