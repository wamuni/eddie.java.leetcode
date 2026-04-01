package org.example;

public class PreSum {
    private static PreSum instance = null;
    private PreSum() {};
    public static synchronized PreSum getInstance() {
        if (instance == null) {
            instance = new PreSum();
        }
        return instance;
    }

    class NumArray {
        private int[] s;

        public NumArray(int[] nums) {
            s = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                s[i+1] = s[i] + nums[i];
            }
        }
        public int sumRange(int left, int right) {
            return s[right + 1] - s[left];
        }
    }

    public int subarraySum(int[] nums) {
        int ans = 0;
        int[] s = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            s[i+1] = s[i] + nums[i];
            ans += s[i+1] - s[Math.max(0, i - nums[i])];
        }
        return ans;
    }
}
