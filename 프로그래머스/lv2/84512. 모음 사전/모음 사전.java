class Solution {
    static int answer = 0;
    static int count = 0;
    static char[] tem = new char[] {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        char[] array = new char[5];
        per(word, array, 0);
        return answer;
    }
    public void per(String word, char[] array, int size) {
        if(size > 4) {
            return;
        }
        for(int i = 0; i < 5; i++){
            array[size] = tem[i];
            count++;
            String temp = "";
            for(int j = 0; j <= size; j++){
                temp += array[j];
            }
            if(temp.equals(word)) {
                answer = count;
                return;
            }
            per(word, array, size + 1);
        }
    }
}