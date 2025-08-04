package TIL.ArraySort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
		int[] arr = {0,4,1,3,1,2,4,1};
		
		System.out.println(Arrays.toString(countingSort(arr)));
	}
	
	public static int[] countingSort(int[] arr) {
		// find max value
		int k = -1;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > k) { k = arr[i]; }
		}
		
        // 빈도수 체크 배열 생성
		int[] count = new int[k + 1];
		
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		
		// 누적합 구하기 (경계 표시)
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		
		// 역방향으로 원본 순회하면서 정렬 시작 안정정렬
		int[] sortArr = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			sortArr[--count[arr[i]]] = arr[i];
		}
		
		return sortArr;
	}
}
