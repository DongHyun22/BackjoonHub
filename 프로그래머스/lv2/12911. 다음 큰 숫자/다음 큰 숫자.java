


class Solution {
    public long solution(int n) {
        int answer = 0;
        int origin = Integer.bitCount(n);
        while(true){
            n++;
            int num = Integer.bitCount(n);
            if(origin == num){
                return n;
            }
        }
    }
}