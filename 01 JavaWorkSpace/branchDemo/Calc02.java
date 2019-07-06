import java.util.Scanner;

public class Calc02{
	public static void main(String[ ] args){

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter number 2");
			int num1 = scan.nextInt(), num2 = scan.nextInt(); 

		System.out.println("Enter opcode");	
			
		System.out.println(num1 + " + " + num2 + " = " + num3);
		System.out.println(num1 + " - " + num2 + " = " + num4);
		System.out.println(num1 + " * " + num2 + " = " + num5);
		System.out.println(num1 + " / " + num2 + " = " + num6);
		System.out.println(num1 + " % " + num2 + " = " + num7);
	}
}