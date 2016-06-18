package com.agoda.formula.assesments;

import com.agoda.formula.RacingTeam;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Tkachi on 6/18/2016.
 */
public class LastPositionAssessmentTest {

    private LastPositionAssessment testee = new LastPositionAssessment();

    @Test
    public void should_use_nitro_for_all_last() {
        float currentSpeed = 1f;
        RacingTeam racingTeam1 = new RacingTeam(1);
        racingTeam1.setCurrentPosition(5);
        racingTeam1.setCurrentSpeedMetersPerSecond(currentSpeed);
        RacingTeam racingTeam2 = new RacingTeam(2);
        racingTeam2.setCurrentPosition(5);
        racingTeam2.setCurrentSpeedMetersPerSecond(currentSpeed);
        RacingTeam racingTeam3 = new RacingTeam(3);
        racingTeam3.setCurrentPosition(10);
        racingTeam3.setCurrentSpeedMetersPerSecond(currentSpeed);

        List<RacingTeam> racingTeams = new LinkedList<RacingTeam>();

        racingTeams.add(racingTeam1);
        racingTeams.add(racingTeam2);
        racingTeams.add(racingTeam3);

        testee.runAssessment(racingTeams, null, 2f);

        assertThat(racingTeam1.getCurrentSpeedMetersPerSecond(), is(2f));
        assertThat(racingTeam2.getCurrentSpeedMetersPerSecond(), is(2f));
        assertThat(racingTeam3.getCurrentSpeedMetersPerSecond(), is(1f));

    }

}