package org.burgers.queue.play.queue.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:contexts/QueueContext.xml"})
public class MessageTest {
    @Autowired
    private MessageProducer messageProducer;

    @Test
    public void doIt() throws JMSException {
        messageProducer.generateMessages();
    }


    public void setMessageProducer(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }
}
