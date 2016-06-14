package com.agoda.formula;

import org.apache.commons.cli.*;

import java.util.List;

/**
 * Created by Bogdan_Tkach on 6/14/2016.
 */
public class FormulaOneMain {

    private final static String NUMBER_OF_TEAM_OPTION = "n";
    private final static String TRACK_LENGTH_METERS = "lm";

    private final static Options options;



    static {
        Option numberOfTeamOption = new Option(NUMBER_OF_TEAM_OPTION, true, "Number of participating teams");
        numberOfTeamOption.setRequired(true);
        Option trackLengthOption = new Option(TRACK_LENGTH_METERS, true, "Track length in meters");
        trackLengthOption.setRequired(true);

        options = new Options();
        options.addOption(numberOfTeamOption);
        options.addOption(trackLengthOption);
    }


    public static void main(String[] args) throws ParseException {
        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine commandLine = commandLineParser.parse(options, args);
        int numberOfTeams = Integer.parseInt(commandLine.getOptionValue(NUMBER_OF_TEAM_OPTION));
        int trackLengthMeters = Integer.parseInt(commandLine.getOptionValue(TRACK_LENGTH_METERS));

        RaceResultCalculator raceResultCalculator = new RaceResultCalculatorImpl(numberOfTeams, trackLengthMeters);
        List<FinishingStats> finishingStatsList = raceResultCalculator.calculateFinishingStatsForAllCars();

        printResults(finishingStatsList);
    }

    private static void printResults(List<FinishingStats> finishingStatsList) {
        for(int i = 0; i<finishingStatsList.size(); i++){
            FinishingStats current = finishingStatsList.get(i);
            System.out.printf("Team #%d finished after %d seconds after starts with speed %d", i+1, current.getTime(), current.getSpeed());
        }
    }

}
