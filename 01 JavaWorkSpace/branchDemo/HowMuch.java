import java.util.Scanner;

public class HowMuch{
	public static void main(String[ ] args){
		Scanner scan = new Scanner(System.in);

		System.out.println("�󸶿���?");

		int price = scan.nextInt();
		System.out.println(price + "�� �Դϴ�.");

		System.out.println("�� �� �帱���?");

		int number = scan.nextInt();
		System.out.println(number + "�� �ּ���.");

		int total = price * number;
		System.out.println("�� �ݾ��� " + total + "�� �Դϴ�.");
		System.out.println("��ο� ����ּ���");
		System.out.println("�� �ۼ�Ʈ DC �ұ��?");

		int percent = scan.nextInt();
		String result = "���Ⱦƿ�";
		if(percent<=10){
			result = total/100*(100-percent) + "�� �Դϴ�."; // 10�ۼ�Ʈ �̸�.
		}
		System.out.println(result); 
	}
}