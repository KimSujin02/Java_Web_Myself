package �迭;
import java.util.Scanner;

public class Main14 {
	//���� ���ʴ����� 161�� ������
	public static void main(String[] args) {
		//�л����� ������ �Է��� �޴ٰ� 0�� �ԷµǸ� 
		//�� ������ �Է¹��� ������ 10�� ������ �����Ͽ�
		//�����뺰 �л� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		//(1�� ���� ������ ������� �ʴ´�.)�л��� �ִ� 100�������̴�.
		
		Scanner sc = new Scanner(System.in);
		int a;
		int n[] = new int[11];
		int i;
		
		System.out.print("������ �Է��ϼ���(0�� �ԷµǸ� ����˴ϴ�.) : ");
		for(i=0; i<100; i++) {
			a = sc.nextInt();
				if(a == 0) {
					break;
				}
			n[a/10]++;
			
		}
		
		
		for(i=10; i>=0; i--) {
			if(n[i] != 0) {
				System.out.println((i*10) + "���� : " + n[i] + "��");
			}
		}
		

	}

}
