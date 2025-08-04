
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{	
            int[] arr = new int[10];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int sum = 0;
			for (int i = 0; i < 10; i++) {
                int n = sc.nextInt();
                min = Math.min(min, n);
                max = Math.max(max, n);
                sum += n;
            }
            double tmp = (double) (sum - min - max) / 8;
            int result = (int) (tmp + 0.5);
            System.out.printf("#%d %d%n", test_case, result);
		}
	}
}