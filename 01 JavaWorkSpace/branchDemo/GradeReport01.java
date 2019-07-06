import java.util.Scanner;

public class GradeReport01{
	public static void main(String[ ] args){
		Scanner scan = new Scanner(System.in);

		System.out.print("이름? \n");
		String name = scan.next(), result = "잘못된 값을 입력했습니다.";

		System.out.print("국어점수? \n");
		int score1 = scan.nextInt();
		if(score1>100){return;}

		System.out.print("영어점수? \n");
		int score2 = scan.nextInt();
		if(score2>100){return;}

		System.out.print("수학점수? \n");
		int score3 = scan.nextInt(), sum = (score1 + score2 + score3)/3, cas = sum/10;
		if(score3>100){return;}

		switch(cas){
			case 9 : result = name + " [평균] " + sum + " [학점] A"; break;
			case 8 : result = name + " [평균] " + sum + " [학점] B"; break;
			case 7 : result = name + " [평균] " + sum + " [학점] C"; break;
			case 6 : result = name + " [평균] " + sum + " [학점] D"; break;
			case 5 : result = name + " [평균] " + sum + " [학점] E"; break;
			default : result = name + " [평균] " + sum + " [학점] F"; break;
		}
		System.out.print(result);
	}
}

// 평균 90이상 A
// 80 -B, 70 -C, 60 -D, 50 -E, 50미만 F