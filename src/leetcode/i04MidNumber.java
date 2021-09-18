package com.samon.leetcodelib.leetcode_solution.src.leetcode;


import com.samon.leetcodelib.leetcode_solution.src.Execute.MyRunnable;

public class i04MidNumber implements MyRunnable {
    @Override
    public void run() {

        int[] num1 = {1, 4, 5, 7, 8, 9};
        int[] num2 = {3};
        //1 2 3 3 4 4 5
        double x = findMedianSortedArrays(num1, num2);
        System.out.println(x);
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) % 2 == 0) {
            //偶数返回平均值
            double k1 = getKthElement(nums1, nums2, (nums1.length + nums2.length) / 2);
            double k2 = getKthElement(nums1, nums2, (nums1.length + nums2.length) / 2 + 1);
            return (k1 + k2) / 2;
        } else {
            return getKthElement(nums1, nums2, (nums1.length + nums2.length) / 2 + 1);
        }

    }


    public double BinarySearchVersion(int[] nums1, int[] nums2) {
        return 0;
    }

    //非递归方法
    public int getKthElement(int[] nums1, int[] nums2, int k) {//寻找两个数组第K大的数
        if (k > nums1.length + nums2.length)
            return 0;
        //left代表已经排除掉的数组的最后一个元素
        int left1 = -1;
        int left2 = -1; //当前数组开始的位置，因为会根据比较截取掉k/2
        int right1 = 0;
        int right2 = 0;//当前需要比较的位置
        while (true) {

            //当left已经到达了数组的末尾，说明这个数组已经完全被排除
            //先判断数组的边界情况，避免在k=1的情况下访问出界
            if (left1 == nums1.length - 1)
                return nums2[k  +left2];
            if (left2 == nums2.length - 1)
                return nums1[k  +left1];

            if (k == 1)//取出当前的最小的即可
                return Math.min(nums1[left1 + 1], nums2[left2 + 1]);


            //先考虑不越界的正常情况
            right1 = Math.min(left1 + k / 2, nums1.length - 1);
            right2 = Math.min(left2 + k / 2, nums2.length - 1);
            if (nums1[right1] >= nums2[right2]) {//如何优雅的处理数组越界
                //谁小，排除谁

                k = k - (right2 - left2);
                left2 = right2;


            } else {
                k = k - (right1 - left1);
                left1 = right1;
            }
            //1    2 3 4
        }

        //k=1的时候是返回触发条件 第一大，说明直接取出比较值中的小值就是返回值
        //且K的变化不能直接用K/2，因为1，存在奇偶的情况，我们一次只能排除X个数，
        //本质上是在剩下的数中找到第K-X大的数
        //2，存在数组越界的情况，X可能因为数组边界而小于K/2

    }

    //递归版本

    public double easyVersion2(int[] nums1, int[] nums2) {//复杂度为n+m
        int tmp_1 = 0;
        int tmp_2 = 0;
        int flag_1 = 0;
        int flag_2 = 0;//将flag理解为遍历的次数，而不理解为当前下标
        do {
            if (flag_2 == nums2.length ||
                    (flag_1 < nums1.length && nums1[flag_1] < nums2[flag_2])) {
                tmp_1 = nums1[flag_1];
                flag_1++;
            }

            if (flag_1 == nums1.length ||
                    (flag_2 < nums2.length && nums2[flag_2] < nums1[flag_1])) {
                tmp_2 = nums2[flag_2];
                flag_2++;
            }
        }
        while (flag_1 + flag_2 <= (nums1.length + nums2.length) / 2 + 1);

        if ((tmp_1 + tmp_2) % 2 == 0) {
            double x = tmp_1 + tmp_2;
            return x / 2;
        } else {
            return Math.max(tmp_1, tmp_2);
        }
    }


    // 改不好了
    public double easyVersion(int[] nums1, int[] nums2) {//复杂度为n+m

        int n = nums1.length;
        int m = nums2.length;

        int flag_n = 0;
        int flag_m = 0;
        //start----边界情况
        if (n == 0 & m == 0)
            return 0;

        int[] des = null;
        if (n == 0) {
            des = nums2;
        }
        if (m == 0) {
            des = nums1;
        }

        if (des != null) {
            if (des.length % 2 == 0) {
                double x = des[des.length / 2 - 1] + des[des.length / 2];
                return x / 2;
            }
            return des[des.length / 2];
        }
        //end----边界情况

        while (flag_m + flag_n < (n + m) / 2) {
            if ((flag_n < n - 1 && nums1[flag_n] < nums2[flag_m])
                    || flag_m == m - 1) {
                flag_n++;
            }
            if ((flag_m < m - 1 && nums2[flag_m] < nums1[flag_n])
                    || flag_n == n - 1) {
                flag_m++;
            }
        }

        if ((n + m) % 2 == 0) {
            double x;
            if (nums1[flag_n] > nums2[flag_m]) {
                x = nums1[flag_n - 1] + nums2[flag_m];
            } else {
                x = nums1[flag_n] + nums2[flag_m - 1];
            }

            return x / 2;
        } else {
            return Math.min(nums1[flag_n], nums2[flag_m]);
        }

    }
//问题：跳出条件写的有问题。要作完一次比较后，合并的数组才加入一个值，所以到达数组边界并不能停止，要把数组边界的值也比较了才行
//但是这样后面一次循环又可能会数组越界。写的很糟糕
}
