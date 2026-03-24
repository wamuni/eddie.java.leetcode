package org.example;

import java.util.HashMap;
import java.util.Map;

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
}
