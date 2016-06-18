package com.agoda.formula;

import com.agoda.formula.assesments.Assessment;
import com.agoda.formula.assesments.SpeedAndPositionAssessment;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Bogdan_Tkach on 6/14/2016.
 */
public class RaceResultCalculatorImplTest {

    private final int numberOfTeams = 5;
    private final int trackLength = 100;

    private RaceResultCalculatorImpl raceResultCalculator = new RaceResultCalculatorImpl(numberOfTeams, trackLength, getListOfAllRequiredAssessments());

    @Test
    public void should_return_result_for_all_teams(){
        List<FinishingStats> result = raceResultCalculator.calculateFinishingStatsForAllCars();
        assertThat(result.size(), is(numberOfTeams));
    }

    @Test
    public void should_init_teams_stats_according_the_rules(){
        List<RacingTeam> startStats = raceResultCalculator.getRacingTeams();
        for(int i = 1; i<=startStats.size();i++){
            RacingTeam stats = startStats.get(i-1);
            assertThat(stats.getTeamId(), is(i));
            assertThat(stats.getCurrentPosition(), is (-200f*(i-1)));
            assertThat(stats.getMaxSpeedMetersPerSecond(), is((150f + 10f*i)*1000f/3600f));
            assertThat(stats.getAccelerationMetersPerSecondSquare(), is(2f*i));
            assertThat(stats.getHandlingFactor(), is(0.8f));
            assertThat(stats.getCurrentSpeedMetersPerSecond(), is(0f));
        }
    }

    @Test
    public void should_increase_speed_after_start(){
        int teamsNumber = 2;
        int rearrangeTime = 2;
        RaceResultCalculatorImpl raceResultCalculator = new RaceResultCalculatorImpl(teamsNumber, Integer.MAX_VALUE, getListOfAllRequiredAssessments());

        raceResultCalculator.rearrangeRacingTeamStats(rearrangeTime);

        List<RacingTeam> statsAfterTwoSec = raceResultCalculator.getRacingTeams();

        assertThat(statsAfterTwoSec.size(), is(teamsNumber));
        assertThat(statsAfterTwoSec.get(0).getCurrentSpeedMetersPerSecond(), is(statsAfterTwoSec.get(0).getAccelerationMetersPerSecondSquare()*rearrangeTime));
        assertThat(statsAfterTwoSec.get(1).getCurrentSpeedMetersPerSecond(), is(statsAfterTwoSec.get(1).getAccelerationMetersPerSecondSquare()*rearrangeTime));

    }

    private List<Assessment> getListOfAllRequiredAssessments(){
        return ImmutableList.<Assessment>of(
                new SpeedAndPositionAssessment()
        );
    }




}