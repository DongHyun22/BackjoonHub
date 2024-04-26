import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        for(int i = 0; i < n; i++) {
            if(pq.isEmpty())
                return 0;
            int temp = pq.poll();
            temp--;
            if(temp == 0)
                continue;
            pq.add(temp);
        }
        int size = pq.size();
        for(int i = 0; i < size; i++) {
            long temp = pq.poll();
            answer += temp * temp;
        }
        return answer;
    }
}