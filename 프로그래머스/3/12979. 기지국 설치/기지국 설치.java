class Solution {
    static int n;
    static int w;
    static int[][] ex;
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        this.n = n;
        this.w = w;
        ex = new int[stations.length][2];
        for(int i = 0; i < stations.length; i++) {
            ex[i][0] = stations[i] - w - 1 < 0 ? 0 : stations[i] - w - 1;
            ex[i][1] = stations[i] + w - 1 > n ? n-1 : stations[i] + w - 1;
        }
        
        int loc = 0;
        int num = 0;
        while(loc < n) {
            // 계산할 구간 구하기
            int a = loc;
            int b = loc + w * 2;
            // 앞자리가 ex[0] 뒤에 있으면 ex[1]을 loc으로 지정
            if(num < ex.length && a >= ex[num][0]) {
                loc = ex[num][1] + 1;
                num++;
                continue;
            }
            
            // 없으면 answer 추가 및 loc 변경 후 진행
            answer++;
            loc = b + 1;
        }

        return answer;
    }
}