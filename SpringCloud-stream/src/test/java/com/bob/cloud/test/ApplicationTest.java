package com.bob.cloud.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import com.bob.cloud.provider.Main;
import com.bob.cloud.provider.stream.SinkSender;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class ApplicationTest {

    @Autowired
    private SinkSender sinkSender;
 
    @Test
    public void contextLoads() {
        //output����ע��󶨵���"input"ͨ��
        sinkSender.output().send(MessageBuilder.withPayload("**************From SinkSender").build());
    }

}


