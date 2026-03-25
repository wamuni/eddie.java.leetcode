package org.example;

import java.util.*;

public class Foundation {
    private static Foundation instance = null;
    private Foundation() {};
    public static synchronized Foundation getInstance() {
        if (instance == null) {
            instance = new Foundation();
        }
        return instance;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }

    public int numIdenticalPairs(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int numIdenticalPairsOptimized(int[] nums) {
        int cnt = 0;
        int[] map = new int[101];
        for (int x: nums) {
            cnt += map[x];
            map[x]++;
        }
        return cnt;
    }

    public int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = -1;
        for (int x: nums) {
            if (set.contains(-x)) {
                Math.max(ans, Math.abs(x));
            }
            set.add(x);
        }
        return ans;
    }

    private static final int N = 1000;

    public int findMaxKOptimize(int[] nums) {
        boolean[] set = new boolean[N + 1];
        for (int n: nums) {
            if (n > 0) {
                set[n] = true;
            }
        }
        int ans = -1;
        for (int num: nums) {
            if (num < 0 && set[-num]) {
                ans = Math.max(ans, -num);
            }
        }
        return ans;
    }

    // 双循环暴力破解会超时
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i = prices.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (prices[i] - prices[j] > 0) {
                    ans = Math.max(ans, prices[i] - prices[j]);
                }
            }
        }
        return ans;
    }

    public int maxProfitOptimize(int[] prices) {
        int ans = 0;
        int min = prices[0];
        for (int n: prices) {
            ans = Math.max(ans, n - min);
            min = Math.min(min, n);
        }
        return ans;
    }

    public int maximumDifference(int[] nums) {
        int diff = 0;
        int min = nums[0];
        for (int n: nums) {
            diff = Math.max(diff, n - min);
            min = Math.min(min, n);
        }
        return diff == 0 ? -1: diff;
    }

    public int maxDistance(List<List<Integer>> arrays) {
        int ans = 0;
        int mn = Integer.MAX_VALUE / 2;
        int mx = Integer.MIN_VALUE / 2;
        for (List<Integer> l:  arrays) {
            int x = l.getFirst();
            int y = l.getLast();
            ans = Math.max(ans, Math.max(mx - x, y - mn));
            mx = Math.max(mx, y);
            mn = Math.min(mn, x);
        }
        return ans;
    }
}
