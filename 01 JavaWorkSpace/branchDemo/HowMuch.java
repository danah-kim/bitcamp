import java.util.Scanner;

public class HowMuch{
	public static void main(String[ ] args){
		Scanner scan = new Scanner(System.in);

		System.out.println("얼마에요?");

		int price = scan.nextInt();
		System.out.println(price + "원 입니다.");

		System.out.println("몇 개 드릴까요?");

		int number = scan.nextInt();
		System.out.println(number + "개 주세요.");

		int total = price * number;
		System.out.println("총 금액은 " + total + "원 입니다.");
		System.out.println("비싸요 깍아주세요");
		System.out.println("몇 퍼센트 DC 할까요?");

		int percent = scan.nextInt();
		String result = "안팔아요";
		if(percent<=10){
			result = total/100*(100-percent) + "원 입니다."; // 10퍼센트 미만.
		}
		System.out.println(result); 
	}
}