import java.util.Scanner;

public class GradeReport{
	public static void main(String[ ] args){
		Scanner scan = new Scanner(System.in);

		System.out.print("�̸�? \n");
		String name = scan.next(), result = "�߸��� ���� �Է��߽��ϴ�.";

		System.out.print("��������? \n");
		int score1 = scan.nextInt();
		if(score1>100){return;}

		System.out.print("��������? \n");
		int score2 = scan.nextInt();
		if(score2>100){return;}

		System.out.print("��������? \n");
		int score3 = scan.nextInt(), sum = (score1 + score2 + score3)/3;
		if(score3>100){return;}

		if(sum>=90){result = name + " [���] " + sum + " [����] A";}
		else if(sum>=80){result = name + " [���] " + sum + " [����] B";}
		else if(sum>=70){result = name + " [���] " + sum + " [����] C";}
		else if(sum>=60){result = name + " [���] " + sum + " [����] D";}
		else if(sum>=50){result = name + " [���] " + sum + " [����] E";}
		else{result = name + " [���] " + sum + " [����] F";}

		System.out.print(result);
	}
}

// ��� 90�̻� A
// 80 -B, 70 -C, 60 -D, 50 -E, 50�̸� F