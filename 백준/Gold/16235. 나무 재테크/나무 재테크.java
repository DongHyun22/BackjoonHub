import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[][] a;
    static int[][] food;
    static ArrayList<Integer>[][] map;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new int[n][n];
        food = new int[n][n];
        map = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                food[i][j] = 5;
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            map[x][y].add(age);
//            Collections.sort(map[x][y]);
        }

        for (int year = 0; year < k; year++) {
            springSummer();
            autumnWinter();
        }
        countTree();
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static void countTree() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].size() > 0) {
                    answer += map[i][j].size();
                }
            }
        }
    }

    private static void springSummer() {
        int[][] tmpFood = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].size() > 0) {
                    int bio = 0;
                    int index = 0;
                    int num = map[i][j].size();
                    for (int l = 0; l < num; l++) {
                        int age = map[i][j].get(index);
                        if (age <= food[i][j]) {
                            // 나이만큼 양분 먹고 나이 + 1
                            food[i][j] -= age;
                            map[i][j].set(index++, age + 1);
                        } else {
                            // 자신의 나이만큼 양분을 먹을 수 없으면, 양분을 먹지 못하고 죽는다.
                            bio += age / 2;
                            map[i][j].remove(index);
                        }
                    }
                    tmpFood[i][j] += bio;
                }
            }
        }
        // 여름 : 죽은 나무의 나이를 2로 나눈 값을 양분으로 추가
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                food[i][j] += tmpFood[i][j];
            }
        }
    }
    
    private static void autumnWinter() {
        // 번식
        // 나이가 5의 배수인 나무
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].size() > 0) {
                    for (int l = 0; l < map[i][j].size(); l++) {
                        int age = map[i][j].get(l);
                        if (age % 5 == 0) {
                            // 인접한 8개칸에 나이 1인 나무 생성
                            for (int dir = 0; dir < 8; dir++) {
                                int lx = i + dx[dir];
                                int ly = j + dy[dir];
                                if (lx >= 0 && lx < n && ly >= 0 && ly < n) {
                                    map[lx][ly].add(0, 1);
//                                    Collections.sort(map[lx][ly]);
                                }
                            }
                        }
                    }
                }
            }
        }
        // 겨울 : 양분 추가
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                food[i][j] += a[i][j];
            }
        }
    }
}