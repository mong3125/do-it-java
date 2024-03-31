package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273_두수의합 {
    static int n;
    static int x;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        Arrays.sort(nums);

        int front = 0;
        int back = n - 1;

        int count = 0;
        while (front < back) {
            if (nums[front] + nums[back] < x) {
                front++;
            } else if (nums[front] + nums[back] > x) {
                back--;
            } else {
                count++;
                front++;
            }
        }

        System.out.println(count);
    }
}
