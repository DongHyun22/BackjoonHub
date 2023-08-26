import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int seq = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : priorities){
            pq.add(i);
        }
        while(!(pq.isEmpty())){
            for(int i = 0; i < priorities.length; i++){
                if(priorities[i] == pq.peek()){
                    if(location == i){
                        seq++;
                        return seq++;
                    }
                    pq.poll();
                    seq++;
                }
            }
        }
        return seq;
    }
}