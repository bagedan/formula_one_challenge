package com.agoda.formula.assesments;

import com.agoda.formula.FinishingStats;
import com.agoda.formula.RacingTeam;

import java.util.List;

/**
 * Created by Tkachi on 6/18/2016.
 */
public class LastPositionAssessment implements Assessment {
    @Override
    public void runAssessment(List<RacingTeam> racingTeams, List<FinishingStats> finishedTeams, float currentTime) {
        racingTeams.sort((o1, o2) -> Float.compare(o1.getCurrentPosition(), o2.getCurrentPosition()));
        RacingTeam lastTeam = racingTeams.get(0);
        lastTeam.useNitro();
        float lastPosition = lastTeam.getCurrentPosition();
        //just in case we have several teams on last place
        for(int i=1 ;i<racingTeams.size();i++){
            if(racingTeams.get(i).getCurrentPosition() == lastPosition){
                racingTeams.get(i).useNitro();
            } else{
                break;
            }
        }
    }
}
