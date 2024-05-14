import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        // 총 갯수 구하기
        int kind = new HashSet<>(Arrays.asList(gems)).size();
        
        
        HashMap<String, Integer> map = new HashMap<>();
        int l = Integer.MAX_VALUE;
        int start = 0;
        // 투포인터로 한칸 씩 탐색
        for(int end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            
            while(map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            if(kind == map.size() && l > end - start) {
                l = end - start;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
        }
        
        
        
        return answer;
    }
}