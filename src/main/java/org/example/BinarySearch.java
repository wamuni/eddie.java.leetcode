package org.example;

import java.util.Arrays;

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
    * 如果target没有找到，那么left最后的结果就是nums的长度
    * */
    public int lowerBand(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // [left, right]
        // 循环不变量
        // left - 1始终是小于target
        // right + 1始终是大于target
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

    public int lowerBand2(int nums[], int target) {
        int left = 0;
        int right = nums.length; // 左闭右开区间[left, right), 所以right设定为最后的元素index + 1
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int lowerBand3(int nums[], int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int cnt = 0;
        for(int x : arr1) {
            int idx = lowerBand3(arr2, x - d);
            if (idx < 0) {
                idx = ~idx;
            }
            if (idx == arr2.length || arr2[idx] > x + d) {
                cnt++;
            }
        }
        return cnt;
    }
}
