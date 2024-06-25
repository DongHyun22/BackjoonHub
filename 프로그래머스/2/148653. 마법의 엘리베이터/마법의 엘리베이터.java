class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0) {
            int temp = storey % 10;
            storey /= 10;
            
            if(temp == 5) {
                int f = storey % 10;
                if(f >= 5) {
                    storey += 1;
                    answer += temp;
                }
                else {
                    answer += temp;
                }
            }
            else if(temp > 5) {
                answer += (10 - temp);
                storey += 1;
            }
            else {
                answer += temp;
            }
        }
        return answer;
    }
}