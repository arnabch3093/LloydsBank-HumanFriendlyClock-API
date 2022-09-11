package LloydsBankHumanFriendlyClockAPI.service;

import LloydsBankHumanFriendlyClockAPI.exception.CustomException;
import LloydsBankHumanFriendlyClockAPI.exception.CustomExceptionType;
import LloydsBankHumanFriendlyClockAPI.response.HumanFriendlyClockResponseBody;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HumanFriendlyClockService implements IHumanFriendlyClockService{


    private static final Logger LOGGER = Logger.getLogger(HumanFriendlyClockService.class.getName());

    @Override
    public HumanFriendlyClockResponseBody getHumanFriendlyTime(String time) throws CustomException {

        HumanFriendlyClockResponseBody responseBody = new HumanFriendlyClockResponseBody();
        int[] timeIntFormat = validateInput(time);
        String humanFriendlyTime = convertToHumanFriendlyTime(timeIntFormat[0], timeIntFormat[1]);
        // LOGGER.log(Level.INFO, humanFriendlyTime); -- If debug message required
        responseBody.setHumanFriendlyTime(humanFriendlyTime);
        responseBody.setErrorDescription("");

        return responseBody;
    }

    @Override
    public String convertToHumanFriendlyTime(int hours, int mins) {

        String humanFriendlyTime="";
        String[] friendlyTimes = {"twelve", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen", "twenty", "twenty one",
                "twenty two", "twenty three", "twenty four",
                "twenty five", "twenty six", "twenty seven",
                "twenty eight", "twenty nine"};

        if (hours > 12)
            hours = hours - 12;

        if(mins == 0)
            humanFriendlyTime = friendlyTimes[hours] + " o' clock";
        else if(mins == 1)
            humanFriendlyTime = "one minute past " + friendlyTimes[hours];
        else if(mins == 15)
            humanFriendlyTime = "quarter past " + friendlyTimes[hours];
        else if (mins == 30)
            humanFriendlyTime = "half past " + friendlyTimes[hours];
        else if (mins == 45)
            humanFriendlyTime = "quarter to " + friendlyTimes[(hours % 12) + 1];
        else if(mins == 59)
            humanFriendlyTime = "one minute to " + friendlyTimes[(hours % 12) + 1];
        else if (mins <= 30)
            humanFriendlyTime = friendlyTimes[mins] + " minutes past " + friendlyTimes[hours];
        else if (mins > 30)
            humanFriendlyTime = friendlyTimes[60 - mins] + " minutes to " + friendlyTimes[(hours % 12) + 1];

        return humanFriendlyTime;
    }

    private static int[] validateInput(String time) throws CustomException {
        int[] timeInt = new int[2];
        int hours, minutes;

        if(time == null || time.isEmpty())
            throw new CustomException(CustomExceptionType.INVALID_INPUT);

        try{
            String[] timeInHHMM = time.split(":");
            hours = Integer.parseInt(timeInHHMM[0]);
            minutes = Integer.parseInt(timeInHHMM[1]);
            timeInt[0] = hours;
            timeInt[1] = minutes;
        } catch (Exception ce){
            throw new CustomException(CustomExceptionType.INVALID_FORMAT);
        }

        if(timeInt[0]<0 || timeInt[0]>23)
            throw new CustomException(CustomExceptionType.INVALID_INPUT);

        if(timeInt[1]<0 || timeInt[1]>59)
            throw new CustomException(CustomExceptionType.INVALID_INPUT);

        return timeInt;
    }
}
