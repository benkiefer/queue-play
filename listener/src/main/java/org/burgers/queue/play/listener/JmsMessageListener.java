package org.burgers.queue.play.listener;


import org.burgers.queue.play.client.ExternalMovie;
import org.burgers.queue.play.domain.Movie;
import org.burgers.queue.play.domain.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class JmsMessageListener implements MessageListener {
    @Autowired
    private Repository repository;
    private MovieFactory factory = new MovieFactory();

    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            processTextMessage((TextMessage) message);
        } else if (message instanceof ObjectMessage) {
            processObjectMessage((ObjectMessage) message);

        }
    }

    private void processObjectMessage(ObjectMessage message) {
        try {
            repository.save(factory.createFrom((ExternalMovie) message.getObject()));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private void processTextMessage(TextMessage tm) {
        try {
            if (tm.propertyExists("title")) {
                repository.save(new Movie(tm.getStringProperty("title"), false));
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}
