import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(new String(arr));
        String s = sb.reverse().toString();
        answer = Long.parseLong(s);
        return answer;
    }
}