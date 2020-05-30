package com.spring.test.aop;

import com.spring.test.aop.user.UserService;
import com.spring.test.aop.user.UserServiceImpl;
import org.junit.Test;

/**
 * Created on 2020/5/29
 */
public class ProxyTest {

    @Test
    public void testProxy() {
        UserService userService = new UserServiceImpl();

        MyInvocationHandler handler = new MyInvocationHandler(userService);
        UserService handlerProxy = (UserService) handler.getProxy();
        handlerProxy.add();
    }
}
