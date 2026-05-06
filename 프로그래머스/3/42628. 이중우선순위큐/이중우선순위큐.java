import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        Map<Integer, Integer> count = new HashMap<>();

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int value = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                minHeap.offer(value);
                maxHeap.offer(value);
                count.put(value, count.getOrDefault(value, 0) + 1);
            } else {
                if (value == 1) {
                    removeTop(maxHeap, count);
                } else {
                    removeTop(minHeap, count);
                }
            }
        }

        clean(minHeap, count);
        clean(maxHeap, count);

        if (minHeap.isEmpty() || maxHeap.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{maxHeap.peek(), minHeap.peek()};
    }

    private void removeTop(PriorityQueue<Integer> heap, Map<Integer, Integer> count) {
        clean(heap, count);

        if (heap.isEmpty()) return;

        int removed = heap.poll();
        count.put(removed, count.get(removed) - 1);
    }

    private void clean(PriorityQueue<Integer> heap, Map<Integer, Integer> count) {
        while (!heap.isEmpty() && count.getOrDefault(heap.peek(), 0) == 0) {
            heap.poll();
        }
    }
}