class Solution {
    public long solution(int w, int h) {
        long g = gcd(w, h);
        long answer = (long)w * h - (w / g + h / g - 1) * g;
        
        
        return answer;
    }
    
    public long gcd(int n, int m) {
        while(m != 0) {
            int r = n % m;
            
            n = m;
            m = r;
        }
        
        return n;
    }
}