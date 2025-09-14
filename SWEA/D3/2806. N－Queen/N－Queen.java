

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int N;
	static int rowAndColUsedBit;
	static long diagonalUsedBit;
	static int count;
	
	// 왼위, 위, 오른위
	static int[] dr = {-1, -1, -1};
	static int[] dc = {-1, 0, 1};

	public static void main(String[] args) throws FileNotFoundException {
//		File file = new File("./src/swea/_2806_nQueen/sample_input (6).txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++ ) {
			// case start
			N = sc.nextInt();
			rowAndColUsedBit = 0;
			diagonalUsedBit = 0L;
			count = 0;

			dfs(0);
			
			System.out.println("#" + tc + " " + count);
			// case end
		}
	}// main
	
	static void dfs(int r) {
		if(r == N) {
			count++;
			return;
		}
		
		for(int c = 0; c < N; c++) {
			if(checkPosByBit(r, c)) {
				markPosOnBit(r, c);
				dfs(r + 1);
				unMarkPosOnBit(r, c);
			}
		}
		
	}
	
	static void unMarkPosOnBit(int r, int c) {
		// 32 칸중 절반 0 - 15 는 row, 16 - 31 는 col
		rowAndColUsedBit ^= (1 << r);
		rowAndColUsedBit ^= ((1 << 16) << c);
		
		// 64칸중 0 - 31 왼위 대각선, 32-63 오른위 대각선
		int dia1Idx = r - c + (N - 1);
		int dia2Idx = r + c;
		diagonalUsedBit ^= (1L << dia1Idx);
		diagonalUsedBit ^= ((1L << 32) << dia2Idx);
		
	}
	
	
	static void markPosOnBit(int r, int c) {
		// 32 칸중 절반 0 - 15 는 row, 16 - 31 는 col
		rowAndColUsedBit |= (1 << r);
		rowAndColUsedBit |= ((1 << 16) << c);
		
		// 64칸중 0 - 31 왼위 대각선, 32-63 오른위 대각선
		int dia1Idx = r - c + (N - 1);
		int dia2Idx = r + c;
		diagonalUsedBit |= (1L << dia1Idx);
		diagonalUsedBit |= ((1L << 32) << dia2Idx);
		
	}
	
	static boolean checkPosByBit(int r, int c) {
		int queryBit = (1 << r) + ((1 << 16) << c);
		int dia1Idx = r - c + (N - 1);
		int dia2Idx = r + c;
		long queryBit2 = (1L << dia1Idx) + ((1L << 32) << dia2Idx);
		
		if((rowAndColUsedBit & queryBit) == 0 && (diagonalUsedBit & queryBit2) == 0) {
			return true;
		}
		
		return false;
	}
	

}
