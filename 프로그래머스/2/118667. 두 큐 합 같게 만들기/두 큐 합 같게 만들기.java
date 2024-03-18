import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long one_sum = 0;
        long two_sum = 0;
        Queue<Integer> one_q = new ArrayDeque<>();
        Queue<Integer> two_q = new ArrayDeque<>();
        int l = queue1.length;
        for(int i = 0; i < l; i++) {
            one_q.add(queue1[i]);
            two_q.add(queue2[i]);
            one_sum += queue1[i];
            two_sum += queue2[i];
        }
        
        while(one_sum != two_sum) {
            if(answer > 3 * l - 3)
                return -1;
            if(one_sum > two_sum) {
                int one = one_q.poll();
                two_q.add(one);
                one_sum -= one;
                two_sum += one;
            }
            else if(one_sum < two_sum) {
                int two = two_q.poll();
                one_q.add(two);
                two_sum -= (long)two;
                one_sum += two;
            }
            answer++;
        }
        return answer;
    }
}