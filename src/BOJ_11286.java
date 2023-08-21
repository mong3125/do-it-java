import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 != abs2) {
                return abs1 - abs2;
            } else {
                return o1 - o2;
            }
        });

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input != 0) {
                priorityQueue.add(input);
            } else {
                if (!priorityQueue.isEmpty()) {
                    System.out.println(priorityQueue.poll());
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}