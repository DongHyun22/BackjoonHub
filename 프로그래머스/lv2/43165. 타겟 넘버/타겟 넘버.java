class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, numbers.length, target, 0, 0);
        return answer;
    }
    public static void dfs(int[] numbers, int length, int target, int count, int sum){
        if(count == length){
            if(sum == target)
                answer++;
            return;
        }
        dfs(numbers, length, target, count + 1, sum + numbers[count]);
        dfs(numbers, length, target, count + 1, sum - numbers[count]);
    }
}