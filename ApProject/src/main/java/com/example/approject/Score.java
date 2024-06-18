package com.example.approject;

import java.io.Serializable;

public class Score implements Serializable {
    private int best;

    public Score(int best) {
        this.best = best;
    }

    public int getBest() {
        return best;
    }

    public void setBest(int best) {
        this.best = best;
    }
}
