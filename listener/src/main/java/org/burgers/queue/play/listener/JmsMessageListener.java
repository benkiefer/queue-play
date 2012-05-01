package org.burgers.queue.play.listener;


import org.burgers.queue.play.domain.Movie;
import org.burgers.queue.play.domain.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class JmsMessageListener implements MessageListener {
    @Autowired
    private Repository repository;

    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage tm = (TextMessage) message;
            String title = null;
            try {
                title = tm.getStringProperty("title");
            } catch (JMSException e) {
                e.printStackTrace();
            }
            repository.save(new Movie(title, false));
        }
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}
