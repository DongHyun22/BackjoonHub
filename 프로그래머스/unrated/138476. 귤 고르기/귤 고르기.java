import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 1;
        int[] num = new int[10000001];
        for(int i : tangerine){
            num[i]++;
        }
        Arrays.sort(num);
        for(int i = num.length-1; i > 0; i--){
            if(num[i] >= k) {
                break;
            }
            else{
                k -= num[i];
                answer++;
            }
        }
        return answer;
    }
}