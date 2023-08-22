import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = speeds.length - 1; i >= 0; i--){
            int rest = 100 - progresses[i];
            int day = (int)Math.ceil(rest / (double)speeds[i]);
            stack.push(day);
        }
        int max = stack.peek();
        int num = 0;
        while(true) {
            if(stack.empty()){
                list.add(num);
                break;
            }
            int temp = stack.pop();
            if(max >= temp){
                num++;
                continue;
            }
            else {
                max = temp;
                list.add(num);
                num = 1;
                continue;
            }
        }
        return list;
    }
}