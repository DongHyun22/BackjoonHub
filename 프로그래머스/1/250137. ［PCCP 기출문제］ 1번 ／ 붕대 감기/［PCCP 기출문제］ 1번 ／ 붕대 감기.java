class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int monster = 0;
        int cnt = 0;
        int cur = health;
        int time = attacks[attacks.length-1][0];
        for(int i = 1; i <= time; i++) {
            // 몬스터 공격
            if(attacks[monster][0] == i) {
                cur -= attacks[monster][1];
                if(cur <= 0) {
                    cur = -1;
                    break;
                }
                cnt = 0;
                monster++;
                continue;
            }
            
            // 공격 아닐시 붕대질
            if(cur >= health)
                continue;
            cur += bandage[1];
            cnt++;
            if(cnt == bandage[0]) {
                cur += bandage[2];
                cnt = 0;
            }
            if(cur >= health)
                cur = health;
        }
        
        return cur;
    }
}