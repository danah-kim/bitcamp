/**
���� 2���� �Է� �޾� ù��° ���ں��� �ι�° ���ϴ� ���� �� �հ� ���
��,ù��°���� �ι�° �� ���� ���� ��� �ι�° ���ں��� ù��° ���ڱ��� ���
*/

import java.util.Scanner;

public class ForDemo{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		while(true){
			int sum = 0;
		 	String pre ="+", show="";
			System.out.println("0.���� 1.����");
			switch(scan.nextInt()){
				case 0: 
					return;
				case 1: 
					System.out.print("���� 2���� �Է��Ͻÿ�.");
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
				default : System.out.println("�߸��� ���� �Է��߽��ϴ�.");
			}
		}
		
	}
}