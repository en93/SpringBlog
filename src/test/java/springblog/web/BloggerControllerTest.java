package springblog.web;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import springblog.Post;
import springblog.controller.PostController;
import springblog.data.PostRepository;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
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
