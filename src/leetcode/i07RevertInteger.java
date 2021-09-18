package com.samon.leetcodelib.leetcode_solution.src.leetcode;

import com.samon.leetcodelib.leetcode_solution.src.Execute.MyRunnable;

public class
i07RevertInteger implements MyRunnable {
    @Override
    public void run() {
        int result = reverse(0);
        System.out.println(result);
    }


    //将一个整数反转，如果反转后超出范围就返回0
    public int reverse(int x) {
        int result = 0;
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        while (x != 0) {
            if (result > max || result < min)//重点是判断这个数是否在整形范围内
                //通过观察最大数值的特征，发现只要result/10 <= max/10 就一定满足
                //因为 x10之后-->result <= max, 最后加上的余数，反转后是一定小于
                //max时的余数，所以公式成立
                return 0;
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }
}
