package com.agoda.formula.assesments;

import com.agoda.formula.FinishingStats;
import com.agoda.formula.RacingTeam;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Tkachi on 6/18/2016.
 */
public class FinishingAssessmentTest {

    private int trackLength = 10;
    private FinishingAssessment testee = new FinishingAssessment(trackLength);

    @Test
    public void should_move_to_finished_list(){
        List<RacingTeam> racingTeams = generateRacingTeamsList();
        List<FinishingStats> finishedList = new LinkedList<FinishingStats>();
        float currentTime = 10;
        testee.runAssessment(racingTeams, finishedList, currentTime);

        assertThat(finishedList.size(), is(4));
    }

    private List<RacingTeam> generateRacingTeamsList() {
        RacingTeam racingTeam1 = new RacingTeam(1);
        racingTeam1.setCurrentPosition(11f);
        RacingTeam racingTeam2 = new RacingTeam(2);
        racingTeam2.setCurrentPosition(9.9f);
        RacingTeam racingTeam3 = new RacingTeam(3);
        racingTeam3.setCurrentPosition(10.1f);
        RacingTeam racingTeam4 = new RacingTeam(4);
        racingTeam4.setCurrentPosition(10.2f);
        RacingTeam racingTeam5 = new RacingTeam(5);
        racingTeam5.setCurrentPosition(10.5f);

        List<RacingTeam> racingTeams = new LinkedList<RacingTeam>();

        racingTeams.add(racingTeam1);
        racingTeams.add(racingTeam2);
        racingTeams.add(racingTeam3);
        racingTeams.add(racingTeam4);
        racingTeams.add(racingTeam5);
        return racingTeams;
    }

}