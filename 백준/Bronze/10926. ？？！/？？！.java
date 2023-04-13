import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String id;
		String surprise = "??!";
		Scanner sc = new Scanner(System.in);
		
		id = sc.next();
		sc.close();
		System.out.println(id+surprise);
	}

}
