import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> s = new Stack();
        int answer = 0;
        for(int i = 0; i < ingredient.length; i++) {
            s.push(ingredient[i]);
            int size = s.size();
            if(size >= 4) {
                if(s.get(size-1) == 1
                   && s.get(size-2) == 3
                   && s.get(size-3) == 2
                   && s.get(size-4) == 1) {
                    answer++;
                    s.pop();
                    s.pop();
                    s.pop();
                    s.pop();
                }
            }
        }
        
        return answer;
    }
}