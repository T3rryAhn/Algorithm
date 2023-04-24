import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int lineNum = sc.nextInt();
		sc.nextLine();
		String[] fileNames = new String[lineNum];
		for(int i = 0; i < lineNum; i++) {
			fileNames[i] = sc.nextLine();
		}
		sc.close();
		
		char[] result = new char[fileNames[0].length()];
		for(int i = 0; i < fileNames[0].length(); i++) {
			for(int j = 0; j < fileNames.length - 1; j++) {
				if(fileNames[j].charAt(i) == fileNames[j + 1].charAt(i)) {
					result[i] = fileNames[j].charAt(i);
				}
				else {
					result[i] = '?';
					break;
				}
			}

		}
		
		if(lineNum == 1) {
			System.out.println(fileNames[0]);
		}
		else {
			System.out.println(new String(result));
		}
	}

}
