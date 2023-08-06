import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        for(int i = 0; i < length; i++){
            Stack<Character> stack = new Stack<>();
            
            boolean flag = true;
            for(int j = 0; j < length; j++) {
                char c = s.charAt(j);
                
                if(c == '(' || c == '{' || c == '['){
                    stack.push(c);
                }
                else{
                    if(stack.empty()){
                        flag = false;
                        break;
                    }
                    char temp = stack.pop();
                    if(!(temp == '(' && c == ')' || temp == '{' && c == '}' || temp == '[' && c == ']')){
                        flag = false;
                        break;
                    }
                }
            }
            if(stack.empty() && flag){
                answer++;
            }
            String temp = s.substring(0, 1);
            s = s.substring(1, length);
            s += temp;
        }
        return answer;
    }
}