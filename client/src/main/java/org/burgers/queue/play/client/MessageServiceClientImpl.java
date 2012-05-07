package org.burgers.queue.play.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Queue;

@Component
public class MessageServiceClientImpl implements MessageServiceClient{

    @Autowired
    private MessageProducer messageProducer;

    @Override
    public void addMovie(String title) throws JMSException {
        messageProducer.send(title);
    }

    @Override
    public void addMovie(ExternalMovie movie) throws JMSException {
        messageProducer.sendObject(movie);
    }

    public void setMessageProducer(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }
}
