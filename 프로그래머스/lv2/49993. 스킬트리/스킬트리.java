import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String s : skill_trees) {
            ArrayDeque <Character> q = new ArrayDeque<>();
        for(int i = 0; i < skill.length(); i++) {
            q.offer(skill.charAt(i));
        }
            boolean flag = true;
            for(int i = 0; i < s.length(); i++) {
                if(q.isEmpty()) {
                    break;
                }
                char c = s.charAt(i);
                
                if(c == q.peek()) {
                    q.poll();
                    continue;
                }
                if(q.contains(c)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.println(s);
                answer++;
            }
        }
        return answer;
    }
}