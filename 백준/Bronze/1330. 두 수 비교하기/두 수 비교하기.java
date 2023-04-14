import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); int b =sc.nextInt();
		
		String [] results = {">", "<", "=="};
		String result;
		if(a > b) {
			result = results[0];
		}
		else if(a < b) {
			result = results[1];
		}
		else {
			result = results[2];
		}
		
		System.out.println(result);
		
	}
}
