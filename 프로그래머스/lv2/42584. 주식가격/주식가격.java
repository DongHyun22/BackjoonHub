class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        // 자기보다 큰 수만큼 리턴
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if(prices[i] > prices[j])
                    break;
                
            }
        }
        return answer;
    }
}