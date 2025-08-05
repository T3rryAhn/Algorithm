package TIL.Array;

import java.util.Arrays;

public class Array08_2차원배열순회 {
    public static void main(String[] args) {
        // 2 4
        // 1 2 3 4
        // 5 6 7 8

        int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 1, 2, 3 } };
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println();

        System.out.println("행 우선순회 ");
        // 행 우선 순회
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                System.out.printf("%2d", arr[row][col]);
            }
            System.out.println();
        }

        System.out.println("reverse");
        // 행 우선 순회 역방향 두가지 방법
        // 1. for 문 조건을 건드리는 방식
        // 2. 인덱스를 건드리는 방식

        // 1.
        for (int row = 0; row < arr.length; row++) {
            for (int col = arr[0].length - 1; col >= 0; col--) {
                System.out.printf("%2d", arr[row][col]);
            }
            System.out.println();
        }
        System.out.println();
        // 2.
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                System.out.printf("%2d", arr[row][arr[0].length - 1 - col]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("열 우선 순회");
        // 열 우선 순회
        for (int col = 0; col < arr[0].length; col++) {
            for (int row = 0; row < arr.length; row++) {
                System.out.printf("%2d", arr[row][col]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("reverse");

        // 열 우선 순회 역방향
        for (int col = 0; col < arr[0].length; col++) {
            for (int row = 0; row < arr.length; row++) {
                System.out.printf("%2d", arr[arr.length - 1 - row][col]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("zigzag");
        // 지그재그

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                System.out.printf("%2d", arr[row][(row % 2 == 0 ? col : arr[0].length - 1 - col)]); // 행마다 조건문
                System.out.printf("%2d", arr[row][col + (arr[0].length - 1 - 2 * col) * (row % 2)]); // 행을 2로 나눈 나머지를
                                                                                                     // 곱해서 수식 switch
                // 둘의 성능차이는 거의 없다. 진짜 없는 수준
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("가변길이");

        int[][] arr1 = { { 1, 2, 3, 4 }, { 5, 6 }, { 7, 8, 9 } };
        for (int[] a : arr1) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
        // 행우선
        for (int row = 0; row < arr1.length; row++) {
            for (int col = 0; col < arr1[row].length; col++) {
                System.out.printf("%2d", arr[row][col]);
            }
            System.out.println();
        }
        System.out.println();

        // 열 고정
        int maxLen = 0;
        for (int[] a : arr1) {
            maxLen = Math.max(maxLen, a.length);
        }

        for (int col = 0; col < maxLen; col++) {
            for (int row = 0; row < arr1.length; row++) {
                // if (arr1[row].length - 1 < col) {
                //     System.out.printf("  ");
                // } else {
                //     System.out.printf("%2d", arr1[row][col]);
                // }
                System.out.printf("%2s", col < arr1[row].length ? arr1[row][col] : " ");
            }
            System.out.println();
        }
    }
}