package 알고리즘_스터디.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1167_트리의지름 {

    static ArrayList<Edge>[] edges;
    static int max = 0;
    static int farthestNode = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        edges = new ArrayList[v + 1];
        for (int i = 0; i < v + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            while (true) {
                int destination = Integer.parseInt(st.nextToken());
                if (destination == -1) break;

                int distance = Integer.parseInt(st.nextToken());
                edges[now].add(new Edge(destination, distance));
            }
        }


    }

    public void dfs(int node) {
        
    }

    static class Edge {
        int destination;
        int distance;

        public Edge(int destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }
    }
}
