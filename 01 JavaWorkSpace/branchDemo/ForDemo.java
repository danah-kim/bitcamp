/**
숫자 2개를 입력 받아 첫번째 숫자부터 두번째 더하는 과정 및 합계 출력
단,첫번째수가 두번째 수 보다 적을 경우 두번째 숫자부터 첫번째 숫자까지 출력
*/

import java.util.Scanner;

public class ForDemo{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		while(true){
			int sum = 0;
		 	String pre ="+", show="";
			System.out.println("0.종료 1.실행");
			switch(scan.nextInt()){
				case 0: 
					return;
				case 1: 
					System.out.print("숫자 2개를 입력하시오.");
					int n1 = scan.nextInt(), n2 = scan.nextInt(), ntx=0;
					if(n1>n2){
						ntx = n1;
						n1 = n2;
						n2 = ntx;
					}
					for(int i=n1; i<=n2; i++){
						if(i==n2){pre="=";}
						show += i+ pre;
						sum += i;
					}
					System.out.println(show + sum);
					break;
				default : System.out.println("잘못된 값을 입력했습니다.");
			}
		}
		
	}
}