import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] nums = new int [9];


        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(nums[getMax(nums)]);
        System.out.println(getMax(nums) + 1);

    }

    //method
    public static int getMin(int[] nums) {
        int a = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < a) {
                a = nums[i];
                index = i;
            }
        }
        return index;
    }

    public static int getMax(int[] nums) {
        int a = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > a) {
                a = nums[i];
                index = i;
            }
        }
        return index;
    }
}

