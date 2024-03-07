import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[][] map = new int[w][h];
        for (int i = 0; i < h; i++) {
            int height = Integer.parseInt(st.nextToken());
            for (int j = w-1; j >= w - height; j--) {
                map[j][i] = 1;
            }
        }

//        for (int i = 0; i < w; i++) {
//            for (int j = 0; j < h; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

        // 1. 좌에서 우로 탐색하며 1이나오면 상태o, 0이나올때 상태가o-> 체크, 상태가x-> 무시
        int answer = 0;
        for (int i = 0; i < w; i++) {
            boolean state = false;
            boolean preBlack = false;
            int count = 0;
            for (int j = 0; j < h; j++) {
                int value = map[i][j];
                if(value == 1) {
                    if(preBlack) {
                        continue;
                    }
                    if(state) {
                        answer += count;
                        count = 0;
                    }
                    else {
                        count = 0;
                    }
                    state = !state;
                    preBlack = true;

                }
                else {
                    count++;
                    if(preBlack) {
                        state = true;
                    }
                    preBlack = false;
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
