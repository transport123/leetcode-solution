package com.samon.leetcodelib.leetcode_solution.src.Execute;


import com.samon.leetcodelib.leetcode_solution.src.leetcode.i06zShift;

public class Executor {
    public static void main(String[] args) {
        MyRunnable runnable = null;
        runnable = new i06zShift();
        if (runnable != null) {
            runnable.run();
        }
    }
}
