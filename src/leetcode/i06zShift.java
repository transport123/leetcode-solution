package com.samon.leetcodelib.leetcode_solution.src.leetcode;

import com.samon.leetcodelib.leetcode_solution.src.Execute.MyRunnable;

import java.util.ArrayList;
import java.util.List;

public class i06zShift implements MyRunnable {
    @Override
    public void run() {

        String src = "PAYPALISHIRING";
        String out = convertByRows(src,1);
        System.out.println(out);
    }

    public String convert(String s, int numRows) {
        return s;
    }

    public String convertByRows(String s, int numRows) {
        int rowSize = Math.min(s.length(), numRows);
        List<StringBuilder> results = new ArrayList<>();
        for (int i = 0; i < rowSize; i++) {
            results.add(new StringBuilder());
        }
        int rowIndex = 0;
        boolean isForward = true;//true代表向下，false向上
        for (int index = 0; index < s.length(); index++) {
            StringBuilder tmpSTB = results.get(rowIndex);
            tmpSTB.append(s.charAt(index));
            if (isForward && rowIndex < rowSize - 1) {
                rowIndex++;
            }
            if (!isForward && rowIndex > 0) {
                rowIndex--;
            }
            if (rowIndex == rowSize - 1) {
                isForward = false;
            }
            if (rowIndex == 0) {
                isForward = true;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rowSize; i++) {
            result.append(results.get(i));
        }
        return result.toString();


    }//顺序访问原字符串，将每个字符放入正确的行中。其实和二维数组的思想是一样的，只是我们不需要真正的二维数组，直接将字符加在后面就行

    public String convertByFormula(String s, int numRows) {
        return s;
    }//通过公式，顺序计算出第n次访问的字符所在的位置(k=行，列......)

}
