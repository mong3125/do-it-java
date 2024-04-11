package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7569_토마토 {

    static int M, N, H;
    static Queue<int[]> ripen = new LinkedList<>();   // 익은 토마토 위치
    static Queue<int[]> temp = new LinkedList<>();   // 익은 토마토 위치
    static int notRipenTomatos = 0;

    // 방향
    static int[][] directions = {
            {1, 0, 0},
            {-1, 0, 0},
            {0, 1, 0},
            {0, -1, 0},
            {0, 0, 1},
            {0, 0, -1},
    };

    // 박스
    static int[][][] box;

    // 방문 여부
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        // == 입력 == //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());

                    // 익은 토마토 위치 저장
                    if (box[i][j][k] == 1) ripen.add(new int[]{i, j, k});
                    else if (box[i][j][k] == 0) notRipenTomatos++;
                }
            }
        }

        // == 풀이 == //
        int count = 0;

        // 새로 익은 토마토가 없을때까지 반복
        while (!ripen.isEmpty()) {
            bfs();
            count++;
        }

        // 모든 토마토가 익은게 아니라면 -1 반환
        if (notRipenTomatos > 0) {
            count = 0;
        }

        System.out.println(count - 1);
    }

    public static void bfs() {
        temp.clear();

        while (!ripen.isEmpty()) {
            int[] tomato = ripen.remove();
            if (visited[tomato[0]][tomato[1]][tomato[2]]) continue;

            visited[tomato[0]][tomato[1]][tomato[2]] = true;
            ripe(tomato);
        }

        ripen.addAll(temp);
    }

    public static void ripe(int[] tomato) {
        for (int[] direction : directions) {
            int z = tomato[0] + direction[0];
            int y = tomato[1] + direction[1];
            int x = tomato[2] + direction[2];

            if (isInRange(z, y, x)) {
                if (box[z][y][x] == 0) {
                    box[z][y][x] = 1;
                    notRipenTomatos--;
                    temp.add(new int[]{z, y, x});
                }
            }
        }
    }

    public static boolean isInRange(int z, int y, int x) {
        return (x >= 0 && x < M && y >= 0 && y < N && z >= 0 && z < H);
    }
}
