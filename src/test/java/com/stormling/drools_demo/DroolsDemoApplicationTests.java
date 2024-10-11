package com.stormling.drools_demo;

import com.stormling.drools_demo.model.Order;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DroolsDemoApplicationTests {

    @Autowired
    private KieContainer kieContainer;

    @Test
    public void test() {
        KieSession kieSession = kieContainer.newKieSession();

        Order order = new Order();
        order.setAmount(99);

        kieSession.insert(order);

        kieSession.fireAllRules();

        //关闭会话
        kieSession.dispose();

        System.out.println("订单金额：" + order.getAmount() + "积分：" + order.getScore());
    }

}
