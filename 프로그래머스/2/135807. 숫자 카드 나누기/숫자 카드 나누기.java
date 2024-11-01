class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }
        for(int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        if(calc(arrayA, gcdB)) {
            answer = Math.max(answer, gcdB);
        }
        if(calc(arrayB, gcdA)) {
            answer = Math.max(answer, gcdA);
        }
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        if(a % b == 0)
            return b;
        return gcd(b, a % b);
    }
    public boolean calc(int[] array, int gcd) {
        // 나눌 수 있으면 false 후 리턴
        for(int i = 0; i < array.length; i++) {
            if(array[i] % gcd == 0) {
                return false;
            }
        }
        return true;
    }
}