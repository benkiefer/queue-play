package org.burgers.queue.play.listener;

import org.burgers.queue.play.client.ExternalMovie;
import org.burgers.queue.play.client.MessageProducer;
import org.burgers.queue.play.client.MessageServiceClient;
import org.burgers.queue.play.domain.Movie;
import org.burgers.queue.play.domain.Repository;
import org.burgers.queue.play.domain.RepositoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:contexts/TestListenerContext.xml"})
public class JmsMessageListenerIntegrationTest {
    @Autowired
    private MessageServiceClient messageServiceClient;

    @Autowired
    private Repository repository;

    @Test
    public void sendStringMessage() throws JMSException, InterruptedException {
        messageServiceClient.addMovie("Jaws");
        Thread.sleep(1000);
        List results = repository.findAll();
        assertEquals(results.size(), 1);
        Movie movie = (Movie) results.get(0);
        assertEquals(movie.getTitle(), "Jaws");
        assertFalse(movie.isWatched());
    }

    @Test
    public void sendObjectMessage() throws JMSException, InterruptedException {
        ExternalMovie movie1 = new ExternalMovie();
        movie1.setTitle("Jaws");
        movie1.setWatched(true);

        messageServiceClient.addMovie(movie1);

        Thread.sleep(1000);

        List results = repository.findAll();
        assertEquals(results.size(), 1);
        Movie movie = (Movie) results.get(0);
        assertEquals(movie.getTitle(), "Jaws");
        assertTrue(movie.isWatched());
        repository.deleteAll();
    }

    @After
    public void tearDown(){
        repository.deleteAll();
    }
}
