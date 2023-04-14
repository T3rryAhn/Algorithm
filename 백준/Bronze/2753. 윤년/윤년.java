import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		int leafyearCheck = 0;
		
		if(year%400 == 0 || (year%4 == 0 && !(year % 100 ==0))) {
			leafyearCheck = 1;
		}
		
		System.out.println(leafyearCheck);
	}
}