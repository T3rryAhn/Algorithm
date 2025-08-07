import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			// each case

			Stack<Character> stack = new Stack<>();
			int result = 1;
			char c = 0;
			int len = sc.nextInt();
			String input = sc.next();

			for (int i = 0; i < len; i++) {
				c = input.charAt(i);

				if ("({[<".contains(c + "")) {
					stack.push(c);
					continue;
				}

				if (stack.isEmpty()) {
					result = 0;
					break;
				}

				char tmp = stack.pop();

				switch (c) {
				case '}':
					if (tmp != '{') {
						result = 0;
					}
					break;
				case ')':
					if (tmp != '(') {
						result = 0;
					}
					break;
				case '>':
					if (tmp != '<') {
						result = 0;
					}
					break;
				case ']':
					if (tmp != '[') {
						result = 0;
					}
					break;
				}

				if (result == 0) {
					break;
				}
			}

			System.out.printf("#%d %d%n", tc, result);

		}

	}
}
