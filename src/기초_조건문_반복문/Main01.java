package ����_���ǹ�_�ݺ���;
import java.util.Scanner;

/*
 * ���α׷� �����ϴ� ��� - ���ǹ�
 * ���ǹ� : boolean Ÿ���� ������ ���� true�� ��쿡 ������ �ڵ带 �и��� �� �ִ� �����̴�.
 * if�� : if(����� �Ǵ� ������) -> true���� ����Ǹ� if�ȿ��� ������ �ڵ带 ������ �� �ִ� ����
 * if���� ���������� ���� �� �ڵ�� �߰�ȣ �ȿ� �ۼ��Ѵ�.
 */
public class Main01 {

	public static void main(String[] args) {
		System.out.println("------Scanner �ǽ�------ \n");
		//����� �Է��� ó���ϴ� �ڵ�
		//Scanner : ����� �Է��� �ܼ�â���� �ޱ� ���� ������ �ڷ���
		Scanner sc = new Scanner(System.in);
		//����� �Է��� Ȧ������ ¦������ Ȯ��
		int num;
		System.out.print("���ϴ� ���ڰ��� �Է����ּ��� : ");
		num = sc.nextInt(); //����ڰ� �Է��� ���ڰ��� num ������ �����Ѵ�.
		System.out.println("����� �Է°� : " + num + "\n\n");
		//����� �Է°��� Ȧ������ ¦������ ����
		
		System.out.println("------if�� �ǽ�-----\n");
		
		if(num%2 == 1) { // %�� �������� ���ϴ� ������ �̴�. ������ ���� num�� 2�� ������ �������� 1�̸�,,
			System.out.println(num + "�� Ȧ�� �Դϴ�.\n\n");
		}
		
		else {
			System.out.println(num + "�� ¦�� �Դϴ�.\n\n");
		}
		
		
		//else if(�����) : if���� �ɼ����� �� ���ǵ��� �������� ������,
		//������� �����ϴ��� Ȯ���ϴ� ����
		/*
		 * if(�����1) {
		 * 	���๮1
		 * }
		 * else if(�����2) {
		 * 	���๮2
		 * }
		 * else if(�����3) {
		 * 	���๮3
		 * }
		 * else {
		 * 	���๮4
		 * }
		 * 
		 * ���� else if���� ������� ���� �� ������, ������ ����� �����ϴ�.
		 */
		
		
		System.out.println("------if���� Scanner �ǽ�------\n");
		
		//����ڷ� ���� ���� �Է¹޾� �з��ϱ�(��/��)
		String name; //���ڿ��� �����ϴ� name ��������
		System.out.print("������ �̸� �Է� : ");
		name = sc.next();
		
		//name �Է°��� ȫ�浿�̳� �ƴϳĸ� �з��� ���� �ƴϸ� ����� �ƴϸ� ����� ���� �ƴϸ� �׷� ��� ����
		
		if(name.equals("ȫ�浿")) {
			System.out.println("ȫ�浿�� �ȳ��ϼ���\n\n");
		}
		else if(name.equals("�����")) {
			System.out.println("������� �ȳ��ϼ��� ��\n\n");
		}
		else if(name.equals("�����")) {
			System.out.println("������� �ȳ��ϼ��� ��\n\n");
		}
		else {
			System.out.println("ȸ���� �ƴϽʴϴ�.\n\n");
		}
	}

}
