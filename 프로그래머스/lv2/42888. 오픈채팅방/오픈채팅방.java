import java.util.*;
class Solution {
    public ArrayList<String> solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, String> member = new HashMap<>();
        ArrayDeque<String> q = new ArrayDeque<>();
        // 닉네임 변경
        // 0. 입장
        // 1. 떠나기
        for(int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" ");
            if(s[0].equals("Enter")){
                member.put(s[1], s[2]);
                q.add("0" + s[1]);
            }
            else if(s[0].equals("Leave")){
                q.add("1" + s[1]);
            }
            else{
                member.put(s[1], s[2]);
            }
        }
        for(String s : q) {
            String check = s.substring(0, 1);
            String name = member.get(s.substring(1));
            if(check.equals("0")){
                answer.add(name + "님이 들어왔습니다.");
            }
            else{
                answer.add(name + "님이 나갔습니다.");
            }
        }
        return answer;
    }
}