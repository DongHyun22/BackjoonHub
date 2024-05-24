import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int cnt = 0;
        
        // 요청시점 오름차순
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        // 소요시간 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int num = 0;
        int time = 0;
        while(cnt < jobs.length) {
            while(num < jobs.length && jobs[num][0] <= time) {
                pq.add(jobs[num++]);
            }
            
            if(pq.isEmpty()) {
                time = jobs[num][0];
            }
            else {
                int[] temp = pq.poll();
                answer += time + temp[1] - temp[0];
                cnt++;
                time += temp[1];
            }
        }
        
        answer /= cnt;
        
        return answer;
    }
}