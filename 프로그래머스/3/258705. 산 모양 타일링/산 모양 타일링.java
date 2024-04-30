class Solution {
    static int[] a;
    static int[] b;
    public int solution(int n, int[] tops) {
        int answer = 0;
        a = new int[n];
        b = new int[n];
        a[0] = 1;
        if(tops[0] == 1)
            b[0] = 3;
        else
            b[0] = 2;
        
        for(int i = 1; i < n; i++) {
            a[i] = (a[i-1] + b[i-1]) % 10007;
            if(tops[i] == 1) {
                b[i] = (a[i-1] * 2 + b[i-1] * 3) % 10007;
            }
            else {
                b[i] = (a[i-1] + b[i-1] * 2) % 10007;
            }
            
        }
        answer = (a[n-1] + b[n-1]) % 10007;
        return answer;
    }
}