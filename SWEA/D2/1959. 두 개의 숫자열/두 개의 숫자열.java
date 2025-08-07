
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException{

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int caseNum = 1; caseNum <= T; caseNum++) {
			//each case
			
			int N = sc.nextInt();
			int M = sc.nextInt();	
			
			int[] A = new int[N];
			int[] B = new int[M];
			int[] tmp = A;
			
			
			
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}
			
			if (N > M) {
				A = B;
				B = tmp;
			}
			
			int len = B.length - A.length;
			
			int max = 0;
			int tempSum = 0;
			for (int i = 0; i < len + 1; i++) {
				for (int j = 0; j < A.length; j++) {
					tempSum += A[j] * B[i + j];
				}
				max = max > tempSum ? max : tempSum;
				tempSum = 0;
			}
			
			System.out.printf("#%d %d%n", caseNum, max);
		}
	}
}
