package 그리디;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1715_카드정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        int result = 0;
        while (queue.size() != 1) {
            int data1 = queue.remove();
            int data2 = queue.remove();

            result += data1 + data2;
            queue.add(data1 + data2);
        }

        System.out.println(result);
    }
}
