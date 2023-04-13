import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int a, b, c;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		sc.close();
		int result1 = (a + b) % c;
		int result2 = ((a % c) + (b % c)) % c;
		int result3 = (a * b) % c;
		int result4 = ((a % c) * (b % c)) % c;
		System.out.printf("%d%n%d%n%d%n%d", result1, result2, result3, result4);
		
	}

}
