package com.agoda.formula.assesments;

import com.agoda.formula.FinishingStats;
import com.agoda.formula.RacingTeam;

import java.util.List;

/**
 * Created by Tkachi on 6/18/2016.
 */
public class FinishingAssessment implements Assessment {

    private final float trackLengthMeters;

    public FinishingAssessment(float trackLengthMeters) {
        this.trackLengthMeters = trackLengthMeters;
    }

    public void runAssessment(List<RacingTeam> racingTeams, List<FinishingStats> finishedTeams, float currentTime) {
        for(int i=0;i<racingTeams.size();i++){
            RacingTeam racingTeam = racingTeams.get(i);
            if(racingTeam.getCurrentPosition()>=trackLengthMeters){
                FinishingStats finishingStats = new FinishingStats(racingTeam.getTeamId(), racingTeam.getCurrentSpeedMetersPerSecond(), currentTime);
                System.out.println("Racing team[" + racingTeam + "] finshed race");
                racingTeams.remove(i--);
                finishedTeams.add(finishingStats);
            }
        }
    }
}
