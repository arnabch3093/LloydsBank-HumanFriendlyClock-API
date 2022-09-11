package LloydsBankHumanFriendlyClockAPI.service;

import LloydsBankHumanFriendlyClockAPI.exception.CustomException;
import LloydsBankHumanFriendlyClockAPI.response.HumanFriendlyClockResponseBody;

public interface IHumanFriendlyClockService {

    HumanFriendlyClockResponseBody getHumanFriendlyTime(String time) throws CustomException;
    String convertToHumanFriendlyTime(int hours, int mins);

}
