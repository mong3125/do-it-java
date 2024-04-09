package 정수론;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1929_소수구하기 {

    static int M, N;
    static boolean[] isPrime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        int boundary = (int) Math.sqrt(N);
        for (int i = 2; i <= boundary; i++) {
            if (!isPrime[i]) continue;

            for (int j = i+i; j <= N; j += i) {
                isPrime[j] = false;
            }
        }

        for (int i = M; i <= N; i++) {
            if (isPrime[i]) System.out.println(i);
        }
    }
}
