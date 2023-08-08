import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        for(int i = 1 ; i <= elements.length; i++){
            for(int j = 0; j < elements.length; j++){
                int sum = 0;
                int num = j;
                for(int k = 0; k < i; k++){
                    if(num >= elements.length){
                        num = 0;
                    }
                    sum += elements[num++];
                }
                set.add(sum);
            }
        }
        int answer = set.size();
        return answer;
    }
}