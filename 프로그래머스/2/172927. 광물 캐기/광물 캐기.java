import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int count = Math.min(minerals.length / 5 + 1, picks[0] + picks[1] + picks[2]);
        int[][] section = new int[count][3];
        
        for(int i = 0; i < minerals.length; i += 5) {
            int dx = 0;
            int ix = 0;
            int sx = 0;
            if(i / 5 == count)
                break;
            for(int j = i; j < i + 5; j++) {
                String s = minerals[j];
                if(s.equals("diamond")) {
                    dx += 1;
                    ix += 5;
                    sx += 25;
                }
                else if(s.equals("iron")) {
                    dx += 1;
                    ix += 1;
                    sx += 5;
                }
                else {
                    dx += 1;
                    ix += 1;
                    sx += 1;
                }
                if(j == minerals.length - 1) {
                    break;
                }
            }
            
            section[i/5][0] = dx;
            section[i/5][1] = ix;
            section[i/5][2] = sx;
        }
        
        Arrays.sort(section, (o1, o2) -> (o2[2] - o1[2]));
        
        for(int i = 0; i < count; i++) {
            if(picks[0] != 0) {
                answer += section[i][0];
                picks[0]--;
            }
            else if(picks[1] != 0) {
                answer += section[i][1];
                picks[1]--;
            }
            else {
                answer += section[i][2];
                picks[2]--;
            }
        }
        
        return answer;
    }
}