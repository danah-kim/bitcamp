/**
월을 입력해서 해당 월의 마지막 날을 알려주는 로직.
예를 들면, 3월이면 말일이 3월31일입니다.
9월이면 말일이 9월30일입니다.라고 알려줌.
단 2월은 2월28일을 말일로 해서 2월28일입니다.
*/
import java.util.Scanner;

public class MonthEndday01{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		System.out.println("월에 해당하는 숫자를 입력하시오.");
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

		System.out.println(month + "월 " + day + " 일 입니다.");
	}
}