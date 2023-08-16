import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length;i++){
            map.put(want[i], number[i]);
        }
        for(int i = 0; i < 10; i++){
            String num = discount[i];
            if(map.containsKey(num)){
                map.put(num, map.get(num) - 1);
            }
        }
        boolean flag = true;
        for(String s : map.keySet()){
            if(map.get(s) > 0){
                flag = false;
                break;
            }
        }
        if(flag){
            answer++;
        }
        for(int i = 0; i < discount.length - 10; i++){
            flag = true;
            String first = discount[i];
            String end = discount[i+10];
            if(map.containsKey(first)){
                map.put(first, map.get(first) + 1);
            }
            if(map.containsKey(end)){
                map.put(end, map.get(end) - 1);
            }
            for(String s : map.keySet()){
                if(map.get(s) > 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer++;
            }
        }
        
        return answer;
    }
}