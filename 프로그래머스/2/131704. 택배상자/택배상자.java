import java.util.*;

class Solution {
    public int solution(int[] order) {
        int truck = 0;
        int main = 1;
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < order.length; i++) {
            int num = order[i];
            if(!stack.empty() && stack.peek() == num) {
                stack.pop();
                truck++;
                continue;
            }
            if(main == num) {
                main++;
                truck++;
                continue;
            }
            else {
                stack.push(main);
                main++;
                if(main > order.length)
                    break;
                i--;
            }
        }
        // 보조컨테이너 - 스택
        return truck;
    }
}