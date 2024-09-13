import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        ArrayList<Integer> list = new ArrayList<>();
        int oneC = 0;
        int twoC = 0;
        int threeC = 0;
        for(int i = 0; i < answers.length; i++) {
            int num = answers[i];
            if(one[i % one.length] == num) {
                oneC++;
            }
            if(two[i % two.length] == num) {
                twoC++;
            }
            if(three[i % three.length] == num) {
                threeC++;
            }
        }
        int max = 0;
        if(max <= oneC) {
            max = oneC;
            list = new ArrayList<>();
            list.add(1);
        }
        if(max < twoC) {
            max = twoC;
            list = new ArrayList<>();
            list.add(2);
        }
        else if(max == twoC) {
            list.add(2);
        }
        if(max < threeC) {
            max = threeC;
            list = new ArrayList<>();
            list.add(3);
        }
        else if(max == threeC) {
            list.add(3);
        }
        
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}