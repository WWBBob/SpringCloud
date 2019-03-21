package com.bob.cloud.provider.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(value = {Sink.class})
public class SinkReceiver {
	
	private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);
	
	@StreamListener(Sink.INPUT)//�������εķ���ע��Ϊ��Ϣ�м�������������¼���������
	public void receive(Object payload) {
		System.err.println("=======================");
        logger.info("Received: " + String.valueOf(payload));
    }
}
