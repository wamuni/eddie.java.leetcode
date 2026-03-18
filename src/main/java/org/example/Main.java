package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SlidingWindow sw = SlidingWindow.getInstance();
        BinarySearch bs = BinarySearch.getInstance();
        int res = bs.lowerBand(new int[] {5, 7, 7, 8, 8, 10}, 8);
        System.out.println(res);
    }
}