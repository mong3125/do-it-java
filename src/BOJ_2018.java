import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long count = 0;

        int start = 1;
        int end = 1;

        int sum  = 1;
        while (start <= N) {
            if (sum == N) {
                count++;

                sum -= start;
                start++;

                end++;
                sum += end;
            } else if (sum < N) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }

        System.out.println(count);
    }
}
