package LloydsBankHumanFriendlyClockAPI.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HumanFriendlyClockResponseBody {

    private String humanFriendlyTime;
    private String errorDescription;
}
