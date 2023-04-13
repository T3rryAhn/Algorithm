import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		
		long total = 0;
		for(int i = 0; i < n; i++) {
			
			if(a[i] < b) {
				total += 1;
			}
			else if((a[i] - b) % c == 0) {
				total += (a[i] - b) / c + 1;
			}
			else {
				total += (a[i] - b) / c + 2;
			}
		}
		
		System.out.println(total);
		
	}
}