class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int num = 0;
        int seq = 0;
        int count = 0;
        while(count < t) {
            String b = Integer.toString(num, n);
            for(int i = 0; i < b.length(); i++){
                char c = b.charAt(i);
                if(97 <= c && c <= 122){
                    c -= 32;
                }
                if(seq % m == p - 1) {
                    answer += c;
                    count++;
                }
                seq++;
                if(count >= t){
                    break;
                }
            }
            num++;
        }
        return answer;
    }
}