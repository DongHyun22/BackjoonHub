import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 1; i <= 26; i++){
            map.put(String.valueOf((char)('A' + i - 1)), i);
        }
        String temp = "";
        String start = "";
        for(int i = 0; i < msg.length(); i++){
            start = msg.substring(i, i+1);
            if(map.containsKey(temp + start)){
                if(i == msg.length() - 1){
                    answer.add(map.get(temp + start));
                }
                temp += start;
            }
            else {
                answer.add(map.get(temp));
                map.put(temp + start, map.size() + 1);
                temp = start;
                if(i == msg.length() - 1){
                    answer.add(map.get(start));
                }
            }
        }
        return answer;
    }
}