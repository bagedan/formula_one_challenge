package com.agoda.formula;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Tkachi on 6/18/2016.
 */
public class RacingTeamTest {

    @Test
    public void should_reduce_speed_on_handle() throws Exception {
        RacingTeam racingTeam = new RacingTeam(1);
        racingTeam.setCurrentSpeedMetersPerSecond(10);

        racingTeam.useHandle();

        assertThat(racingTeam.getCurrentSpeedMetersPerSecond(), is(8f));
    }

    @Test
    public void should_double_speed_on_nitro() throws Exception {
        RacingTeam racingTeam = new RacingTeam(1);
        racingTeam.setCurrentSpeedMetersPerSecond(10);

        racingTeam.useNitro();

        assertThat(racingTeam.getCurrentSpeedMetersPerSecond(), is(20f));
    }

    @Test
    public void should_not_exceed_max_speed_on_nitro() throws Exception {
        RacingTeam racingTeam = new RacingTeam(1);
        racingTeam.setCurrentSpeedMetersPerSecond(racingTeam.getMaxSpeedMetersPerSecond()-1);

        racingTeam.useNitro();

        assertThat(racingTeam.getCurrentSpeedMetersPerSecond(), is(racingTeam.getMaxSpeedMetersPerSecond()));
    }

    @Test
    public void should_not_use_nitro_more_then_once() throws Exception {
        RacingTeam racingTeam = new RacingTeam(1);
        racingTeam.setCurrentSpeedMetersPerSecond(10);

        racingTeam.useNitro();
        assertThat(racingTeam.getCurrentSpeedMetersPerSecond(), is(20f));
        racingTeam.useNitro();
        assertThat(racingTeam.getCurrentSpeedMetersPerSecond(), is(20f));
    }
}