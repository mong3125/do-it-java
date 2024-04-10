package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7569_토마토 {

    static int M, N, H;
    static Queue<int[]> ripen = new LinkedList<>();   // 익은 토마토 위치
    static Queue<int[]> temp = new LinkedList<>();   // 익은 토마토 위치


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
                }
            }
        }

        // == 풀이 == //
        int count = 0;
        while (true) {
            boolean isChanged = bfs();

            // 더 이상 익힐 수 있는 토마토가 없을때
            if (!isChanged) {
                // 만약 전부 익었다면 그냥 멈추기
                if (isAllRipen()) {
                    break;
                // 안 익은 토마토가 존재한다면 -1 반환
                } else {
                    count = -1;
                    break;
                }
            }

            count++;
        }

        System.out.println(count);
    }

    public static boolean bfs() {
        temp.clear();

        while (!ripen.isEmpty()) {
            int[] tomato = ripen.remove();
            if (visited[tomato[0]][tomato[1]][tomato[2]]) continue;

            visited[tomato[0]][tomato[1]][tomato[2]] = true;
            ripe(tomato);
        }

        ripen.addAll(temp);
        return !temp.isEmpty();
    }

    public static void ripe(int[] tomato) {
        for (int[] direction : directions) {
            int z = tomato[0] + direction[0];
            int y = tomato[1] + direction[1];
            int x = tomato[2] + direction[2];

            if (isInRange(z, y, x)) {
                if (box[z][y][x] == 0) {
                    box[z][y][x] = 1;
                    temp.add(new int[]{z, y, x});
                }
            }
        }
    }

    public static boolean isAllRipen() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) return false;
                }
            }
        }

        return true;
    }

    public static boolean isInRange(int z, int y, int x) {
        return (x >= 0 && x < M && y >= 0 && y < N && z >= 0 && z < H);
    }
}
