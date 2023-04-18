import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lineNum = sc.nextInt();
		int count = 0;
		String [] results = new String[lineNum];
		String line = sc.nextLine();
		for(int n = 0; n < lineNum; n++) {
			line = sc.nextLine();
			for(int i = 0; i < line.length(); i++ ) {
				if(line.charAt(i) == '(') {
					count++;
				}
				else if(line.charAt(i) == ')') {
					count--;
				}
				if(count < 0) {
					results[n] = "NO";
					break;
				}
			}
			if(count == 0) {
				results[n] = "YES";
			}
			else {
				results[n] = "NO";
			}
			count = 0;
		}

		for(int i = 0 ; i < results.length; i++) {
			System.out.println(results[i]);
		}
	}
}

		



