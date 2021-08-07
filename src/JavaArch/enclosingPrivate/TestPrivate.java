package com.samon.leetcodelib.leetcode_solution.src.JavaArch.enclosingPrivate;


import com.samon.leetcodelib.leetcode_solution.src.Execute.MyRunnable;

public class TestPrivate implements MyRunnable {

    private TestPrivate A;//自己持有一个相同类型的引用是没问题的，想想ListNode 持有的 next就知道了。只要在程序逻辑上没问题就行，因为归根到底这个引用只是一个指针而已。

    private int prParam = 0;

    public TestPrivate()
    {
       // A  = new TestPrivate();//这样会爆栈，因为是无限循环调用下去的，很好理解。
    }

    private void myPrivateMethod()
    {
        System.out.println("TestPrivate:myPrivateMethod");
    }

    protected void forChild()
    {
        System.out.println("TestPrivate:forChild");
    }

    public void myPublicMethod(){
        System.out.println("TestPrivate:myPublicMethod");

        myPrivateMethod();//事实说明这样子是没问题的。
        prParam = 19;
        System.out.println(prParam);
        //在类本身定义好的公共方法中是可以随意访问私有的成员或者变量的
    }

    public void testIrAccess()
    {
        irClass ir = new irClass();
        ir.irParam =10;//可以访问
    }

    @Override
    public void run() {
        myPublicMethod();
    }



    public static class TestPrivateInherit extends TestPrivate{


        public void childMethod()
        {
            System.out.println("TestPrivateInherit:childMethod");
            forChild();//ok
            //this.myPrivateMethod();//not ok 说明子类不可直接访问父类私有方法。很奇怪
            TestPrivate testPrivate = new TestPrivate();
            testPrivate.myPrivateMethod();//ok 经过验证 好像是和静态内部类有关系，可以通过对象访问私有的
            //外部类就不可以这样做 继承不继承 都不行

            TestPrivate anotherThis = this;
            anotherThis.myPrivateMethod();//这样子居然可以。。
        }

        @Override
        public void run()
        {
            childMethod();
        }
    }

    public static class irClass{
        private int irParam;

        public void accessTest(){
            TestPrivate testPrivate = new TestPrivate();
            testPrivate.myPrivateMethod();
        }
    }

    public static class irClass2{
        public void accessIr()
        {
            irClass irClass = new irClass();
            irClass.irParam =10;// ok
            //看来写在一个类文件中时，是可以互相访问对方的私有变量的。。

            // 详细的解释看explanation
            /*
            简单来说这是 嵌套类的 问题
            java的语音规范：enclosing和inner class 是可以互相访问私有变量的
            jvm的实现：jvm是不管什么内部类，外部类的，对他来说就是top-level的顶层类
            这样就出现了问题，所以在编译时解决了问题
            即编译时动态的生成 提供外部访问的方法体 access&0 等

            而继承之后不可访问的问题，猜测是判断了有继承的关系，优先使用了protected这种机制，而没有去生成这种临时方法
            也就是继承关系中，子类只可访问protected方法的优先级大于了 enclosing和inner class 访问的优先级
             */
        }
        public static void test()
        {

        }
    }
}
/*
普通内部类不可拥有静态的方法或者变量。
只能拥有静态常量

 */