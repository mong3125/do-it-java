package 알고리즘_스터디.자료구조.덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1021 {
    static int N, M;

    static int[] targets;
    static int[] relativePositions; // N / 2와 비교했을때의 상대위치

    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫 줄 입력
        N = Integer.parseInt(st.nextToken()) - 1;
        M = Integer.parseInt(st.nextToken());
        targets = new int[M];
        relativePositions = new int[M];

        // 두번째 줄 타겟 위치 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken()) - 1;
            relativePositions[i] = N / 2 - targets[i];
        }

        // 2. 문제 해결
        int count = 0;

        int closestFontIndex = 0;
        boolean flag = true;
        int closestBackIndex = N - 1;
        for (int i = 0; i < M; i++) {
            if (relativePositions[i] >= 0) closestFontIndex = i;
        }

        for (int i = M - 1; i >= 0; i--) {
            if (relativePositions[i] < 0) closestBackIndex = i;
        }

        if (relativePositions[closestFontIndex] > Math.abs(relativePositions[closestBackIndex])) {
            count += targets[closestFontIndex];
            targets[closestBackIndex] -= targets[closestFontIndex];
            relativePositions[closestBackIndex] = N / 2 - targets[closestBackIndex];
            if (relativePositions[closestBackIndex] >= 0) {
                count += targets[closestBackIndex];
            } else {
                count += N - targets[closestBackIndex] + 1;
            }
        } else {
            count += N - targets[closestBackIndex] + 1;
            targets[closestFontIndex] += N - targets[closestBackIndex] + 1;
            relativePositions[closestFontIndex] = N / 2 - targets[closestFontIndex];
            if (relativePositions[closestFontIndex] >= 0) {
                count += targets[closestFontIndex];
            } else {
                count += N - targets[closestFontIndex];
            }
        }

        // 3. 출력
        System.out.println(count);
    }
}
