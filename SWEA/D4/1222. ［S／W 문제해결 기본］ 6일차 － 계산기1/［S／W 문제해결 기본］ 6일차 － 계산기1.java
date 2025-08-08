import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		StringBuilder postFix = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			// each case world~~~~
			
			// inFix to postFix
			Stack<Character> stack = new Stack<>();
			int len = sc.nextInt();
			String inFix = sc.next();
			
			for (int i = 0; i < len; i++) {
				char c = inFix.charAt(i);
				
				if (c >= '0' && c <= '9') {
					postFix.append(c);
					if (!stack.isEmpty()) {
						postFix.append(stack.pop());
					}
				} else {
					stack.push(c);
				}
			}
			
			// calculate postFix
			Stack<Integer> intStack = new Stack<>();
			for (int i = 0; i < postFix.length(); i++) {
				char c = postFix.charAt(i);
				
				if (c >= '0' && c <= '9') {
					intStack.push(c - '0');
				} else {
					intStack.push(intStack.pop() + intStack.pop());
				}
			}
			
			System.out.printf("#%d %d%n", tc, intStack.pop());
			// each case end
		}
		
	}
}
