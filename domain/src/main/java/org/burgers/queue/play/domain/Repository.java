package org.burgers.queue.play.domain;

import java.util.List;

public interface Repository {
    public void save(Movie movie);
    public void delete(Movie movie);
    public Movie findById(long id);
    public List findAll();
    public void deleteAll();
    public void markAsWatched();
    
}
