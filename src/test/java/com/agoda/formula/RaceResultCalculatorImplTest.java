package com.agoda.formula;

import com.agoda.formula.assesments.*;
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
    private final float rearrangeTimeWindow = 2;

    private RaceResultCalculatorImpl testee = new RaceResultCalculatorImpl(numberOfTeams, trackLength, getListOfAllRequiredAssessments(trackLength), rearrangeTimeWindow);

    @Test
    public void should_return_result_for_all_teams() {
        List<FinishingStats> result = testee.calculateFinishingStatsForAllCars();
        assertThat(result.size(), is(numberOfTeams));
    }

    @Test
    public void should_init_teams_stats_according_the_rules() {
        List<RacingTeam> startStats = testee.getRacingTeams();
        for (int i = 1; i <= startStats.size(); i++) {
            RacingTeam stats = startStats.get(i - 1);
            assertThat(stats.getTeamId(), is(i));
            assertThat(stats.getCurrentPosition(), is(-200f * (i - 1)));
            assertThat(stats.getMaxSpeedMetersPerSecond(), is((150f + 10f * i) * 1000f / 3600f));
            assertThat(stats.getAccelerationMetersPerSecondSquare(), is(2f * i));
            assertThat(stats.getHandlingFactor(), is(0.8f));
            assertThat(stats.getCurrentSpeedMetersPerSecond(), is(0f));
        }
    }

    @Test
    public void should_provide_result_for_all_teams() {
        List<FinishingStats> finishedTeams = testee.calculateFinishingStatsForAllCars();

        List<RacingTeam> racingTeams = testee.getRacingTeams();

        assertThat(finishedTeams.size(), is(numberOfTeams));
        assertThat(racingTeams.size(), is(0));
    }

    private List<Assessment> getListOfAllRequiredAssessments(float trackLength) {
        return ImmutableList.<Assessment>of(
                new SpeedAndPositionAssessment(),
                new FinishingAssessment(trackLength),
                new HandlerAssessment(10),
                new LastPositionAssessment()
        );
    }


}