import java.util.Scanner;

public class Calc03{
	public static void main(String[ ] args){

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter number 2");
			int num1 = scan.nextInt(), num2 = scan.nextInt(), num3 = 0; 

		System.out.println("Enter opcode");
			String opcode = scan.next();

		if(opcode.equals("+")){
			num3 = num1 + num2;
		}else if(opcode.equals("-")){
			num3 = num1 - num2;
		}else if(opcode.equals("*")){
			num3 = num1 * num2;
		}else if(opcode.equals("/")){
			num3 = num1 / num2
;		}else if(opcode.equals("%")){
			num3 = num1 % num2;
		}
			
		System.out.println(num1 + "\t" + opcode + "\t" + num2 + "\t" + "=" + "\t" + num3);
	}
}