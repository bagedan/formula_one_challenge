package com.agoda.formula;

/**
 * Created by Bogdan_Tkach on 6/14/2016.
 */
public class TeamCurrentStats {
    private final int teamId;
    private final float maxSpeedMetersPerSecond;
    private final float accelerationMetersPerSecondSquare;

    private final float handlingFactor = 0.8f;
    private float currentPosition;
    private float currentSpeed;
    private boolean nitroUsed;

    /**
     * This constructor is used to create a team following standard rules - speed is 150 + 10i and acceleration is 2i
     * @param teamId
     */
    public TeamCurrentStats(int teamId) {
        this(teamId, kphToMps(150f + 10f*teamId), 2f*teamId, -200f*(teamId-1f));
    }

    public TeamCurrentStats(int teamId, float maxSpeedMetersPerSecond, float accelerationMetersPerSecondSquare, float startPosition) {
        this.teamId = teamId;
        this.maxSpeedMetersPerSecond = maxSpeedMetersPerSecond;
        this.accelerationMetersPerSecondSquare = accelerationMetersPerSecondSquare;
        currentPosition = startPosition;
        nitroUsed = false;
    }

    public int getTeamId() {
        return teamId;
    }

    public float getMaxSpeedMetersPerSecond() {
        return maxSpeedMetersPerSecond;
    }

    public float getAccelerationMetersPerSecondSquare() {
        return accelerationMetersPerSecondSquare;
    }

    public float getHandlingFactor() {
        return handlingFactor;
    }

    public float getCurrentPosition() {
        return currentPosition;
    }

    public float getCurrentSpeed() {
        return currentSpeed;
    }

    public boolean isNitroUsed() {
        return nitroUsed;
    }

    private static float kphToMps(float speedKmPerHour) {
        return speedKmPerHour*1000f/3600f;
    }
}
