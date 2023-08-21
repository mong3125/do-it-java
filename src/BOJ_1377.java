import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1377 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            nodes.add(new Node(i, Integer.parseInt(br.readLine())));
        }

        // 풀이
        int answer = 0;

        Collections.sort(nodes);    // 정렬

        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, nodes.get(i).index - i);
        }

        // 출력
        System.out.println(answer + 1);

        br.close();
    }

    public static class Node implements Comparable<Node> {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
