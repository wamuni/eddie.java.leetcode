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
        int res = fd.findMaxK(new int[] {-30,34,1,32,26,-9,-30,22,-49,29,48,47,38,4,43,12,-1,-8,11,-37,32,40,9,15,-34,-34,-16,-5,26,-44,-36,-13,-16,10,39,-17,-22,17,-16});
        System.out.println(res);
    }
}