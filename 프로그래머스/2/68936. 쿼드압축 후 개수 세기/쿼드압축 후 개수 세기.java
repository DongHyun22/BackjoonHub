class Solution {
    static int[][] map;
    static int[] answer;
    static int l;
    public int[] solution(int[][] arr) {
        l = arr.length;
        map = new int[l][l];
        answer = new int[2];
        for(int i = 0; i < l; i++) {
            for(int j = 0; j < l; j++) {
                map[i][j] = arr[i][j];
            }
        }
        if(l == 2) {
            if(map[0][0] == map[0][1] && map[0][1] == map[1][0] && map[1][0] == map[1][1]) {
                answer[map[0][0]]++;
            }
            else {
                plus(map[0][0]);
                plus(map[0][1]);
                plus(map[1][0]);
                plus(map[1][1]);
            }
            return answer;
        }
        int num = calc(0, 0, l);
        if(num != 3)
            answer[num]++;
        return answer;
    }
    public static int calc(int x, int y, int size) {
        if(size == 1) {
            return map[x][y];
        }
        int d = size / 2;
        int one = calc(x, y, d);
        int two = calc(x + d, y, d);
        int three = calc(x, y + d, d);
        int four = calc(x + d, y + d, d);
        
        if(size == 2) {
            if(one == two && one == three && one == four) {
                return one;
            }
            else {
                plus(one);
                plus(two);
                plus(three);
                plus(four);
                return 3;
            }
        }
        
        if(one == two && one == three && four == one) {
            return one;
        }
        else {
            plus(one);
            plus(two);
            plus(three);
            plus(four);
            return 3;
        }
        
    }
    
    public static void plus(int num) {
        if(num == 3)
            return;
        answer[num]++;
    }
}