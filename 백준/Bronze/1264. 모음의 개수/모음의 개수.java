import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = "";
		String allWords = "";
		int count = 0;
		while(!(input.equals("#"))) {
			input = sc.nextLine();
		
			allWords += input + "#";
		}
		sc.close();
		String[] lines = allWords.split("#");
		for(int i = 0; i < lines.length; i++) {
			for(int j = 0; j < lines[i].length(); j++) {
				switch(lines[i].charAt(j)) {
				case 'a': case 'e': case 'i': case 'o': case 'u':
				case 'A': case 'E': case 'I': case 'O': case 'U':
					count++;
					break;
				}
			}
			System.out.println(count);
			count = 0;
		}
	}
}