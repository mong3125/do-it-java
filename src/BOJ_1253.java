import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int count = 0;
        for (int i = 0; i < N; i++) {
            int front = 0;
            int back = N-1;

            int sum = 0;
            while (front < back) {
                sum = nums[front] + nums[back];
                if (sum == nums[i]) {
                    if (i == front) {   // 자기 자신이 더해지면 안된다.
                        front++; continue;
                    }
                    if (i == back) {    // 자기 자신이 더해지면 안된다.
                        back--; continue;
                    }
                    count++;    // 좋은 수 개수 +1
                    break;
                } else if (sum < nums[i]) {
                    front++;
                } else {
                    back--;
                }
            }
        }

        System.out.println(count);
    }
}
