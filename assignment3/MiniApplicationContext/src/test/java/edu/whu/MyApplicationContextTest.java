package edu.whu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyApplicationContextTest {
    MyApplicationContext ctx;
    @Test
    void Test()
    {
        try {
            ctx = new MyApplicationContext("/applicationContext.xml");
            sender s=ctx.getBean("sender",sender.class);
            s.send();
            receiverImpl r=ctx.getBean("receiverImpl",receiverImpl.class);
            r.receive();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}