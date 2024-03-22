import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = Integer.MAX_VALUE;
        Arrays.sort(times);
        int l = times.length;
        long left = 0;
        long right = times[l - 1] * (long)n;
        while(left <= right) {
            long mid = (left + right) / 2;
            long tmp = 0;
            for(int i = 0; i < l; i++) {
                tmp += mid / times[i];
            }
            if(tmp < n) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
                
                answer = mid;
            }
        }
        
        return answer;
    }
}