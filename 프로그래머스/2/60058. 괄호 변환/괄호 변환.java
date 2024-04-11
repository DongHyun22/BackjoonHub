import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = calc(p);
        return answer;
    }
    
    public String calc(String s) {
        // 1. 빈문자열 판단, 2. 올바른 괄호 판단
        if(s.equals("") || correct(s))
            return s;
        
        // 3. 분리
        
        int stand = div(s);
        String u = s.substring(0, stand);
        String v = s.substring(stand);
        
        // v를 먼저 수행 => q
        String q = calc(v);
        
        // 4. u 올바른 괄호 판단
        if(correct(u)) {
            // 4-1. 맞으면 v를 1단계부터 수행 후 u에 붙혀 리턴
            return u + q;
        }
        // a. 빈문자열에 ( 추가 + q 추가 + ) 추가 => r 
        // b. u의 첫번째와 마지막 제거 후 뒤집고 r에 붙히고 리턴
        String r = "(" + q + ")" + reverseBra(u);
        
        return r;
    }
    public boolean correct(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if(c == '(') {
                stack.push(c);
            }
            else if(stack.isEmpty()) {
                return false;
            }
            else {
                stack.pop();
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
    public int div(String s) {
        for(int i = 0; i < s.length()-1; i+=2) {
            String tmp = s.substring(0, i+2);
            if(balance(tmp)) {
                return i+2;
            }
        }
        System.out.println("분리 오류 발생");
        return 2;
    }
    public boolean balance(String s) {
        char[] c = s.toCharArray();
        int left = 0;
        int right = 0;
        for(int i = 0; i < c.length; i++) {
            if(c[i] == '(')
                left++;
            else
                right++;
        }
        if(left == right)
            return true;
        return false;
    }
    public String reverseBra(String s) {
        s = s.substring(1, s.length()-1);
        char[] arr = s.toCharArray();
        String tmp = "";
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '(')
                tmp += ')';
            else
                tmp += '(';
        }
        return tmp;
    }
}