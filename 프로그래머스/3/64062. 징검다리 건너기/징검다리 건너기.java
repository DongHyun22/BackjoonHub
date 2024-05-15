class Solution {
    static int[] stones;
    static int k;
    public int solution(int[] stones, int k) {
        int answer = 0;
        this.stones = stones.clone();
        this.k = k;
        
        int min = 1;
        int max = 200000000;
        
        int mid = 0;
        while(min <= max) {
            mid = (max + min) / 2;
            
            if(cross(mid)) {
                // 건널 수 있으면
                min = mid + 1;
                answer = Math.max(answer, mid);
            }
            else {
                // 건널 수 없을 떄
                max = mid - 1;
            }
            
        }
        
        return answer;
    }
    public boolean cross(int mid) {
        int cnt = 0;
        boolean flag = true;
        
        for(int i = 0; i < stones.length; i++) {
            int num = stones[i];
            if(num < mid) {
                cnt++;
                if(cnt == k) {
                    flag = false;
                    break;
                }
            }
            else {
                cnt = 0;
            }
        }
        
        return flag;
    }
}