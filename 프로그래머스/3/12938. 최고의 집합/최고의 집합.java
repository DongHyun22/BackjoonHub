class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int a = s / n;
        int b = s % n;
        if(a == 0)
            return new int[]{-1};
        for(int i = 0; i < n; i++) {
            if(i >= n - b)
                answer[i] = a+1;
            else
                answer[i] = a;
        }
        return answer;
    }
}