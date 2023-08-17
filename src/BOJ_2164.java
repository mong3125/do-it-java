import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2164 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 풀이
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }

        // 출력
        System.out.println(queue.poll());
    }
}
