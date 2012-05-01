package org.burgers.queue.play.client;

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

    @Autowired
    private JmsTemplate template = null;

    public void send(String myMessage) throws JMSException {
        final String title = myMessage;
        template.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage();
                message.setStringProperty("title", title);
                return message;
            }
        });
    }
}
