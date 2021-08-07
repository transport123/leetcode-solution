package com.samon.leetcodelib.leetcode_solution.src.leetcode.nocategory;



//偶然间想到的，如何求一个集合的所有子集
//以及求M个元素的集合的N个子集的方法
//1，分治递归的思想
//2, 二进制数01表示在或者不在，一直加到1111就等于所有的情况
//{1,2,3,4,5}
//m中的n：{1,2,3} {1,2,4} {1,2,5} {1,3,4} ....
//核心思想：寻找一个position,将对应position处的数值加一，初始在n-1处；
//当对应处的值不小于m时，则将position向左移动，并将对应处数值加一，并重置右侧所有元素（递增，且必须保证最后一个元素小于或等于m）
//如果小于m-1则position放置在最后一位，否则位置不变
public class SubSet {
}




//拓展：蓄水池抽样算法 https://www.jianshu.com/p/7a9ea6ece2af