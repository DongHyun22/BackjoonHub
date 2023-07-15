import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();
        char[] array = s.toCharArray();
        for(char c : array){
            if(c == '('){
                st.push(c);
            }
            else{
                if(st.isEmpty()){
                    answer = false;
                    break;
                }
                st.pop();
            }
        }
        if(!st.isEmpty()){
            answer = false;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}