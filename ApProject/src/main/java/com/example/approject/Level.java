package com.example.approject;

import java.util.ArrayList;

public class Level {
    ArrayList<Player> PlayerList = new ArrayList<>();

    private int LevelNo;

    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public ArrayList<Player> getPlayerList() {
        return PlayerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        PlayerList = playerList;
    }

    public int getLevelNo() {
        return LevelNo;
    }

    public void setLevelNo(int levelNo) {
        LevelNo = levelNo;
    }
}
