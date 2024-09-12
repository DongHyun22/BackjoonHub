import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        int answer = 0;
        ArrayList<int[]> list = new ArrayList<>();
        int n = food_times.length;
        
        // { index, time }
        for(int i = 0; i < n; i++) {
            list.add(new int[]{i + 1, food_times[i]});
        }
        Collections.sort(list, (o1, o2) -> o1[1] - o2[1]);
        
        long nowTime = 0;
        int index = 0;
        int l = n;
        
        for(int i = 0; i < n; i++) {
            int cur = list.get(i)[1];
            // 다 먹고 남은 갯수 * 먹는 시간 
            if(cur - nowTime != 0) {
                long total = (cur - nowTime) * l;
                if(total <= k) {
                    nowTime = cur;
                    k -= total;
                }
                else {
                    // index안의 음식들 중에 장애가 끝나고 먹을 음식이 존재
                    k %= l;
                    list.subList(index, n).sort((o1, o2) -> o1[0] - o2[0]);
                    return list.get(index + (int)k)[0];
                }
            }
            index++;
            l--;
        }
        return -1;
    }
}