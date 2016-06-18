package com.agoda.formula.assesments;

import com.agoda.formula.RacingTeam;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SpeedAndPositionAssessmentTest {
    private SpeedAndPositionAssessment testee = new SpeedAndPositionAssessment();

    @Test
    public void should_adjust_position_and_speed() {
        RacingTeam racingTeam = new RacingTeam(1);
        List<RacingTeam> racingTeams = ImmutableList.of(racingTeam);
        testee.runAssessment(racingTeams, null, 2);
        assertThat(racingTeam.getCurrentPosition(), is(4f));
        assertThat(racingTeam.getCurrentSpeedMetersPerSecond(), is(4f));
        testee.runAssessment(racingTeams, null, 4);
        assertThat(racingTeam.getCurrentPosition(), is(16f));
        assertThat(racingTeam.getCurrentSpeedMetersPerSecond(), is(8f));
    }

    @Test
    public void should_speed_and_position_accordingly_near_max_speed() {
        RacingTeam racingTeam = new RacingTeam(1);
        float startSpeed = racingTeam.getMaxSpeedMetersPerSecond() - 1f;
        float acceleration = racingTeam.getAccelerationMetersPerSecondSquare();
        int time = 2;
        racingTeam.setCurrentSpeedMetersPerSecond(startSpeed);
        List<RacingTeam> racingTeams = ImmutableList.of(racingTeam);

        testee.runAssessment(racingTeams, null, time);

        assertThat(racingTeam.getCurrentSpeedMetersPerSecond(), is(racingTeam.getMaxSpeedMetersPerSecond()));
        assertTrue(racingTeam.getCurrentPosition() < startSpeed * time + acceleration * time * time / 2f);
    }

}