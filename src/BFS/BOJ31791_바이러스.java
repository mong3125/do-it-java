package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ31791_바이러스 {
    static int N, M;    // 행, 열 크기
    static int Tg, Tb, X, B;    // 전파되는 시간, 건물에서 전파되는 시간, 바이러스 개수, 건물의 개수

    static int[][] board;
    static boolean[][] visited;
    static PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[2] - o2[2]));

    static int[][] direction = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };

    public static void main(String[] args) throws IOException {
        // 입력
        input();

        // 풀이
        bfs();

        // 출력
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        Tg = Integer.parseInt(st.nextToken());
        Tb = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                switch (row.charAt(j)) {
                    case '*':
                        board[i][j] = -Tg - 1;
                        visited[i][j] = true;
                        pq.add(new int[] {j, i, -Tg});
                        break;
                    case '#':
                        board[i][j] = Tb;
                        break;
                    default:
                        board[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (now[2] >= 0) continue;

            for (int[] d : direction) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];

                if (isInRange(y, x)) {
                    if (visited[y][x]) continue;

                    visited[y][x] = true;

                    board[y][x] = board[y][x] + now[2];
                    pq.add(new int[] {x, y, board[y][x] + 1});
                }
            }
        }
    }

    private static void output() {
        boolean isAnySafe = false;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] >= 0) {
                    isAnySafe = true;
                    sb.append(String.format("%d %d\n", i+1, j+1));
                }
            }
        }

        if (isAnySafe) System.out.println(sb.toString());
        else System.out.println(-1);
    }

    public static boolean isInRange(int y, int x) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}