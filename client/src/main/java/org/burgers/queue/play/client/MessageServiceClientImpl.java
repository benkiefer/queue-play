package org.burgers.queue.play.client;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Queue;


public class MessageServiceClientImpl implements MessageServiceClient{
    private JmsTemplate jmsTemplate;

    @Override
    public void addMovie(String title) {
        jmsTemplate.convertAndSend(title);
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
