/**
���� 2���� �Է� �޾� ù��° ���ں��� �ι�° ���ϴ� ���� �� �հ� ���
��,ù��°���� �ι�° �� ���� ���� ��� �ι�° ���ں��� ù��° ���ڱ��� ���
*/
import java.util.Scanner;

public class WhileDemo2{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		System.out.println("�հ踦 ���ϰ� ���� ���� 2���� �Է��Ͻÿ�.");
		int num1 = scan.nextInt(), num2 = scan.nextInt(), ntx = 0, i = 0, sum = 0;
		String count = "", pre = "+";

		if(num1>num2){
			ntx = num1;
			num1 = num2;
			num2 = ntx;
		}

		while(num1 <= num2){
			count += num1 + pre;
			sum += num1;
			num1++;
		}

		pre = "=";

		System.out.print(count + pre + sum);
	}
}