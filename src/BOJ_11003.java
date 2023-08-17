import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11003 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이
        StringBuilder sb = new StringBuilder();
        Deque<Node> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty() && deque.getFirst().getIndex() < i - L + 1) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && deque.getLast().getNum() > nums[i]) {
                deque.removeLast();
            }

            deque.addLast(new Node(i, nums[i]));
            sb.append(deque.getFirst().getNum()).append(" ");
        }

        // 출력
        String result = sb.toString();
        System.out.println(result);

        br.close();
    }

    public static class Node {
        Node(int index, int num) {
            this.index = index;
            this.num = num;
        }

        int index;
        int num;

        public int getIndex() {
            return index;
        }

        public int getNum() {
            return num;
        }
    }
}
