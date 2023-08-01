class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        if(arr.length == 1){
            return arr[0];
        }
        int num = arr[0];
        for(int i = 1; i < arr.length; i++){
            int gcd = 0;
            if(num > arr[i])
                gcd = gcd(num, arr[i]);
            else
                gcd = gcd(arr[i],num);
            num = (num * arr[i]) / gcd;
        }
        return num;
    }
    public int gcd(int a, int b){
        while(b!=0){
            int num = a % b;
            a = b;
            b = num;        
        }
        return a;
    }
}