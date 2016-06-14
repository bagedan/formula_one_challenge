package com.agoda.formula;

import java.util.List;

/**
 * Created by Bogdan_Tkach on 6/14/2016.
 */
public class RaceResultCalculatorImpl implements RaceResultCalculator {

    private final int numberOfTeams;
    private final int trackLength;

    public RaceResultCalculatorImpl(int numberOfTeams, int trackLength) {
        this.numberOfTeams = numberOfTeams;
        this.trackLength = trackLength;
    }

    public List<FinishingStats> calculateFinishingStatsForAllCars() {
        return null;
    }

}
