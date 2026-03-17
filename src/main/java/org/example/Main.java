package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5,9,9,2,4,5,4);
        long res = maxSum(nums, 1, 3);
        System.out.println(res);
        int s = totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4});
        System.out.println(s);
        int m = maximumUniqueSubarray(new int[] {4,2,4,5,6});
        System.out.println(m);
        int k = maxSubArrayLength(new int[] {1, 2, 3, 1, 2, 3, 1 ,2}, 2);
        System.out.println(k);
    }

    public static long maxSum(List<Integer> nums, int m, int k) {
        Integer[] arr = nums.toArray(Integer[]::new);

        long max = 0;
        int left = 0;
        int right = 0;
        long sum = 0;

        Map<Integer, Integer> cnt = new HashMap<>();

        while (right < k) {
            sum += arr[right];
            cnt.merge(arr[right], 1, Integer::sum);
            right++;
        }

        if (cnt.size() >= m) {
            max = sum;
        }

        while (right < arr.length) {
            sum += arr[right] - arr[left];
            cnt.merge(arr[right], 1, Integer::sum);
            int x = cnt.get(arr[left]);
            if (x > 1) {
                cnt.put(arr[left], x -1);
            } else {
                cnt.remove(arr[left]);
            }

            if (cnt.size() >= m) {
                if (max < sum) {
                    max = sum;
                }
            }

            right++;
            left++;
        }

        return max;
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        long sum = 0;
        int left = 0;
        int right = 0;

        Set<Integer> cnt = new HashSet<>();

        while (right < k) {
            cnt.add(nums[right]);
            sum += nums[right++];
        }

        if (cnt.size() == k) {
            max = sum;
        }

        while (right < nums.length) {
            cnt.remove(nums[left]);
            cnt.add(nums[right]);
            sum += nums[right++] - nums[left++];
            if (cnt.size() == k) {
                if (max < sum) {
                    max = sum;
                }
            }
        }

        return max;
    }

    public static int equalSubString(String s, String t, int maxCost) {
        byte[] s_arr = new byte[s.length()];
        byte[] t_arr = new byte[t.length()];
        s.getBytes(0, s.length(), s_arr, 0);
        t.getBytes(0, t.length(), t_arr, 0);
        int [] diff = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            diff[i] = Math.abs(s_arr[i] - t_arr[i]);
        }
        int j = 0;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < diff.length; i++) {
            sum += diff[i];
            while (sum > maxCost) {
                sum -= diff[j];
                j++;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static int totalFruit(int[] fruits) {
        int cnt = 0;
        int j = 0;
        Map<Integer, Integer> tree = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            tree.merge(fruits[i], 1, Integer::sum);
            while (tree.size() > 2) {
                int t = tree.get(fruits[j]);
                if (t > 1) {
                    tree.put(fruits[j], t - 1);
                } else {
                    tree.remove(fruits[j]);
                }
                j++;
            }
            cnt = Math.max(cnt, i - j + 1);
        }
        return cnt;
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int maxN = 0;
        for (int num: nums) {
            maxN = Math.max(maxN, num);
        }
        boolean[] has = new boolean[maxN + 1];
        int sum = 0;
        int maxS = 0;
        int j = 0;
        for (int n: nums) {
            while(has[n]) {
                has[nums[j]] = false;
                sum -= nums[j];
                j++;
            }
            has[n] = true;
            sum += n;
            maxS = Math.max(sum, maxS);
        }
        return maxS;
    }

    public static int maxSubArrayLength(int[] nums, int k) {
        int maxN = 0;
        for (int n: nums) {
            maxN = Math.max(maxN, n);
        }
        int[] cnt = new int[maxN + 1];
        int max = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
            while (cnt[nums[i]] > k) {
                cnt[nums[j]]--;
                j++;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        byte[] arr = new byte[answerKey.length()];
        answerKey.getBytes(0, answerKey.length(), arr, 0);
        int ans = 0, j = 0;
        int[] cnt = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'F') {
                cnt[0]++;
            } else {
                cnt[1]++;
            }
            while (cnt[0] > k && cnt[1] > k) {
                if (arr[j] == 'F') {
                    cnt[0]--;
                } else {
                    cnt[1]--;
                }
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    public static int longestOnes(int[] nums, int k) {
        int[] cnt = new int[2];
        int j = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
            while (cnt[0] > k) {
                cnt[nums[j++]]--;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}