import java.util.Scanner;

public class RPSGame{
	public static void main(String[] args){
		System.out.println("Enter Player1 and Player2 data. one of three data. Rock, Paper, Scissors");

		Scanner scan = new Scanner(System.in);
		String player1 = scan.next(), player2 = scan.next(), result = "";

		if((player1.equals("Rock") && player2.equals("Rock")) || (player1.equals("Paper") && player2.equals("Paper")) || (player1.equals("Scissors") && player2.equals("Scissors"))){
				result = "draw";
		}else if(
			(player1.equals("Rock") && player2.equals("Scissors")) || (player1.equals("Paper") && player2.equals("Rock")) || (player1.equals("Scissors") && player2.equals("Paper"))){
				result = "Player1 Win";

		}else if((player1.equals("Scissors") && player2.equals("Rock")) || (player1.equals("Rock") && player2.equals("Paper")) || (player1.equals("Paper") && player2.equals("Scissors"))){
				result = "Player2 win";
		}else{
			System.out.println("You entered wrong text.");
		}
		System.out.print(result);
	}
}