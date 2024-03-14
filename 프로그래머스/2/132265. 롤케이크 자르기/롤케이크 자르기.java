import java.util.*;

class Solution {
    static int answer;
    public int solution(int[] topping) {
        int[] total = new int[10001];
        HashSet<Integer> my = new HashSet<>();
        for(int num : topping) {
            total[num]++;
        }
        int size = 0;
        for(int i = 0; i < total.length; i++) {
            if(total[i] != 0) {
                size++;
            }
        }
        for(int num : topping) {
            my.add(num);
            total[num]--;
            if(total[num] == 0) {
                size--;
            }
            if(my.size() == size) {
                answer++;
            }
        }
        return answer;
    }
}