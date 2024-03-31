package 재귀;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1914_하노이탑 {
    static ArrayList<int[]> steps;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE));

        if (N <= 20) {
            steps = new ArrayList<int[]>();
            hanoi(1, 3, 2, N);
            for (int i = 0; i < steps.size(); i++) {
                int[] step = steps.get(i);
                System.out.println(step[0] + " " + step[1]);
            }
        }
    }

    public static void hanoi(int from, int to, int rest, int n) {
        if (n == 1) {
            steps.add(new int[] {from, to});
        } else {
            // from에서 rest로 n-1개 이동
            hanoi(from, rest, to, n - 1);

            // from에서 to로 1개 이동
            steps.add(new int[] {from, to});

            // rest에서 to로 n-1개 이동
            hanoi(rest, to, from, n - 1);
        }
    }
}
