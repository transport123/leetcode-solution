package com.samon.leetcodelib.leetcode_solution.src.JavaArch.enclosingPrivate;



public class TestPrivateOuter extends TestPrivate {

    public void accessMethod()
    {
        TestPrivate testPrivate = new TestPrivate();
        //testPrivate.myPrivateMethod(); not okay
        testPrivate.forChild();//ok
    }
}
