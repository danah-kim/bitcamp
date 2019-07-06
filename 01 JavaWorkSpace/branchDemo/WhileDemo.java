public class WhileDemo{
	public static void main(String[] args){
		int count = 1, total = 0;
		String num = "", pre = " + ";

		while(count < 11){
			num += count + pre;
			total += count;

			if(count == 10){pre = " = ";}
			
			count++;
		}
		System.out.print(num + pre + total);
	}
}