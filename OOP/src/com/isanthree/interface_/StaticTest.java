package com.isanthree.interface_;

import org.junit.Test;

public class StaticTest {
    /**
     * 测试接口定义的 static、default 等方法
     */
    @Test
    public void test() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.defaultMethod();  // 接口中，默认方法由接口实现类的对象调用

//        userService.staticMethod();  // error，接口中，静态方法只能由接口自己调用
        UserService.staticMethod();
    }

    /**
     * 测试「当子类调用父类和接口的同名同属性方法时，程序的执行」
     * 结果：在子类没有相关实现的情况下，子类对象默认调用父类的同名同属性方法 —— 类优先原则
     * （这里可以去看看类 HelpWho 或 运行一下 helpWhoTest() 测试方法）
     *
     * PS：如果实现类实现了多个接口，这些接口定义了同名同属性的默认方法，那么，在实现类没有重写该方法的情况下，编译报错 —— 接口冲突
     *      - 解决方案：在实现类中重写该同名同属性方法
     **/
    @Test
    public void testSameMethod() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.sameMethod();

        userService.interfaceSameMethod();
    }

    @Test
    public void helpWhoTest() {
        System.out.println("NPC: 你妈和你媳妇同时落水，你要救谁？");
        HelpWho helpWho = new HelpWho();
        helpWho.help();
    }
}
