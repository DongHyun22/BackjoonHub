import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        int pre = -1;
        for(int i = 0; i < arr.length; i++) {
            if(pre == arr[i]) {
                continue;
            }
            pre = arr[i];
            list.add(arr[i]);
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}