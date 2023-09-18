import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = numbers.length - 1; i >= 0; i--) {
            int num = numbers[i];
            boolean flag = true;
            while(!stack.empty()) {
                int temp = stack.peek();
                if(temp > num) {
                    answer[i] = temp;
                    flag = false;
                    break;
                }
                stack.pop();
            }
            if(stack.empty() && flag) {
                answer[i] = -1;
            }
            stack.push(num);
            
        }
        return answer;
    }
}