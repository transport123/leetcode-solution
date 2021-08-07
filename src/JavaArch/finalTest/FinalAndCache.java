package com.samon.leetcodelib.leetcode_solution.src.JavaArch.finalTest;


import com.samon.leetcodelib.leetcode_solution.src.Execute.MyRunnable;

public class FinalAndCache implements MyRunnable {

    public void testIntegerFinalCache() {

        System.out.println("测试-127~127");
        Integer x1 = 5;
        Integer x2 = 5;
        Integer x3 = new Integer(5);

        System.out.println("x1==x2?:" + (x1 == x2 ? "true" : "false"));
        System.out.println("x1==x3?:" + (x1 == x3 ? "true" : "false"));

        System.out.println("测试128");
        x1 = 128;
        x2 = 128;
        x3 = new Integer(128);

        System.out.println("x1==x2?:" + (x1 == x2 ? "true" : "false"));
        System.out.println("x1==x3?:" + (x1 == x3 ? "true" : "false"));

        // == 判断的是引用是否指向同一个对象
        // -127~127时，由于有常量池，所以个在使用=默认装箱时返回的是cache中的同一个对象； 当然new时自然就是不同的对象；
        //128在装箱时不会从常量池中拿取，所以都是new出来的 所以都不一样

    }

    public void testStringFinalCache() {
        // 注意String 的 intern 方法
        // String的缓存策略不太清楚，似乎都写在native层
        String x1 = "abc";
        String x2 = "abc";
        //x1==x2 为true
        String x3 = new String ("abc");
        // x3 为false


        //常量String在+时是在编译期间直接替换，如"JA"+"VA"直接就变成"JAVA"，所以x="JA"+"VA"就是 x="JAVA",也就是直接在常量池上分配
        //变量的+则是通过StringBuilder的append在堆区new出对象 new出的对象是不在常量池中的
        //当调用intern方法时，会判断常量池中是否有此字符串，如果有则会返回常量池中的引用；没有会将此字符串加入常量池，并返回这个引用；
        //注意：jdk1.7后不会加入常量池，而是将首次出现的字符串的引用加入常量池。如果不是首次出现，则什么都不做。
        ////附上一个链接：https://blog.csdn.net/tyyking/article/details/82496901


        //StringBuilder本身也是实现了CharSequence接口的。内部使用了char[]数组来实现

        //很重要： 当直接使用 双引号 编程时，不考虑拼接等复杂情况，一定会先在常量池中生成，后续在根据是否为new在堆区再生成相同的一份拷贝
        //拼接出来的不一定会在常量池中，直接"xxxx"的一定会在常量池中 或许这也是硬编码的一个坏处吧
        //为什么要用StringBuilder? 因为StringBuilder在append时是new出来的对象，是mutable的。
        //如果有过多的硬编码 x="accc";是不是会导致常量池过大呢？

        //正确的做法在使用某个object tostring或 getstring时，可能内部都是用char来在堆区构建新的String对象，这种情况是不会放在常量池中的


        //个人理解：事实上，运行时常量池是 具体的类自己设计出的一种机制，它并不是jvm本身就实现的一个功能
        //比如 final ClassA obj = new ClassA(); 这个对象肯定会new出一个新对象，它也不会加入“常量池”中
        //并不是打上了final标记就放在常量池中，final只是表示这是一个不可变的变量
        //String,Integer的常量池都是自己类内部实现的 本质上还是在堆区

    }

    @Override
    public void run() {
        testIntegerFinalCache();

        testStringFinalCache();
    }
}
