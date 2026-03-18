package org.example;

public class BinarySearch {
    private static BinarySearch instance = null;
    private BinarySearch() {}

    public static BinarySearch getInstance() {
        if (instance == null) {
            instance = new BinarySearch();
        }
        return instance;
    }

    /*
    * 左闭右闭区间的做法
    * 这个方法返回的是，最小满足 nums[i] >= target 的下标
    * 这个方法要求nums是非递减的
    * */
    public int lowerBand(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // [left, right]
        while (left <= right) { // 因为是左闭右闭区间，那么就意味着，在left == right的情况下，是有一个可以取到的值的
            int mid = left + (right - left) / 2; // 中间值是向下取整的
            if (nums[mid] >= target) {
                right = mid - 1; // 缩小范围到 [left, mid - 1]
            } else {
                left = mid + 1; // 缩小范围到 [mid + 1, right]
            }
        }

        return left;
    }
}
