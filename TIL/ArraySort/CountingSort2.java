package TIL.ArraySort;

import java.util.Arrays;

public class CountingSort2 {

    public static void main(String[] args) {
        int[] arr = new int[] {0,-4,-1,-31,-2,-4,-1};
        
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(countingSort(arr)));
    }
    
    public static int[] countingSort(int[] arr) {
        
        // 1. arr의 요소를 index 값으로 가지는 count 배열에 횟수를 기록
        // 그럼 배열의 길이를 어떻게 가져가야 할까? -> for문을 돌면서 min값과 max 값을 찾는다.
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        int size = max - min + 1;
        int[] count = new int[size];

        //count 배열에 카운팅할건데 [0] -> min    idx + min == value, value - min = idx
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        
        // 2. count 배열을 누적합으로 변경
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // 3. arr 배열을 뒤에서부터 읽으면서 arr요소가 count 배열의 인덱스이고, 해당 값에 -1을 한 값이 sortArr의 인덱스가 된다.
        // 해당 인덱스 위치에 arr 요소 값을 넣는다.
        int[] sortArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortArr[--count[arr[i] - min]] = arr[i];
        }
        
        // 4. sortArr 배열 반환
        
        return sortArr;
    }

}