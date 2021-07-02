package Execute;


import leetcode.i03LongestNoRepeatSubString;

public class Executor {
    public static void main(String[] args) {
        MyRunnable runnable = null;
        runnable = new i03LongestNoRepeatSubString();
        if (runnable != null) {
            runnable.run();
        }

    }
}
