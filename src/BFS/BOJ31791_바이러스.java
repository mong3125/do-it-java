package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ31791_바이러스 {
    static int N, M;    // 행, 열 크기
    static int Tg, Tb, X, B;    // 전파되는 시간, 건물에서 전파되는 시간, 바이러스 개수, 건물의 개수
    static char[][] board;

    static boolean[][] visited;
    static ArrayList<Point> virus = new ArrayList<>();
    static ArrayList<Point> next = new ArrayList<>();
    static HashMap<Point, Integer> building = new HashMap<>();

    static int[][] direction = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        Tg = Integer.parseInt(st.nextToken());
        Tb = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
                if (board[i][j] == '*') virus.add(new Point(i, j));
                else if (board[i][j] == '#') building.put(new Point(i, j), 0);
            }
        }

        // 풀이
        for (int i = 0; i < Tg; i++) {
            bfs();
        }

        // 출력
        boolean isAnySafe = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != '*') {
                    isAnySafe = true;
                    System.out.printf("%d %d\n", i, j);
                }
            }
        }

        if (!isAnySafe) System.out.println(-1);
    }

    public static void bfs() {
        // 빌딩 시간 쌓기
        for (Point p : building.keySet()) {
            int count = building.get(p);

            // 지연시간 이상 시간이 지났다면 감염
            if (count >= Tg) {
                board[p.y][p.x] = '*';
                next.add(p);
                building.remove(p);
            } else if (count > 0) {
                building.put(p, building.get(p) + 1);
            }
        }

        for (Point virusPoint : virus) {
            for (int[] d : direction) {
                int y = virusPoint.y + d[0];
                int x = virusPoint.x + d[1];
                Point nowPoint = new Point(y, x);

                if (isInRange(y, x)) {
                    // 방문한 위치라면 패스
                    if (visited[y][x]) continue;

                    // 방문 처리
                    visited[y][x] = true;

                    // 만약 감염되지 않은 장소라면 감염시키기
                    if (board[y][x] == '.') {
                        board[y][x] = '*';
                        next.add(nowPoint);
                    // 빌딩이라면 감염 시작
                    } else if (board[y][x] == '#') {
                        if (building.get(nowPoint) == 0) {
                            building.put(nowPoint, 1);
                        }
                    }
                }
            }
        }

        virus.clear();
        virus.addAll(next);
        next.clear();
    }

    public static boolean isInRange(int y, int x) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }

    static class Point {
        private int x, y;
        Point(int y, int x) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
