import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int caseNum = sc.nextInt();
		int[] results = new int[caseNum];
		
		for(int i = 0; i < caseNum; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();
			
			int rr2 = Integer.max(r2, r1);
			int rr1 = Integer.min(r2, r1);
			
			int a = rr2 - rr1;
			int b = rr2 + rr1;
			double distance = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
			
			int result = 0;
			
			if(distance < a || b < distance) {
				result = 0;
			}
			else if(a == 0 && distance == 0) {
				result = -1;
			}
			else if(distance == 0 && a != 0) {
				result = 0;
			}
			else if(distance == a || distance == b) {
				result = 1;
			}
			else if(a < distance && distance < b) {
				result = 2;
			}
			
	
			results[i] = result;
		}
		for(int i = 0; i < caseNum; i++) {
			System.out.println(results[i]);
		}
	}
}

