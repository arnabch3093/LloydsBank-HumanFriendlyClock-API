package LloydsBankHumanFriendlyClockAPI.endpoints;

import LloydsBankHumanFriendlyClockAPI.response.HumanFriendlyClockResponseBody;
import LloydsBankHumanFriendlyClockAPI.service.HumanFriendlyClockService;
import LloydsBankHumanFriendlyClockAPI.service.IHumanFriendlyClockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;


@RestController
public class HumanFriendlyClockApi {

    @GetMapping(value = "/humanfriendlytime/{time}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HumanFriendlyClockResponseBody HumanFreindlyTime(@PathVariable String time){

        IHumanFriendlyClockService service = new HumanFriendlyClockService();
        HumanFriendlyClockResponseBody responseBody = new HumanFriendlyClockResponseBody();
        try{
            responseBody = service.getHumanFriendlyTime(time);
            return responseBody;
        } catch (Exception exception){
            responseBody.setHumanFriendlyTime("");
            responseBody.setErrorDescription(exception.getMessage());
            return responseBody;
        }

    }
}
