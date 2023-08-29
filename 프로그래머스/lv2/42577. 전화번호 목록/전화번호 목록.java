import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, String> map = new HashMap<>();
        for(String s : phone_book){
            map.put(s, "");
        }
        for(String s : phone_book) {
            for(int i = 1; i < s.length(); i++) {
                String temp = s.substring(0, i);
                if(map.containsKey(temp)){
                    answer = false;
                    break;
                }
            }
            if(!answer)
                break;
        }
        return answer;
    }
}