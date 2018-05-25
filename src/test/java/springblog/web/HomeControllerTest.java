package springblog.web;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
//import org.springframework.stereotype.Component;
import springblog.controller.HomeController;

public class HomeControllerTest {
	
	@Test
	public void testHomePage() throws Exception{
		HomeController controller = new HomeController();
		assertEquals("home", controller.home());
	}
}
