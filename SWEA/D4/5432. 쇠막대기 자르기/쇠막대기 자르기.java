import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int caseNum = 1; caseNum <= T; caseNum++) {
			int count = 0;
			char pre = 0;
			Stack<Character> stack = new Stack<>();
			String input = sc.next();
			
			for (int i = 0; i < input.length(); i++) {
				// '(' 들어왔을때.
				if (input.charAt(i) == '(') {
					pre = '(';
					stack.push('(');
					continue;
				}
				// 여길 도달했다는 것은 ')' 를 받은 상태임.
				
				// 직전에 '(' 일때만 레이저 쏘기. -> stack에 쌓인 '(' 수만큼 막대기 갯수 세기
				// 아니라면 (그냥 막대기 닫힌거면) count + 1 하기
				if (pre == '(') {
					count += stack.size() - 1;	// 여기서 직전에 넣은 '('은 레이저 표시를 위함. 막대기가 아니므로 -1 
				} else {
					count++;
				}
				pre = ')';
				
				stack.pop();
			}
			
			System.out.printf("#%d %d%n", caseNum, count);
			
		}
	}
}
