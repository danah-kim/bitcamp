/**
* ���α׷��� �ϳ� �����ؾ� �մϴ�.
* ������ �ֹι�ȣ�� �Է��ϸ� �ش� �л��� ��������,��������, �ܱ�������
* �ڵ����� ����� �ִ� ���α׷��� ����� �޶��ϴ�.
* ������ ������ ���� ȭ�鿡 ����϶�� �մϴ�.
* ȫ�浿 : 800101 -1234567 : ��
* �Է°��� �̸��� �ֹι�ȣ�̰� ���� �ڵ����� ��µǴ� ���Դϴ�.
* ������� 1, 3���� ���۵Ǹ� ����, 2, 4�� ���۵Ǹ� ����, 5,6 �̸� �ܱ���
* ������ �Ǽ��� 0,7,8,9 �� ���� �ֹι�ȣ�� �Է��ϸ�
* "�ٽ� �Է��ϼ���" ��� �˷��ֽñ� �ٶ��ϴ�.

���� String gender = "";
�ֹε�Ϲ�ȣ 800101-1234567 ���� 1 �� �����ϴ� ����
String ssn = "800101-1234567";
char ch = ssn.charAt(7); �ϸ� 1 �� ����Ǿ� ch �� ����.
�׷��� ���ΰ��� '1' �̷��� �ȴ�
if(ch=='0'||ch=='7'||ch=='8'||ch=='9'){...}
*/
import java.util.Scanner;

public class CheckGender{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		System.out.println("�̸��� �ֹε�Ϲ�ȣ�� ������� �Է����ּ���.('-'�����Ͽ� �Է�)");
			String name = scan.next(), ssn = scan.next(), gender = "", result = "�ٽ� �Է��ϼ���.";
			char ch = ssn.charAt(7);

			switch(ch){
				case '1': 
				case '3': gender = "����"; break;
				case '2': 
				case '4': gender = "����"; break;
				case '5': 
				case '6': gender = "�ܱ���"; break;
				default : break;
			}
			
			if(gender==""){}
			else{result = name + " : " + ssn + " : " + gender;}

		System.out.println(result);
	}
}