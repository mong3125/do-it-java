package 알고리즘_스터디.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2023 {

    static int target;  // 목표 자리수
    static List<Integer> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());


        // 해결
        dfs(2);
        dfs(3);
        dfs(5);
        dfs(7);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (Integer answer : answers) {
            sb.append(answer);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void dfs(int number) {
        if (countDigits(number) == target) {
            answers.add(number);
            return;
        }

        number *= 10;
        for (int i = 0; i <= 9; i++) {
            if (isPrimeNumber(number + i)) {
                dfs(number + i);
            }
        }
    }

    public static int countDigits(int number) {
        int digits = 0;
        while (number > 0) {
            digits++;
            number /= 10;
        }
        return digits;
    }

    public static boolean isPrimeNumber(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
