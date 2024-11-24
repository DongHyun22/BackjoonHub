

/* 
 * 이동하기 / 실버2 / 40분
 * https://www.acmicpc.net/problem/11048
 */
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int result;

		int[][] matrix = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		int dp[][] = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1])) + matrix[i][j];
			}

		}

//		for(int i = 1; i <= n; i++) {
//			for(int j = 1; j <= m; j++) {
//				if(i == 1 && j == 1) {
//					dp[i][j] = matrix[1][1];
//				}
//				else if(i == 1) {
//					dp[i][j] = dp[i][j-1] + matrix[i][j];
//				}
//				else if(j == 1) {
//					dp[i][j] = dp[i-1][j] + matrix[i][j];
//				}
//				else {
//					dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j-1], dp[i-1][j-1])) + matrix[i][j];
//				}
//			}
//		}
		System.out.println(dp[n][m]);
	}
}
