import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Solution{
	public static void main(String[] args) throws FileNotFoundException {
//		File file = new File ("src\\_8913_zero\\sample_input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int caseNum = 1; caseNum <= T; caseNum++) {
			// each case world~~~~
			Stack<Integer> stack = new Stack<>();
			int sum = 0;
			
			int K = sc.nextInt();
			for (int i = 0; i < K; i++) {
				int inputNum = sc.nextInt();
				
				if(inputNum == 0) {
					sum -= stack.pop();
					continue;
				}
				
				sum += stack.push(inputNum);
			}
			
			System.out.printf("#%d %d%n", caseNum, sum);
		}
		
	}
	
}
