package com.bob.cloud.provider.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

public interface SinkSender {

	@Output(Sink.INPUT) // inputͨ�����
    MessageChannel output();
 
    @Output("input2") // input2ͨ�����,����ֱ��ע�� 
    MessageChannel output2();
}
