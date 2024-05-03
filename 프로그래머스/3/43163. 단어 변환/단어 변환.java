
class Solution {
    static String target;
    static String[] words;
    static int min = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        this.target = target;
        this.words = words.clone();
        dfs(begin, 0, new boolean[words.length]);
        if(min == Integer.MAX_VALUE) {
            answer = 0;
        }
        else {
            answer = min;
        }
        return answer;
    }
    public void dfs(String s, int count, boolean[] visited) {
        if(s.equals(target)) {
            min = Math.min(min, count);
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(!visited[i] && check(s, words[i])) {
                visited[i] = true;
                dfs(words[i], count + 1, visited);
                visited[i] = false;
            }
        }
        
    }
    
    // 한 개의 알파벳만 바꿀 수 있는지 판단하는 함수
    public boolean check(String s, String w) {
        char[] s_arr = s.toCharArray();
        char[] w_arr = w.toCharArray();
        boolean flag = false;
        for(int i = 0; i < s.length(); i++) {
            if(s_arr[i] != w_arr[i]) {
                if(flag)
                    return false;
                flag = true;
            }
        }
        return flag;
    }
}