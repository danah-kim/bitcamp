/**
���� �Է��ؼ� �ش� ���� ������ ���� �˷��ִ� ����.
���� ���, 3���̸� ������ 3��31���Դϴ�.
9���̸� ������ 9��30���Դϴ�.��� �˷���.
�� 2���� 2��28���� ���Ϸ� �ؼ� 2��28���Դϴ�.
*/
import java.util.Scanner;

public class MonthEndday01{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		System.out.println("���� �ش��ϴ� ���ڸ� �Է��Ͻÿ�.");
		int month = scan.nextInt(), day = 0;

		switch(month){
			case 1 : 
			case 3 :
			case 5 :
			case 7 :
			case 8 :
			case 10 :
			case 12 : day = 31; break;
			case 4 : 
			case 6 :
			case 9 :
			case 11 : day = 30; break;
			case 2 : day = 28; break;
		}

		System.out.println(month + "�� " + day + " �� �Դϴ�.");
	}
}