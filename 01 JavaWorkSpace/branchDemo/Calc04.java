import java.util.Scanner;

public class Calc04{
	public static void main(String[ ] args){

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter number 2");
			int num1 = scan.nextInt(), num2 = scan.nextInt(), num3 = 0; 

		System.out.println("Enter opcode");
			String opcode = scan.next(), result = "";

			switch(opcode){
				case "+" : num3 = num1 + num2; break;
				case "-" : num3 = num1 - num2; break;
				case "*" : num3 = num1 * num2; break;
				case "/" : num3 = num1 / num2; break;
				case "%" : num3 = num1 % num2; break;
				default : result = "EEROR"; break;
			}
			if(result=="EEROR"){
			}
			else{
				result = num1 + opcode + num2 + num3;
			}

		System.out.println(result);	
	}		

}