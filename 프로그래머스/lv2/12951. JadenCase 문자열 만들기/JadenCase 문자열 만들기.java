class Solution {
    public String solution(String s) {
        String answer = "";
        char[] temp = s.toCharArray();
        if(temp[0] >= 97 && temp[0] <= 122){
            answer += (char)(temp[0] - 32);
        }
        else{
            answer += temp[0];
        }
        boolean flag = false;
        // 플래그에 따라서
        for(int i = 1; i < s.length(); i++){
            if(temp[i] == ' '){
                answer += temp[i];
                flag = true;
                continue;
            }
            if(flag){
                if(temp[i] >= 97 && temp[i] <= 122){
                    answer += (char)(temp[i] - 32);
                }
                else{
                    answer += temp[i];
                }
                flag = false;
                continue;
            }
            if(temp[i] >= 65 && temp[i] <= 90){
                answer += (char)(temp[i] + 32);
                continue;
            }
            answer += temp[i];
        }
        return answer;
    }
}