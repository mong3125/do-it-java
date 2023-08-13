import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(br.readLine());

        int[] partSum = new int[n+1];
        partSum[0] = 0;
        for (int i = 1; i < n+1; i++) {
            partSum[i] = Integer.parseInt(stringTokenizer.nextToken()) + partSum[i-1];
        }

        for (int j = 0; j < m; j++) {
            stringTokenizer = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int end = Integer.parseInt(stringTokenizer.nextToken());

            System.out.println(partSum[end] - partSum[start]);
        }
    }
}
