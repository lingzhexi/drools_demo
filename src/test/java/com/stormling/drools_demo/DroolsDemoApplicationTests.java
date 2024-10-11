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
        //从Kie容器对象中获取会话对象
        KieSession kieSession = kieContainer.newKieSession();

        // Fact 事实对象 Order
        Order order = new Order();
        order.setAmount(1300);

        // 将Order对象数据插入工作内存中
        kieSession.insert(order);

        // 激活规则，由Drools框架自动进行规则匹配，如果规则匹配成功，则执行当前规则
        kieSession.fireAllRules();

        // 关闭会话
        kieSession.dispose();
        System.out.println("订单金额：" + order.getAmount() + "积分：" + order.getScore());
    }

}
