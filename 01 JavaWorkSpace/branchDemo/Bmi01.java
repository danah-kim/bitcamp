/**
BMI = ������ / Ű�� �μ�, ���⼭ �����Դ� kg, Ű�� m �����̴�. 
���� ���ڸ�, ������ 55kg�� Ű 1.68m�� ����� BMI�� 55kg/(1.68m)^2 = 19.4�̴�.
2018�� ��������ħ���� �ܰ躰 �� ���Ӱ� ����Ǿ� 
18.5 �̸��̸� ��ü��, 
18.5��23�� ����, 
23~25�̸� '�� ���ܰ�', 
25��30�� '1�ܰ� ��', 
30��35�� '2�ܰ� ��' , 
35 �̻��̸� '3�ܰ� ��'���� �����Ѵ�.
*/
import java.util.Scanner;

public class Bmi01{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		while(true){
			System.out.println("Ű�� �����Ը� ������� �Է��� �ֽñ� �ٶ��ϴ�.");
			double m = scan.nextDouble()/100, kg = scan.nextDouble();
			double bmi = kg/(m*m);
			String result = "";

			if(bmi>=35.0){result = "3�ܰ� ��\n";}
			else if(bmi>=30.0 && bmi<35.0){result = "2�ܰ� ��\n";}
			else if(bmi>=25.0 && bmi<30.0){result = "1�ܰ� ��\n";}
			else if(bmi>=23.0 && bmi<25.0){result = "�� ���ܰ�\n";}
			else if(bmi>=18.5 && bmi<23.0){result = "����\n";}
			else if(bmi<18.5){result = "��ü��\n";}
			System.out.println(result);
		}
	}
}