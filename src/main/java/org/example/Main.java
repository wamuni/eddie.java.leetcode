package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SlidingWindow sw = SlidingWindow.getInstance();
        BinarySearch bs = BinarySearch.getInstance();
//        int res = bs.lowerBand3(new int[] {-1,0,3,5,9,12}, 2);
//        int res = bs.findTheDistanceValue(new int[] {1, 1, 1}, new int[] {2, 2, 2}, 2);
        int[] res = bs.numSmallByFrequency(new String[] {"bbb", "cc"}, new String[] {"a", "aa", "aaa", "aaaa"});
        Arrays.stream(res).forEach(System.out::println);
    }
}