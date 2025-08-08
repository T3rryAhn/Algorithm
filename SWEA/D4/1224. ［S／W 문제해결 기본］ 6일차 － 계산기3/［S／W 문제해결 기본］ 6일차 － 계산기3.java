import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);

		// 연산자 우선순위 선언
		Map<Character, Integer> operatorPeriority = new HashMap<>();
		operatorPeriority.put('*', 2);
		operatorPeriority.put('+', 1);
		operatorPeriority.put('(', 0);

		for (int caseNum = 1; caseNum <= 10; caseNum++) {
			// each case world~~~

			// 연산자 저장용 스택
			// 후위 표시법 스트링 빌더
			Stack<Character> stack = new Stack<>();
			StringBuilder postFix = new StringBuilder();

			// 입력
			int len = sc.nextInt();
			String inFix = sc.next();

			// 중위 표시법 앞에서부터 끝까지 순회 시작
			for (int i = 0; i < len; i++) {
				char c = inFix.charAt(i);

				// 숫자면 바로 후위에 추가
				if (c >= '0' && c <= '9') {
					postFix.append(c);
				}
				// 연산자라면
				else {
					switch (c) {
					case '(':
						stack.push(c);
						break;
					case ')':
						while (stack.peek() != '(') {
							postFix.append(stack.pop());
						}
						stack.pop();
						break;

					default:
						while (stack.peek() != '('
								&& operatorPeriority.get(stack.peek()) >= operatorPeriority.get(c)) {
							postFix.append(stack.pop());
						}
						stack.push(c);
						break;
					}
				}
			}

			while (!stack.isEmpty()) {
				postFix.append(stack.pop());
			}

			// 계산 시작
			Stack<Integer> intStack = new Stack<>();
			for (int i = 0; i < postFix.length(); i++) {
				char c = postFix.charAt(i);
				
				if (c >= '0' && c <= '9') {
					intStack.push(c - '0');
				} else {
					switch (c) {
					case '+':
						intStack.push(intStack.pop() + intStack.pop());
						break;
					case '*':
						intStack.push(intStack.pop() * intStack.pop());
						break;
					}
				}
			}
			
			System.out.printf("#%d %d%n", caseNum, intStack.pop());

			// each case end
		}
	}
}
