package com.example.th.whackamolever10;

public class ScoreBoard {
    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ScoreBoard(String name, int score) {

        this.name = name;
        this.score = score;
    }
}
