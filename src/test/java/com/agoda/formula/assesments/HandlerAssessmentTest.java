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
public class HandlerAssessmentTest {
    private HandlerAssessment testee = new HandlerAssessment(10f);

    @Test
    public void should_use_handler_in_all_required_teams(){
        RacingTeam racingTeam1 = new RacingTeam(1);
        racingTeam1.setCurrentPosition(5);
        RacingTeam racingTeam2 = new RacingTeam(2);
        racingTeam2.setCurrentPosition(15);
        RacingTeam racingTeam3 = new RacingTeam(3);
        racingTeam3.setCurrentPosition(26);
        RacingTeam racingTeam4 = new RacingTeam(4);
        racingTeam4.setCurrentPosition(37);
        RacingTeam racingTeam5 = new RacingTeam(5);
        racingTeam5.setCurrentPosition(48);
        RacingTeam racingTeam6 = new RacingTeam(6);
        racingTeam6.setCurrentPosition(48);

        List<RacingTeam> racingTeams = new LinkedList<RacingTeam>();

        racingTeams.add(racingTeam1);
        racingTeams.add(racingTeam2);
        racingTeams.add(racingTeam3);
        racingTeams.add(racingTeam4);
        racingTeams.add(racingTeam5);
        racingTeams.add(racingTeam6);

        float startSpeed = 1f;
        for(RacingTeam racingTeam:racingTeams){
            racingTeam.setCurrentSpeedMetersPerSecond(startSpeed);
        }

        testee.runAssessment(racingTeams, null, 0);

        assertThat(racingTeam1.getCurrentSpeedMetersPerSecond(), is(0.8f));
        assertThat(racingTeam2.getCurrentSpeedMetersPerSecond(), is(0.8f));
        assertThat(racingTeam3.getCurrentSpeedMetersPerSecond(), is(1f));
        assertThat(racingTeam4.getCurrentSpeedMetersPerSecond(), is(1f));
        assertThat(racingTeam5.getCurrentSpeedMetersPerSecond(), is(0.8f));
        assertThat(racingTeam6.getCurrentSpeedMetersPerSecond(), is(0.8f));
    }

}