package com.samon.leetcodelib.leetcode_solution.src.leetcode;



import com.samon.leetcodelib.leetcode_solution.src.Execute.MyRunnable;

public class i05LongestPalindromicSubString implements MyRunnable {
    @Override
    public void run() {

    }


    public String longestPalindrome(String s) {

        return null;
    }


    public String symmetricWay(String s) {
        int n = s.length();
        int l =0;
        int r =0;
        String result = "";
        for(int i =0;i<n*2-1;i++)
        {
            l=i/2;
            if(i%2==0){
                r=l;
            }else{
                r=l+1;
            }
            while(l>=0&&r<n&&s.charAt(l)==s.charAt(r))
            {
                l--;
                r++;
            }
            l++;
            r--;//恢复
            if(r<l)
                l=r;
            if(r-l+1>=result.length())
                result = s.substring(l,++r);

        }
        return result;
    }// 对称式方法

    //to-do 利用寻找公共子串的动态规划（矩阵对角线）

    // 另一种动态规划

    //马拉车

}
