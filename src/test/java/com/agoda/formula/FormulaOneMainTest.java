package com.agoda.formula;


import org.apache.commons.cli.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class FormulaOneMainTest {

    @Mock
    private RaceResultCalculator raceResultCalculator;

    private FormulaOneMain testee = spy(new FormulaOneMain());

    @Test
    public void should_fail_when_no_arguments_provided() {
        try {
            testee.main(new String[0]);
            fail();
        } catch (ParseException e) {
            System.out.println("Thrown expected exception [" + e.getMessage() + "]");
        }
    }

    @Test
    public void should_fail_when_number_of_teams_not_provided() {
        try {
            testee.main(new String[]{"-lm", "100"});
            fail();
        } catch (ParseException e) {
            System.out.println("Thrown expected exception [" + e.getMessage() + "]");
        }
    }

    @Test
    public void should_fail_when_track_length_not_provided() {
        try {
            testee.main(new String[]{"-n", "100"});
            fail();
        } catch (ParseException e) {
            System.out.println("Thrown expected exception [" + e.getMessage() + "]");
        }
    }

}