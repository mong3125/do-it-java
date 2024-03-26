package chapter04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem18_BOJ11399 {
    public static void main(String[] args) throws IOException {
        // ---입력---
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        // ---풀이---
        // 정렬
        insertSort(P);

        // 답 구하기
        int answer = 0;
        for (int i = 0; i < P.length; i++) {
            answer += P[i] * (P.length - i);
        }

        // ---출력---
        System.out.println(answer);

        br.close();
    }

    private static void insertSort(int[] li) {
        for (int i = 1; i < li.length; i++) {
            int now = li[i];

            int j;
            for (j = i - 1; j >= 0 && li[j] > now; j--) {
                li[j + 1] = li[j];
            }

            li[j + 1] = now;
        }
    }
}
