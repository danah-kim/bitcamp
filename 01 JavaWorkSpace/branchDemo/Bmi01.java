/**
BMI = 몸무게 / 키² 로서, 여기서 몸무게는 kg, 키는 m 단위이다. 
예를 들자면, 몸무게 55kg에 키 1.68m인 사람의 BMI는 55kg/(1.68m)^2 = 19.4이다.
2018년 비만진료지침에서 단계별 용어가 새롭게 변경되어 
18.5 미만이면 저체중, 
18.5∼23은 정상, 
23~25이면 '비만 전단계', 
25∼30은 '1단계 비만', 
30∼35는 '2단계 비만' , 
35 이상이면 '3단계 비만'으로 구분한다.
*/
import java.util.Scanner;

public class Bmi01{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		while(true){
			System.out.println("키와 몸무게를 순서대로 입력해 주시기 바랍니다.");
			double m = scan.nextDouble()/100, kg = scan.nextDouble();
			double bmi = kg/(m*m);
			String result = "";

			if(bmi>=35.0){result = "3단계 비만\n";}
			else if(bmi>=30.0 && bmi<35.0){result = "2단계 비만\n";}
			else if(bmi>=25.0 && bmi<30.0){result = "1단계 비만\n";}
			else if(bmi>=23.0 && bmi<25.0){result = "비만 전단계\n";}
			else if(bmi>=18.5 && bmi<23.0){result = "정상\n";}
			else if(bmi<18.5){result = "저체중\n";}
			System.out.println(result);
		}
	}
}