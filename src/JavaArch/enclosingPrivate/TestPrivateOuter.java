package JavaArch.enclosingPrivate;

import JavaArch.enclosingPrivate.TestPrivate;

public class TestPrivateOuter extends TestPrivate {

    public void accessMethod()
    {
        TestPrivate testPrivate = new TestPrivate();
        //testPrivate.myPrivateMethod(); not okay
        testPrivate.forChild();//ok
    }
}
