import java.util.Scanner;

public class GradeReport01{
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
		int score3 = scan.nextInt(), sum = (score1 + score2 + score3)/3, cas = sum/10;
		if(score3>100){return;}

		switch(cas){
			case 9 : result = name + " [���] " + sum + " [����] A"; break;
			case 8 : result = name + " [���] " + sum + " [����] B"; break;
			case 7 : result = name + " [���] " + sum + " [����] C"; break;
			case 6 : result = name + " [���] " + sum + " [����] D"; break;
			case 5 : result = name + " [���] " + sum + " [����] E"; break;
			default : result = name + " [���] " + sum + " [����] F"; break;
		}
		System.out.print(result);
	}
}

// ��� 90�̻� A
// 80 -B, 70 -C, 60 -D, 50 -E, 50�̸� F