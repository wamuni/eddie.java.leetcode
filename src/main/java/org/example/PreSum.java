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

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] s = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            s[i+1] = s[i] + (vowels(word) ? 1: 0);
        }
        for (int i = 0; i < queries.length; i++) {
            ans[i] = s[queries[i][1] + 1] - s[queries[i][0]];
        }
        return ans;
    }

    private boolean vowels(char[] arr) {
        int n = arr.length - 1;
        return (arr[0] == 'a' || arr[0] == 'e' || arr[0] == 'i' || arr[0] == 'o' || arr[0] == 'u') &&
                (arr[n] == 'a' || arr[n] == 'e' || arr[n] == 'i' || arr[n] == 'o' || arr[n] == 'u');
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int ans[] = new int[queries.length];
        int[] s = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            s[i+1] = s[i] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            ans[i] = s[queries[i][1] + 1] ^ s[queries[i][0]];
        }
        return ans;
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int[] s = new int[nums.length];
        for (int i = 1 ; i < nums.length; i++) {
            s[i] = s[i - 1] + (nums[i-1] % 2 == nums[i] % 2 ? 1: 0);
        }
        for (int i = 0; i < queries.length; i++) {
            ans[i] = s[queries[i][0]] == s[queries[i][1]];
        }
        return ans;
    }

    public int maxAbsoluteSum(int[] nums) {
        int s = 0, mx = 0, mn = 0;
        for (int x: nums) {
            s += x;
            if (s > mx) mx = s;
            else if (s < mn) mn = s;
        }
        return mx - mn;
    }

    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] sum = new long[n + 1];
        long[] sumSell = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + strategy[i] * prices[i];
            sumSell[i + 1] = sum[i] + prices[i];
        }
        long ans = sum[n];
        for (int i = k; i <= n; i++) {
            long res = sum[i - k] + sum[n] + sumSell[i] - sumSell[i - k/2];
            ans = Math.max(ans, res);
        }
        return ans;
    }
}
