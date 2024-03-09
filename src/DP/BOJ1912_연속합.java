package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912_연속합 {

    static int[] array;
    static int[] partialSum;
    static int[] partialMin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new int[n];
        partialSum = new int[n];
        partialMin = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        array[0] = Integer.parseInt(st.nextToken());
        partialSum[0] = array[0];
        partialMin[0] = array[0];

        for (int i = 1; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            partialSum[i] = partialSum[i - 1] + array[i];
            partialMin[i] = Math.min(partialSum[i], partialMin[i - 1]);
        }

        int answer = -1001;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, partialSum[i] - partialMin[i]);
        }

        if (answer == 0) {
            answer = -1001;
            for (int i = 0; i < n; i++) {
                answer = Math.max(answer, array[i]);
            }
        }

        System.out.println(answer);
    }
}
