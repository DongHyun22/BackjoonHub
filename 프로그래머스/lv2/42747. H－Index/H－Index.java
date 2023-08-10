class Solution {
    public int solution(int[] citations) {
        int max = 0;
        for(int i = 0; i <= citations.length; i++){
            int count = 0;
            for(int j = 0; j < citations.length; j++){
                if(i <= citations[j]){
                    count++;
                }
            }
            if(i <= count && i >= citations.length - count){
                max = Math.max(i, max);
            }
        }
        return max;
    }
}