import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		List<Integer> nums = new ArrayList<>();
		
		for(int i = n; i > 0; i--) {
			List<Integer> tmpNums = new ArrayList<>();
			int pre = n;
			int now = i;
			tmpNums.add(n);
			tmpNums.add(i);
			
			int isSecondZero = 0;
			while(pre - now >= 0) {
				if(pre == now) {
					isSecondZero++;
				}
				int tmp = pre;
				pre = now;
				now = tmp - now;
				tmpNums.add(now);

				if (isSecondZero == 2) {
					break;
				}
			}
			
			if(tmpNums.size() > nums.size()) {
				nums = tmpNums;
			}
		}
		
		System.out.println(nums.size());
		for(int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

}
