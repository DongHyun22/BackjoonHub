class Solution {
    public static int[] solution(String s) {
        int[] answer = new int[2];
        int zero = 0;
        int count = 0;
        while(!s.equals("1")){
            count++;
            // s의 0 제거
            while(s.contains("0")){
                zero++;
                s = s.replaceFirst("0", "");
            }
            // s의 길이 저장
            int length = s.length();
            // 값을 이진으로 변경
            s = Integer.toBinaryString(length);
        }
        answer[0] = count;
        answer[1] = zero;
        return answer;
    }
}