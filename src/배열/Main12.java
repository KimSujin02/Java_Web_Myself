package �迭;
import java.util.Scanner;

public class Main12 {
	
	//���� ���ʴ����� 558������
	public static void main(String[] args) {
		//100���� �迭�� ������ �� �ִ¹迭�� �����϶�
		//������ ���ʴ�� �Է¹޴ٰ� 0�� �ԷµǸ� 0�� ����
		//�� ������ �Էµ� ������ ���� ���߿� �Էµ� �������� ���ʷ� ����ϴ� ���α׷�
		
		
		int a[] = new int[100], i;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է����ּ���. (�ִ� 100���� �Է��� �� �ְ� 0�� �Է��ϸ� ����˴ϴ�.) : ");
		for(i=0; i<a.length; i++) {
			a[i] = sc.nextInt();
			//�Է°��� 0�̵Ǹ� �ݺ����� ����
			if(a[i] == 0) {
				break; //��������� �ݺ����� ���������� �̵�
			}
		}
		for(i=i-1; i>=0; i--) { //���⼭ �߿��� ���� i������ 0���� �ʱ�ȭ ���� �ʴ°���
			System.out.print(a[i] + "\t");
		}
		
		
		
	}

}
