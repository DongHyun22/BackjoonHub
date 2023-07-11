import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> {return o1[1] - o2[1];});

        // 오름차순
        int end = -1;
        for(int [] i : targets){
            if(end == -1){
                answer++;
                end = i[1]-1;
                continue;
            }
            if(end >= i[0])
                continue;
            answer++;
            end = i[1]-1;
        }
        return answer;
    }
}