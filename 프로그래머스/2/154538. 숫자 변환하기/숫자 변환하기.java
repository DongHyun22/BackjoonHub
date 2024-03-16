class Solution {
    int[] s;
    public int solution(int x, int y, int n) {
        int answer = 0;
        s = new int[5000000];
        s[x] = 0;
        s[x+n] = 1;
        s[x * 2] = 1;
        s[x * 3] = 1;
        for(int i = x + 1; i < y + 1; i++) {
            if(s[i] == 0)
                continue;
            if(s[i+n] == 0 || i + n < y && s[i] + 1 < s[i+n])
                s[i+n] = s[i] + 1;
            if(s[i*2] == 0 || i * 2 < y && s[i] + 1 < s[i * 2])
                s[i * 2] = s[i] + 1;
            if(s[i*3] == 0 || i * 3 < y && s[i] + 1 < s[i * 3])
                s[i * 3] = s[i] + 1;
        }
        answer = s[y];
        if(s[y] == 0)
            answer = -1;
        if(x == y)
            answer = 0;
        return answer;
    }
}