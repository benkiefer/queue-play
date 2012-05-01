package org.burgers.queue.play.listener;

import org.burgers.queue.play.client.MessageProducer;
import org.burgers.queue.play.client.MessageServiceClient;
import org.burgers.queue.play.domain.Movie;
import org.burgers.queue.play.domain.Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:contexts/TestListenerContext.xml"})
public class MessageTest {
    @Autowired
    private MessageServiceClient messageServiceClient;

    @Autowired
    private Repository repository;

    @Test
    public void doIt() throws JMSException {
        messageServiceClient.addMovie("Jaws");
        List results = repository.findAll();
        assertEquals(results.size(), 1);
        Movie movie = (Movie) results.get(0);
        assertEquals(movie.getTitle(), "Jaws");
        assertFalse(movie.isWatched());
    }

}
