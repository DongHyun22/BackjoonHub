class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        int n = sequence.length;
        long[] dpa = new long[n];
        int[] a = pulse(sequence.clone(), true);
        
               
        
        dpa[0] = Math.max(answer, a[0]);
        for(int i = 1; i < n; i++) {
            if(a[i] > dpa[i-1] + a[i]) {
                dpa[i] = a[i];
            }
            else {
                dpa[i] = dpa[i-1] + a[i];
            }
        }
        
        long[] dpb = new long[n];
        int[] b = pulse(sequence.clone(), false);
        
         
        
        dpb[0] = Math.max(answer, b[0]);
        for(int i = 1; i < n; i++) {
            if(b[i] > dpb[i-1] + b[i]) {
                dpb[i] = b[i];
            }
            else {
                dpb[i] = dpb[i-1] + b[i];
            }
        }
        // for(int i = 0; i < n; i++) {
        //     System.out.println(b[i] + " " + dpb[i]);
        // }
        // System.out.println();
        
        
        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, Math.max(dpa[i], dpb[i]));
        }
        
        return answer;
    }
    
    
    
    public int[] pulse(int[] arr, boolean check) {
        int num = 0;
        if(check)
            num = 1;
        else
            num = -1;
        
        for(int i = 0; i < arr.length; i++) {
            arr[i] *= num;
            num *= -1;
        }
        
        return arr;
    }
}