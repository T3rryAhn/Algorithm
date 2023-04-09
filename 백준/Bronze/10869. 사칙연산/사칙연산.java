import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int a, b;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		sc.close();
		
		int result_1 = a + b;
		int result_2 = a - b;
		int result_3 = a * b;
		int result_4 = a / b;
		int result_5 = a % b;
		System.out.printf("%d%n%d%n%d%n%d%n%d", result_1, result_2, result_3, result_4, result_5);
		
	}

}