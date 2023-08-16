import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length;i++){
            map.put(want[i], number[i]);
        }
        for(int i = 0; i < 10; i++){
            if(map.containsKey(discount[i])){
                map.put(discount[i], map.get(discount[i]) - 1);
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
            if(map.containsKey(discount[i])){
                map.put(discount[i], map.get(discount[i]) + 1);
            }
            if(map.containsKey(discount[i+10])){
                map.put(discount[i+10], map.get(discount[i+10]) - 1);
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