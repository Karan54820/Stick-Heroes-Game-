package com.example.approject;

public class Player {
    private long score;
    private Cherries NoofCherries;
    private Stick stick;

    private Level level;

    private int Location;

    public void moveForward(){

    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public Cherries getCh() {
        return NoofCherries;
    }

    public void setCh(Cherries ch) {
        this.NoofCherries = ch;
    }

    public Stick getStick() {
        return stick;
    }

    public void setStick(Stick stick) {
        this.stick = stick;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
