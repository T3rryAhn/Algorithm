import java.util.Scanner;

public class Solution {
	static int power(int a, int b) {
		if (b <= 0) return 1;
		
		return a * power(a, --b);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int caseNum = sc.nextInt();
			int base = sc.nextInt();
			int exponent = sc.nextInt();
			int result = power(base, exponent);
			
			System.out.printf("#%d %d%n", caseNum, result);
		}
	}
}