class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int l = triangle.length;
        int[][] sumTri = new int[l + 1][l + 1];
        if(l == 1) {
            return triangle[0][0];
        }
        else if(l == 2) {
            return triangle[0][0] + Math.max(triangle[1][0], triangle[1][1]);
        }
        
        for(int i = 0; i < l; i++) {
            sumTri[l-1][i] = triangle[l-1][i];
        }
        for(int i = l - 2; i >= 0; i--) {
            for(int j = 0; j < i + 1; j++) {
                sumTri[i][j] = triangle[i][j] + Math.max(sumTri[i+1][j], sumTri[i+1][j + 1]);
            }
        }
        return sumTri[0][0];
    }
}