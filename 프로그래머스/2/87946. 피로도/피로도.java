class Solution {
    static int k;
    static int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        this.k = k;
        this.dungeons = dungeons;
        
        answer = permutation(0, k, 0);
        
        return answer;
    }
    
    public int permutation(int depth, int k, int bitMask) {
        int max = depth;
        
        for (int i = 0; i < dungeons.length; i++) {
            if (((bitMask & (1 << i)) > 0)) continue;
                
            if (dungeons[i][0] <= k) {
                int nextBitMask = (bitMask | (1 << i));
                max = Math.max(max, permutation(depth + 1, k - dungeons[i][1], nextBitMask));
            }
        }
        
        return max;
    }
}