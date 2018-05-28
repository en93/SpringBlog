package springblog.web;

//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import springblog.controller.BloggerController;

public class BloggerControllerTest {
	
	@Test
	public void shouldShowRegistration() throws Exception{
		BloggerController controller = new BloggerController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/blogger/register"))
			.andExpect(view().name("registerForm"));		
	}
}
