import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
                PriorityQueue<int[]> readyQ = new PriorityQueue<>((int[] a, int[] b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            else {
                return a[1] - b[1];
            }
                
        });
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
//        System.out.println(Arrays.deepToString(jobs));
        
        int answer = 0;
        int jobCount = 0;
        int workDoneTick = 0;
        boolean isWorking = false;
        int[] workingDisk = null;
        int tick = 0;
        int pid = 0;
        while(jobCount < jobs.length) {
        	while (pid < jobs.length && tick >= jobs[pid][0]) {
        		readyQ.add(jobs[pid]);
        		pid++;
        	}
        	
            // tick 마다 진행도 체크
            if (workingDisk != null && tick >= workDoneTick) {
                isWorking = false;
                answer += (tick - workingDisk[0]);
                workingDisk = null;
                jobCount++;
//                System.out.println("tick : " + tick + " answer : " + answer);
                if (jobCount >= jobs.length) break;
            }
            
            // 디스크 놀고있으면
            if (!isWorking) {
                // 레디큐에 일할시간이 지난 프로세스가 있다면
                if (!readyQ.isEmpty() && readyQ.peek()[0] <= tick) {
                    isWorking = true;
                    workingDisk = readyQ.poll();
                    workDoneTick = tick += workingDisk[1];
                    continue;
                }
                // 아직 일할 프로세스가 없다면
                tick++;
                continue;
                
            }
            // 일하고 있는 프로세스가 있다면
            tick++;
        }
        
//        System.out.println(answer / jobs.length);
        return answer / jobs.length;
    }
}