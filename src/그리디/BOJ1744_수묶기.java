package 그리디;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1744_수묶기 {

    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int one = 0;
        boolean hasZero = false;

        PriorityQueue<Integer> plusPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPQ = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int inp = sc.nextInt();
            if (inp > 1) {
                plusPQ.add(inp);
            } else if (inp == 1) {
                one++;
            } else if (inp < 0) {
                minusPQ.add(inp);
            } else {
                hasZero = true;
            }
        }

        int sum = 0;

        while (plusPQ.size() >= 2) {
            int a = plusPQ.remove();
            int b = plusPQ.remove();

            sum += a * b;
        }
        if (!plusPQ.isEmpty()) sum += plusPQ.remove();

        while (minusPQ.size() >= 2) {
            int a = minusPQ.remove();
            int b = minusPQ.remove();

            sum += a * b;
        }
        if (!minusPQ.isEmpty()) {
            if (!hasZero) sum += minusPQ.remove();
        }

        sum += one;

        System.out.println(sum);
    }
}
