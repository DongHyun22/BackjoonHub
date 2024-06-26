import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] matrix;
	static int[][] test;
	static boolean[][] visited;
	static int safe = 0;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	// 2. 지도에서 0인 부분 중 3칸을 선택해 벽을 세움
	// 3. 벽을 세운 후 바이러스를 퍼트려 안전영역 구한 후 최댓값 구하기
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		matrix = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(safe);
	}

	static void comb(int count, int start) {
		if (count == 3) {
			test = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					test[i][j] = matrix[i][j];
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(test[i][j] == 2 && visited[i][j] == false) {
						// visited 함수는 바이러스가 퍼트린 곳인지 알수있는 함수
						virus_bfs(i, j);
					}
				}
			}
			visited = new boolean[n][m];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(test[i][j] == 0) {
						sum++;
					}
				}
			}
			safe = Math.max(safe, sum);
			return;
		}

		for (int i = start; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 1 || matrix[i][j] == 2) {
					// 0인 곳만을 탐색하여 3개의 벽을 세우기 위해 0인 부분을 3칸 선택하는 조합
					continue;
				}
				matrix[i][j] = 1;
				comb(count + 1, i);
				matrix[i][j] = 0;
			}
		}
	}
	
	static void virus_bfs(int x, int y) {
		test[x][y] = 2;
		visited[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int lx = x + dx[i];
			int ly = y + dy[i];
			if(lx >= 0 && lx < n && ly >= 0 && ly < m 
					 && test[lx][ly] == 0) {
				virus_bfs(lx, ly);
			}
		}
	}
}