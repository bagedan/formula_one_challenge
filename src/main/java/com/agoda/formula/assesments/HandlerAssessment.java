package com.agoda.formula.assesments;

import com.agoda.formula.FinishingStats;
import com.agoda.formula.RacingTeam;

import java.util.List;
import java.util.TreeSet;

/**
 * Created by Tkachi on 6/18/2016.
 */
public class HandlerAssessment implements Assessment {

    private final float handlingDistance;

    public HandlerAssessment(float handlingDistance){
        this.handlingDistance = handlingDistance;
    }
    public void runAssessment(List<RacingTeam> racingTeams, List<FinishingStats> finishedTeams, float currentTime) {
        TreeSet<Float> locations = new TreeSet<>();
        for(RacingTeam racingTeam:racingTeams){
            locations.add(racingTeam.getCurrentPosition());
        }

        for(int i=0;i<racingTeams.size();i++){
            float currentTeamPosition = racingTeams.get(i).getCurrentPosition();

            if(locations.subSet(currentTeamPosition - handlingDistance, true, currentTeamPosition + handlingDistance, true).size()>1){
                racingTeams.get(i).useHandle();
            }
        }
    }
}
