package org.burgers.queue.play.listener;

import org.burgers.queue.play.client.ExternalMovie;
import org.burgers.queue.play.domain.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MovieFactoryTest {
    MovieFactory movieFactory;

    @Before
    public void setUp() throws Exception {
        movieFactory = new MovieFactory();
    }

    @Test
    public void testCreateFrom() throws Exception {
        ExternalMovie movie = new ExternalMovie();
        movie.setTitle("bob");
        movie.setWatched(true);

        Movie result = movieFactory.createFrom(movie);
        assertEquals(result.getTitle(), movie.getTitle());
        assertEquals(result.isWatched(), movie.isWatched());
    }
}
