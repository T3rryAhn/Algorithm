import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		int x = 0;
		
		while(Math.pow(2, x - 1) < n) {
			if(Math.pow(2, x - 1) == n)
			{
				break;
			}
			x++;
		}
	
		System.out.println(x);
		
		
	}

}
