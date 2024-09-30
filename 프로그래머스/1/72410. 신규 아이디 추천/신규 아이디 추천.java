import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        char[] arr = new_id.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        
        for(char c : arr) {
            list.add(c);
        }
        // 1. 대문자 -> 소문자
        list.replaceAll(Character::toLowerCase);
        
        // 2. 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 글자 제거
        for(int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                continue;
            }
            
            list.remove(i);
            i--;
        }
        // 3. 마침표가 2번 이상 연속되면 하나의 마침표로 치환
        boolean flag = false;
        for(int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            if(c == '.') {
                if(!flag) {
                    flag = true;
                    continue;
                }
                else {
                    list.remove(i);
                    i--;
                    continue;
                }
            }
            else {
                flag = false;
            }
        }
        
        // 4. 마침표가 처음이나 끝이면 제거
        if(!list.isEmpty() && list.get(0) == '.') {
            list.remove(0);
        }
        
        if(!list.isEmpty() && list.get(list.size() - 1) == '.') {
            list.remove(list.size() - 1);
        }
        
        // 5. 빈 문자열이면 "a" 대입
        if(list.isEmpty()) {
            list.add('a');
        }
        
        // 6. 16자 이상이면 15자만 남기기, 마지막 마침표 없애기
        if(list.size() >= 16) {
            list.subList(15, list.size()).clear();
        }
        if(!list.isEmpty() && list.get(list.size() - 1) == '.') {
            list.remove(list.size() - 1);
        }
        
        // 7. 2자 이하면, 마지막 문자를 끝에 붙여 길이 3만들기
        while(list.size() < 3) {
            list.add(list.get(list.size() - 1));
        }
        
        for(char c : list)
            answer += c;
        
        
        return answer;
    }
}