package JavaArch.finalTest;

import Execute.MyRunnable;

public class TestStaticInvoke implements MyRunnable {

    static {
//        public static int a =1; wrong!这里就只是一个代码块而已 触发顺序和写的顺序一样
        System.out.println("testStatic");
    }

    @Override
    public void run() {
        TestStaticInvoke testStaticInvoke;
        TestStaticInvoke testStaticInvokeInstance = new TestStaticInvoke();//初始化的触发时机
    }
}
