/**
������ 4�� �������� 0 �̶�� ������ �� �ִ�.
�׷��� �ش� ������ 100���� ������ �������� ����̴�.

2000���� 4�� �������� 0 �̶� ������ �� �ִµ�..
�ٽ� �� ���� 100���� ���� �������� ����̴�.
����̶� �ص� �ٽ� 400���� ���� �������� ������ �����̴�.

����) 2000�� �� 2016 ���� �Է��ϸ� �������� ����
*/

import java.util.Scanner;

public class LeapYear{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter Year");
		int year = scan.nextInt();
		String result="���";

		if(year%4==0 && year%100!=0 || year%400==0){
			result = "����";
		}
		else{}

		System.out.println(result);
	}
}