package leetcode;

import Execute.MyRunnable;

public class i04MidNumber implements MyRunnable {
    @Override
    public void run() {

        int[] num1 = {1, 4, 5, 7, 8, 9};
        int[] num2 = {3, 4, 6, 12};
        //1 2 3 3 4 4 5
        double x = easyVersion(num1, num2);
        System.out.println(x);
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        return 0;

    }


    public double KthVersion(int[] nums1, int[] nums2)
    {
        return 0;
    }

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
