class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        int a = 3;
        int b = 0;
        
        while(true){
            b = sum / a;
            if(sum % a == 0 && b >= 3){
                int x = Math.max(a, b);
                int y = Math.min(a, b);
                if((x-2)*(y-2) == yellow){
                    answer[0] = x;
                    answer[1] = y;
                    break;
                }
            }
            a++;
        }
        return answer;
    }
}