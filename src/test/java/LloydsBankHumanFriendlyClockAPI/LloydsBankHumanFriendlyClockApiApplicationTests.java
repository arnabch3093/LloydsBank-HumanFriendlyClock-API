package LloydsBankHumanFriendlyClockAPI;

import LloydsBankHumanFriendlyClockAPI.service.HumanFriendlyClockService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class LloydsBankHumanFriendlyClockApiApplicationTests {

	@Test
	public void HumanFriendlyTimeTest() {

		HumanFriendlyClockService service = new HumanFriendlyClockService();

		Assertions.assertEquals("twelve o' clock", service.convertToHumanFriendlyTime(12,00));
		Assertions.assertEquals("twelve o' clock", service.convertToHumanFriendlyTime(00, 00));
		Assertions.assertEquals("eight minutes past one", service.convertToHumanFriendlyTime(13, 8));
		Assertions.assertEquals("quarter to four", service.convertToHumanFriendlyTime(15, 45));
		Assertions.assertEquals("quarter past three", service.convertToHumanFriendlyTime(15, 15));
		Assertions.assertEquals("half past three", service.convertToHumanFriendlyTime(15, 30));
		Assertions.assertEquals("one minute past three", service.convertToHumanFriendlyTime(15, 1));
		Assertions.assertEquals("one minute to four", service.convertToHumanFriendlyTime(15, 59));
		Assertions.assertEquals("twenty five minutes to four", service.convertToHumanFriendlyTime(15, 35));
		Assertions.assertEquals("quarter to one", service.convertToHumanFriendlyTime(00, 45));
	}

}
