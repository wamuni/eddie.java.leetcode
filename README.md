#### Sliding Window Topic

##### 定长滑动窗口

###### 知识点总结：

1. a - z 的ascii table 是 97 - 122; A-Z 的ascii table 是 65 - 90

2. 元音好像也就那么几个，没有必要专门有个set来记录，直接放在if statement里就好

3. `toCharArray` 会比 `byte[]` 慢，具体的代码如下

    ```java
    byte[] str = new byte[s.length];
    s.getBytes(0, s.length(), str, 0);
    ```

   因为少一步从byte 转换成char的步骤

4. 如何区别有多少个不同的数字呢，最简单的就是用HashMap，但是要注意，在移动的过程中，记得把右边的数添加到HashMap中去

5. 在求和的问题上，注意int的值可能会超，需要用long来做

    * int 的范围 -2,147,483,648 to 2,147,483,647
    * long 的范围 -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
    * 10 ^ 10 是一个比较注意的范围

###### 算法总结：

定长滑动窗口，在滑动的时候，左边的出，右边的进

###### 相似问题：

1. [leetcode 643](https://leetcode.cn/problems/maximum-average-subarray-i/)
2. [leetcode 1343](https://leetcode.cn/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/solutions/3061222/mo-ban-ding-chang-hua-dong-chuang-kou-py-85sh/)
3. [leetcode 2090](https://leetcode.cn/problems/k-radius-subarray-averages/description/)
4. [leetcode 1360](https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/)
5. [leetcode 2841](https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray/description/)
6. [Leetcode 1456](https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/)

##### 不定滑动窗口

###### 知识点总结：

1. 如果只是字符，那么可以不用HashMap，用array来记录和跟踪，这样可以节约空间

2. 在涉及到int 和long转换的时候，尤其是在进行运算的时候，不要随便加（）

    ```java
    (long) num[i] * k;
    (long) (num[i] * k);
    ```

   两个效果是不一样的，第二是计算完之后再进行的数据类型转换

3. 如果是确定子数组中每个元素具有独特性，那么可以用布尔数列

    ```java
    boolean[] has = new boolean[n] //n为最大值
    ```

###### 算法总结：

不定滑动窗口都是先动右指针，然后在遇到特定条件之后，开始动左指针

###### 相似问题

1. [LeetCode 3](https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/1959540/xia-biao-zong-suan-cuo-qing-kan-zhe-by-e-iaks/)
2. [LeetCode 1695](https://leetcode.cn/problems/maximum-erasure-value/submissions/708593598/)
3. [LeetCode 2958](https://leetcode.cn/problems/length-of-longest-subarray-with-at-most-k-frequency/description/)
4. [LeetCode 2024](https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/description/)

#### Binary Search Topic

##### 基础题型

###### 知识点总结

1. 为什么在求取中间值的时候用 `left + (right - left) / 2` 而不是直接 `(left + right) / 2`?

   > 因为left+right在Java中有可能出现栈溢出的情况

2. `lowerBand` function, the implementation.

    ```java
    public int lowerBand(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
    ```

    这个二分法的模版是一个左开右开的模版，最后返回的值，是 `>= target` 的第一个元素的下标，如果元素不存在，那么返回的结果就是数组的长度n；如果数组中最小的数都比target要大，那么返回的就是-1；

    由此可以推断出以下结果：

    1. `> target` 的第一个元素的下标， `lowerBand(nums, x+1)` 
    2. `< target` 的最后一个元素下标，`lowerBand(nums, x) - 1`
    3. `<=target` 的最后一个元素下标，`lowerBand(nums, x+1) - 1`

    另外一种变形问题，求满足不同target的长度

    1. `<x` 的元素个数， `lowerBand(nums, x)`
    2. `<=x` 的元素个数，`lowerBand(nums, x+1)`
    3. `>=x` 的元素个数，`n - lowerBand(nums, x)`
    4. `>x`的元素个数，`n - lowerBand(nums, x+1)`

3. 如果是有相关的问题，提出来的范围是一个绝对值，那么可以将其转换为

    ```java
    Math.abs(arr1[i] - arr2[j]) < d;
    //Then, it is equal to
    [arr1[i] - d, arr1[i] + d];
    ```

4. 为什么需要`~` 来对结果进行处理呢

