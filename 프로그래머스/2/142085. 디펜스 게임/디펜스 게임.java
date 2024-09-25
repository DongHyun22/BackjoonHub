import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        
        for(int i = 0; i < enemy.length; i++) {
            if(pq.size() < k) {
                pq.add(enemy[i]);
                count++;
                continue;
            }
            
            int e = enemy[i];
            if(pq.peek() < e) {
                n -= pq.peek();
                pq.poll();
                pq.add(e);
            }
            else {
                n -= e;
            }
            
            if(n < 0) {
                break;
            }
            else {
                count++;
            }
        }
        
        return count;
    }
}