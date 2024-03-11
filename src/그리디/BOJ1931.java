// https://www.acmicpc.net/problem/1931

package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1931 {

    static int[][] conferences;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        conferences = new int[n][2];

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            conferences[i][0] = Integer.parseInt(st.nextToken());   // 시작시간
            conferences[i][1] = Integer.parseInt(st.nextToken());   // 종료시간
        }

        Arrays.sort(conferences, (o1, o2) -> {
            // 종료시간이 같다면
            if (o1[1] == o2[1]) {
                // 시작시간이 빠른 순서로
                return o1[0] - o2[0];
            }

            // 종료시간이 빠른 순서로
            return o1[1] - o2[1];
        });

        int answer = 0;
        int beforeEndTime = 0;
        for (int i = 0; i < n; i++) {
            if (beforeEndTime <= conferences[i][0]) {
                answer++;
                beforeEndTime = conferences[i][1];
            }
        }

        System.out.println(answer);
    }
}
