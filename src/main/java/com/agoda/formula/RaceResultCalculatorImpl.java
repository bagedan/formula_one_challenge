package com.agoda.formula;

import com.agoda.formula.assesments.Assessment;
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
    private List<RacingTeam> racingTeams;

    private List<Assessment> allAssesments;

    public RaceResultCalculatorImpl(int numberOfTeams, int trackLength, List<Assessment> allAssesments) {
        this.numberOfTeams = numberOfTeams;
        this.trackLength = trackLength;
        racingTeams = new ArrayList<RacingTeam>(numberOfTeams);
        results = new ArrayList<FinishingStats>(numberOfTeams);
        this.allAssesments = allAssesments;
        initTeams();
    }

    private void initTeams() {
        for(int i = 1;i<=numberOfTeams;i++){
            racingTeams.add(new RacingTeam(i));
        }
    }

    public List<FinishingStats> calculateFinishingStatsForAllCars() {
        return null;
    }

    void rearrangeRacingTeamStats(int timeFromLastArrangementSeconds){


    }

    @VisibleForTesting
    public List<RacingTeam> getRacingTeams() {
        return racingTeams;
    }

    @VisibleForTesting
    public RaceResultCalculatorImpl setRacingTeams(List<RacingTeam> racingTeams) {
        this.racingTeams = racingTeams;
        return this;
    }
}
