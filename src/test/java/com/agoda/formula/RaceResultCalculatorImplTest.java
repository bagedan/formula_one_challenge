package com.agoda.formula;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Bogdan_Tkach on 6/14/2016.
 */
public class RaceResultCalculatorImplTest {

    private final int numberOfTeams = 5;
    private final int trackLength = 100;

    private RaceResultCalculatorImpl raceResultCalculator = new RaceResultCalculatorImpl(numberOfTeams, trackLength);

    @Test
    public void should_return_result_for_all_teams(){
        List<FinishingStats> result = raceResultCalculator.calculateFinishingStatsForAllCars();
        assertThat(result.size(), is(numberOfTeams));
    }

    @Test
    public void should_init_teams_stats_according_the_rules(){
        List<TeamCurrentStats> startStats = raceResultCalculator.getTeamCurrentStats();
        for(int i = 1; i<=startStats.size();i++){
            TeamCurrentStats stats = startStats.get(i-1);
            assertThat(stats.getTeamId(), is(i));
            assertThat(stats.getCurrentPosition(), is (-200f*(i-1)));
            assertThat(stats.getMaxSpeedMetersPerSecond(), is((150f + 10f*i)*1000f/3600f));
            assertThat(stats.getAccelerationMetersPerSecondSquare(), is(2f*i));
            assertThat(stats.getHandlingFactor(), is(0.8f));
            assertThat(stats.getCurrentSpeed(), is(0f));
        }
    }




}