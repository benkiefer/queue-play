package org.burgers.queue.play.client;

import javax.jms.JMSException;

public interface MessageServiceClient {
    public void addMovie(String title) throws JMSException;
}
