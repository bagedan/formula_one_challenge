package com.agoda.formula;

/**
 * Created by Bogdan_Tkach on 6/14/2016.
 */
public class FinishingStats {

    private float speed;
    private int time;

    public FinishingStats(float speed, int time) {
        this.speed = speed;
        this.time = time;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
