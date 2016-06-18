package com.agoda.formula.assesments;

import com.agoda.formula.FinishingStats;
import com.agoda.formula.RacingTeam;

import java.util.List;

/**
 * Created by Tkachi on 6/15/2016.
 */
public interface Assessment {

    public void runAssessment(List<RacingTeam> racingTeams, List<FinishingStats> finishedTeams, float currentTime);
}
