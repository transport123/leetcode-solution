package com.samon.leetcodelib.leetcode_solution.src.leetcode;



import com.samon.leetcodelib.leetcode_solution.src.Execute.MyRunnable;

import java.util.HashMap;

//最大无重复子串
//核心是滑动窗口+重复字符的查询（使用hash）
//自己的方法在挪动时做了全部重置，所以必须清空map，否则判断条件会非常多。而且我这样其实复杂度基本还是n2，因为每次都从滑动后的起始点重新开始计算
//实际上第二个index可以保持不变，也就是正确的滑动方法
public class i03LongestNoRepeatSubString implements MyRunnable {


    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())
            return 0;
        int startIndex = 0;
        int endIndex = startIndex;
        int longestLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        do {
            char tmpchar = s.charAt(endIndex);
            if (map.containsKey(tmpchar) &&
                    map.get(tmpchar) >= startIndex && map.get(tmpchar)!=endIndex) {
                longestLength = Math.max(longestLength, endIndex - startIndex);
                startIndex = map.get(tmpchar) + 1;
                map.put(tmpchar, endIndex);
                endIndex = startIndex;
            } else {
                longestLength = Math.max(longestLength, endIndex - startIndex +1);
                map.put(tmpchar, endIndex);
                endIndex++;
            }


        } while (endIndex < s.length());

        return longestLength;
    }

    public int lengthOfLongestSubstringV2(String s) {
        int startIndex = 0;
        int endIndex = startIndex;
        int longestLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (endIndex < s.length()) {
            if (map.containsKey(s.charAt(endIndex))) {
                startIndex = Math.max(map.get(s.charAt(endIndex)) + 1, startIndex);//这一步很重要
            }
            longestLength = Math.max(longestLength, endIndex - startIndex + 1);
            map.put(s.charAt(endIndex), endIndex);
            endIndex++;
        }
        return longestLength;
    }


    // 我的方法将endIndex移回了 所以耗时多很多 因为endindex重复遍历了多次
    @Override
    public void run() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
