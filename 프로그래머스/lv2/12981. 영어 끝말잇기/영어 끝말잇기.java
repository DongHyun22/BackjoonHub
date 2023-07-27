import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(0, words[0]);
        for(int i = 1; i < words.length; i++){
            String s = words[i-1];
            System.out.println(s);
            if(map.containsValue(words[i]) || words[i-1].charAt(s.length() - 1) != words[i].charAt(0)){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            map.put(i, words[i]);
        }

        return answer;
    }
}