package org.burgers.queue.play.queue.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@Component
public class MessageProducer {

    protected static final String MESSAGE_COUNT = "messageCount";

    @Autowired
    private JmsTemplate template = null;
    private int messageCount = 100;

    public void generateMessages() throws JMSException {
        for (int i = 0; i < messageCount; i++) {
            final int index = i;
            final String text = "Message number is " + i + ".";

            template.send(new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    TextMessage message = session.createTextMessage(text);
                    message.setIntProperty(MESSAGE_COUNT, index);

                    System.out.println("Sending message: " + text);

                    return message;
                }
            });
        }
    }
}
