/**
숫자 2개를 입력 받아 첫번째 숫자부터 두번째 더하는 과정 및 합계 출력
단,첫번째수가 두번째 수 보다 적을 경우 두번째 숫자부터 첫번째 숫자까지 출력
*/
import java.util.Scanner;

public class WhileDemo2{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		System.out.println("합계를 구하고 싶은 숫자 2개를 입력하시오.");
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