package 이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ2343_기타레슨 {
    static int N;
    static int M;
    static int[] lectures;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lectures = new int[N];

        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            sum += lectures[i];
        }

        System.out.println(minBlue(0, sum));
    }

    /**
     * 범위내에서 조건을 만족하는 가장 작은 값을 반환한다.
     * @param from 시작 범위
     * @param to 최대 범위
     * @return 가장 작은 값
     */
    public static int minBlue(int from, int to) {
        if (from > to) return Integer.MAX_VALUE;

        int mid = (from + to) / 2;

        if (can(mid)) {
            int probability = minBlue(from, mid - 1);
            return Math.min(probability, mid);
        } else {
            return minBlue(mid + 1, to);
        }
    }

    public static boolean can(int size) {
        int count = M;

        int partSize = size;
        for (int i = 0; i < N && count > 0; ) {
            if (partSize - lectures[i] >= 0) {
                partSize -= lectures[i];
                i++;
            } else {
                count--;
                partSize = size;
            }
        }

        return count > 0;
    }
}
