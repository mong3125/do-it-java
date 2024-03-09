package CH05_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P023_11724 {
    static int N;
    static int M;
    static int[][] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 노드 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수

        edges = new int[N+1][N+1];

        // 엣지 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a][b] = 1;
            edges[b][a] = 1;
        }

        String word = "";
        char ch = word.charAt(2);


        br.close();
    }

    public class Node {
        int id;
        List<Integer> edges = new ArrayList<>();
    }
}
