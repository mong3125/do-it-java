import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1546 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");

        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = Integer.parseInt(nums[i]);

            if (max < num) {
                max = num;
            }

            sum += num;
        }

        System.out.println((double) sum / N * 100 / max);
    }
}
