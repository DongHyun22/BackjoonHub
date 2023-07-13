class Solution {
    static int answer;

    static public int solution(int n) {
        answer = 0;
        int[] chess = new int[n + 2];
        q(1, chess, n);


        System.out.println(answer);
        return answer;
    }

    public static void q(int count, int[] chess, int n) {

        for (int i = 1; i < count - 1; i++) {
            if (check(i, chess[i], count - 1, chess[count - 1])) {
                return;
            }
        }

        if (count > n) {
            answer++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            chess[count] = i;
            q(count + 1, chess, n);
        }
    }

    public static boolean check(int nx, int ny, int x, int y) {
        if (ny == y || x - nx == Math.abs(y - ny)) {
            return true;
        }
        return false;
    }
}