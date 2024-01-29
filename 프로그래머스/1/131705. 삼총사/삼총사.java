class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int one = 0;
        int two = 0;
        int thr = 0;
        for(int i = 0; i < number.length; i++) {
            one = number[i];
            for(int j = i+1; j < number.length; j++) {
                two = number[j];
                for(int k = j+1; k < number.length; k++) {
                    thr = number[k];
                    if(one + two + thr == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}