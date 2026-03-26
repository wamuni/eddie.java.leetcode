package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SlidingWindow sw = SlidingWindow.getInstance();
        BinarySearch bs = BinarySearch.getInstance();
        Foundation fd = Foundation.getInstance();
//        int res = bs.lowerBand3(new int[] {-1,0,1,1,2,2,2,3}, 2);
//        int res = bs.findTheDistanceValue(new int[] {1, 1, 1}, new int[] {2, 2, 2}, 2);
//        int[] res = bs.numSmallByFrequency(new String[] {"bbb", "cc"}, new String[] {"a", "aa", "aaa", "aaaa"});

//        int[] res = fd.twoSum(new int[] {3,2,4}, 6);
//        Arrays.stream(res).forEach(System.out::println);
        List<List<Integer>> res = fd.pairSums(new int[]{5,6,5}, 11);
        System.out.println(res);
    }
}