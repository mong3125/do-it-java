import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(nums);

        System.out.println(nums[K - 1]);
        br.close();
    }

    public static void quickSort(int[] nums) {
        sorting(nums, 0, nums.length - 1);
    }

    public static void sorting(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(nums, left, right);
        sorting(nums, left, pivot - 1);
        sorting(nums, pivot + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        if (left + 1 == right) {
            if (nums[left] > nums[right]) {
                swap(nums, left, right);
                return right;
            }
        }

        int l = left;
        int r = right;
        int pivot = nums[left];

        while (l < r) {
            while (nums[l] <= pivot && l < r) {
                l++;
            }
            while (nums[r] > pivot && l < r) {
                r--;
            }
            if (l < r) {
                swap(nums, l, r);
            }
        }
        swap(nums, left, r);

        return r;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
