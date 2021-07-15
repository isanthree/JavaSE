package com.isanthree.inner_class;

import org.junit.Test;

public class InnerClassTest {
    @Test
    public void test() {
        Outer outer = new Outer();
        // 通过外部类实例 outer 来实例化内部类 memberInner
        Outer.MemberInner memberInner = outer.new MemberInner();
        memberInner.in();
        memberInner.outputID();
    }
}
