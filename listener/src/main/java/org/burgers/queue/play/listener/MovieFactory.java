package org.burgers.queue.play.listener;

import org.burgers.queue.play.client.ExternalMovie;
import org.burgers.queue.play.domain.Movie;

public class MovieFactory {
    public Movie createFrom(ExternalMovie movie){
        return new Movie(movie.getTitle(), movie.isWatched());
    }
}
