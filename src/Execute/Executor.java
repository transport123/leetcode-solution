package Execute;


import leetcode.i03LongestNoRepeatSubString;
import leetcode.i04MidNumber;

public class Executor {
    public static void main(String[] args) {
        MyRunnable runnable = null;
        runnable = new i04MidNumber();
        if (runnable != null) {
            runnable.run();
        }

    }
}
