package Execute;

import JavaArch.enclosingPrivate.TestPrivate;

public class Executor {
    public static void main(String[] args) {
        MyRunnable runnable = null;
        runnable = new TestPrivate.TestPrivateInherit();
        if (runnable != null) {
            runnable.run();
        }
    }
}
