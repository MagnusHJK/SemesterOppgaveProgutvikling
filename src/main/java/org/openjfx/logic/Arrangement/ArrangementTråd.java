package org.openjfx.logic.Arrangement;

import javafx.concurrent.Task;

public class ArrangementTråd extends Task<Void> {
    private Runnable kjørMegNårFerdig;

    public ArrangementTråd(Runnable ferdigFunk) {
        this.kjørMegNårFerdig = ferdigFunk;
    }

    @Override
    protected Void call() throws Exception {

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {

        }

        return null;
    }

    @Override
    protected void succeeded() {
        kjørMegNårFerdig.run();
    }
}
