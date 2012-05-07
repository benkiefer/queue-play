package org.burgers.queue.play.client;

import java.io.Serializable;

public class ExternalMovie implements Serializable {
    private String title;
    private boolean watched = false;

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
