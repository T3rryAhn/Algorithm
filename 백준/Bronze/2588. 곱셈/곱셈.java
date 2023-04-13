import java.util.Scanner;

class NumSplit {
	
	int[] splitNum(int a){
		String num = Integer.toString(a);
		int[] numbers = new int[num.length()];
		for(int i = 0; i < num.length(); i++) {
			numbers[i] = Character.getNumericValue(num.charAt(num.length() - i - 1));
		}
		return numbers;
	}
}

public class Main {
	public static void main(String[] args) {
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		
		num1 = sc.nextInt(); num2 = sc.nextInt();
		sc.close();
		
		NumSplit numSplit = new NumSplit();
		int[] numbers = numSplit.splitNum(num2);
		
		for(int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i] * num1);
		}
		System.out.println(num1 * num2);
	}
}