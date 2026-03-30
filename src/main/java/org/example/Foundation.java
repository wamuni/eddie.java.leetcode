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

    public int maximumSum(int[] nums) {
        int[] mx = new int[82];
        Arrays.fill(mx, Integer.MIN_VALUE);
        int ans = 0;
        for (int num: nums) {
            int n = digitSum(num);
            ans = Math.max(ans, mx[n] + num);
            mx[n] = Math.max(mx[n], num);
        }
        return ans;
    }

    private int digitSum(int num) {
        int sum = 0;
        do {
            sum += num % 10;
            num /= 10;
        } while (num > 0);
        return sum;
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int[][] cnt = new int[10][10];
        for (int[] pair: dominoes) {
            int a = Math.min(pair[0], pair[1]);
            int b = Math.max(pair[0], pair[1]);
            ans += cnt[a][b]++;
        }
        return ans;
    }

    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            int c = map.getOrDefault(k - n, 0);
            if (c > 0) {
                map.put(k-n, c-1);
                ans++;
            } else {
                map.merge(n, 1, Integer::sum);
            }
        }
        return ans;
    }

    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int n: nums) {
            int c = cnt.getOrDefault(target - n, 0);
            if (c > 0) {
                cnt.put(target - n, c - 1);
                ans.add(List.of(target - n, n));
            } else {
                cnt.merge(n, 1, Integer::sum);
            }
        }
        return ans;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> abs = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (abs.get(nums[i]) <= k) {
                return true;
            } else {

            }
        }

        return false;
    }

    private static final int MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        HashMap<Integer, Integer> cnt = new HashMap<>(points.length, 1);
        for (int[] p: points) {
            cnt.merge(p[1], 1, Integer::sum);
        }
        long ans = 0, s = 0;
        for (int c: cnt.values()) {
            long k = (long) c * (c - 1) / 2;
            ans += s * k;
            s += k;
        }
        return (int) (ans % MOD);
    }

    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long ans = (long) n * (n - 1) / 2;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i] - i;
            int c = cnt.getOrDefault(x, 0);
            ans -= c;
            cnt.put(x, c + 1);
        }
        return ans;
    }

    public long countPairs(String[] words) {
        Map<String, Integer> cnt = new HashMap<>();
        long ans = 0;
        for (String word: words) {
            char[] t = word.toCharArray();
            char base = t[0];
            for (int i = 0; i < t.length; i++) {
                t[i] = (char) ((t[i] - base + 26) % 26);
            }
            word = new String(t);
            int c = cnt.getOrDefault(word, 0);
            ans += c;
            cnt.put(word, c + 1);
        }
        return ans;
    }

    public int getLargestOutlier(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int total = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x: nums) {
            cnt.merge(x, 1, Integer::sum);
            total += x;
        }

        for (int x: nums) {
            if (x % 2 == 0) {
                int y = (total - x) / 2;
                if (cnt.containsKey(y) && (y != x || cnt.get(y) > 1)) {
                    ans = Math.max(ans, x);
                }
            }
        }

        return ans;
    }
}
