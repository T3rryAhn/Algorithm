import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] nums = new int [n];
        String [] lineInputs = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(lineInputs[i]);
        }

        String result = getMin(nums) + " " + getMax(nums);

        System.out.println(result);

    }

    //method
    public static int getMin(int[] nums) {
        int a = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < a) {
                a = nums[i];
            }
        }
        return a;
    }

    public static int getMax(int[] nums) {
        int a = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > a) {
                a = nums[i];
            }
        }
        return a;
    }
}

