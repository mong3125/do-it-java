import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1427 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums_string = br.readLine().split("");
        int[] nums = new int[nums_string.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(nums_string[i]);
        }

        // 풀이 (insert sort)
        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[index]) {
                    index = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }

        // 출력
        for (int num : nums) {
            System.out.print(num);
        }

        br.close();
    }
}
