package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178_미로탐색하기 {

    static int n;
    static int m;

    static boolean[][] field;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 세로 크기
        m = Integer.parseInt(st.nextToken());   // 가로 크기

        // 미로 선언
        field = new boolean[n][m];
        visited = new boolean[n][m];

        // 미로 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                field[i][j] = line.charAt(j) == '1';
            }
        }

        // 문제 해결
        int answer = bfs(0, 0);

        // 출력
        System.out.println(answer);
    }

    public static int bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j, 1});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == n - 1 && now[1] == m - 1) {
                return now[2];
            }

            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (isInRange(x, y)) {
                    if (!visited[x][y] && field[x][y]) {
                        queue.add(new int[]{x, y, now[2] + 1});
                        visited[x][y] = true;
                    }
                }
            }
        }

        return 0;
    }

    public static boolean isInRange(int i, int j) {
        return 0 <= i && i < n && 0 <= j && j < m;
    }
}
