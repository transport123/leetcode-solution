package Execute;

import leetcode.TowSum01;

public class Executor {
    public static void main(String[] args) {
        MyRunnable runnable = null;
        runnable = new TowSum01();
        if (runnable != null) {
            runnable.run();
        }
    }
}
