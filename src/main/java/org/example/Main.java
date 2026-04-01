package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SlidingWindow sw = SlidingWindow.getInstance();
        BinarySearch bs = BinarySearch.getInstance();
        Foundation fd = Foundation.getInstance();
        PreSum ps = PreSum.getInstance();
//        int res = bs.lowerBand3(new int[] {-1,0,1,1,2,2,2,3}, 2);
//        int res = bs.findTheDistanceValue(new int[] {1, 1, 1}, new int[] {2, 2, 2}, 2);
//        int[] res = bs.numSmallByFrequency(new String[] {"bbb", "cc"}, new String[] {"a", "aa", "aaa", "aaaa"});

//        int[] res = fd.twoSum(new int[] {3,2,4}, 6);
//        Arrays.stream(res).forEach(System.out::println);
        List<List<Integer>> res = fd.pairSums(new int[]{5,6,5}, 11);
        System.out.println(res);

        int rev = fd.minMirrorPairDistance(new int[] {21, 120});
        System.out.println(rev);

        int res_mod = fd.numPairsDivisibleBy60(new int[] {30,20,150,100,40});
        System.out.println(res_mod);

        long res_hours = fd.countCompleteDayPairs(new int[] {72,48,24,3,21});
        System.out.println(res_hours);

        int gcd = fd.gcd(5, 2);
        System.out.println(gcd);

        System.out.println(0 ^ 1 ^ 3 ^ 4 ^ 0 ^ 1);
        int[] ans = ps.xorQueries(new int[] {16}, new int[][] {{0, 0}, {0, 0}, {0, 0}});
        Arrays.stream(ans).forEach(System.out::println);
    }
}