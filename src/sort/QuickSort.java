package sort;

public class QuickSort {
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
