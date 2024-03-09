import java.util.*;
import java.io.*;

class Cctv {
    int x;
    int y;
    int num;

    public Cctv(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}

public class Main {
    static int w;
    static int h;
    static int[][] map;
    static ArrayList<Cctv> cctvList = new ArrayList<>();
    static ArrayList<Integer> countList = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[w][h];

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < h; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvList.add(new Cctv(i, j, map[i][j]));
                    switch (map[i][j]) {
                        case 1:
                        case 3:
                        case 4:
                            countList.add(4);
                            break;
                        case 2:
                            countList.add(2);
                            break;
                        case 5:
                            countList.add(1);
                    }
                }
            }
        }
        int[][] tmp = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                tmp[i][j] = map[i][j];
            }
        }

        solution(0, tmp);

        bw.write(String.valueOf(answer));
        bw.flush();

    }

    // 리스트에서 visited리스트 생성 후 하나씩 탐색하여 맵에 표시 후 사각지대 체크
    static void solution(int seq, int[][] map) {
        if (seq >= countList.size()) {
            // 사각지대 최솟값 구하기
            countMap(map);
            // 구한 최솟값에서 기존의 최솟값과 비교 후 저장
            return;
        }

        // 새로운 맵에 cctv 체크
        for (int i = 0; i < countList.get(seq); i++) {

            int[][] tmp = new int[w][h];
            for (int j = 0; j < w; j++) {
                for (int k = 0; k < h; k++) {
                    tmp[j][k] = map[j][k];
                }
            }

//            System.out.println(seq + " : " + i);
            // 맵에 색칠하기
            solution(seq + 1, fillMap(seq, i, tmp));
//            for (int j = 0; j < w; j++) {
//                for (int k = 0; k < h; k++) {
//                    System.out.print(tmp[j][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

    }

    private static int[][] fillMap(int seq, int count, int[][] tmp) {
        int x = cctvList.get(seq).x;
        int y = cctvList.get(seq).y;
        int num = cctvList.get(seq).num;
        if (num == 1) {
            tmp = dirFill(x, y, count, tmp);
        } else if (num == 2) {
            tmp = dirFill(x, y, count, tmp);
            tmp = dirFill(x, y, count + 2, tmp);
        } else if (num == 3) {
            tmp = dirFill(x, y, count, tmp);
            tmp = dirFill(x, y, (count + 1) % 4, tmp);
        } else if (num == 4) {
            tmp = dirFill(x, y, count, tmp);
            tmp = dirFill(x, y, (count + 1) % 4, tmp);
            tmp = dirFill(x, y, (count + 2) % 4, tmp);
        } else if (num == 5) {
            tmp = dirFill(x, y, count, tmp);
            tmp = dirFill(x, y, count + 1, tmp);
            tmp = dirFill(x, y, count + 2, tmp);
            tmp = dirFill(x, y, count + 3, tmp);
        }
        return tmp;
    }

    static int[][] dirFill(int x, int y, int dir, int[][] tmp) {
        int lx = x;
        int ly = y;
        while (true) {
            lx += dx[dir];
            ly += dy[dir];
            if (lx < 0 || lx >= w || ly < 0 || ly >= h || tmp[lx][ly] == 6)
                break;
            if (tmp[lx][ly] == 1 || tmp[lx][ly] == 2 || tmp[lx][ly] == 3 || tmp[lx][ly] == 4 || tmp[lx][ly] == 5) {
                continue;
            }
            tmp[lx][ly] = 9;
        }
        return tmp;
    }

    private static void countMap(int[][] tmp) {
        int count = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (tmp[i][j] == 0) {
                    count++;
                }
            }
        }
        if (count < answer) {
            answer = count;
        }
    }
}
