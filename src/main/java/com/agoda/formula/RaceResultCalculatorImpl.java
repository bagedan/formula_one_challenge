package com.agoda.formula;

import com.google.common.annotations.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bogdan_Tkach on 6/14/2016.
 */
public class RaceResultCalculatorImpl implements RaceResultCalculator {

    private final int numberOfTeams;
    private final int trackLength;

    private List<FinishingStats> results;
    private List<TeamCurrentStats> teamCurrentStats;

    public RaceResultCalculatorImpl(int numberOfTeams, int trackLength) {
        this.numberOfTeams = numberOfTeams;
        this.trackLength = trackLength;
        teamCurrentStats = new ArrayList<TeamCurrentStats>(numberOfTeams);
        results = new ArrayList<FinishingStats>(numberOfTeams);
        initTeams();
    }

    private void initTeams() {
        for(int i = 1;i<=numberOfTeams;i++){
            teamCurrentStats.add(new TeamCurrentStats(i));
        }
    }

    public List<FinishingStats> calculateFinishingStatsForAllCars() {
        return null;
    }

    @VisibleForTesting
    public List<TeamCurrentStats> getTeamCurrentStats() {
        return teamCurrentStats;
    }
}
