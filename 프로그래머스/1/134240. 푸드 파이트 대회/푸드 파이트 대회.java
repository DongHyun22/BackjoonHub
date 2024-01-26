class Solution {
    public String solution(int[] food) {
        String answer = "";
        String temp = "";
        for(int i = 1; i < food.length; i++) {
            int n = food[i];
            n /= 2;
            for(int j = 0; j < n; j++) {
                temp += i;
            }
        }
        answer = temp;
        answer += "0";
        for(int i = temp.length()-1; i >= 0; i--) {
            answer += temp.charAt(i);
        }
        
        return answer;
    }
}