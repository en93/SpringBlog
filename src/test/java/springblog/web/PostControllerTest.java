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



public class PostControllerTest {
	
	@Test
	public void shouldShowRecentPosts() throws Exception{
		List<Post> expectedPosts = createPostList(20);
		PostRepository mockRepository = mock(PostRepository.class);
		when(mockRepository.findPosts(Long.MAX_VALUE, 20)).thenReturn(expectedPosts);
		PostController controller = new PostController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller)
			.setSingleView(new InternalResourceView("/WEB-INF/views/posts.jsp"))
			.build();
		mockMvc.perform(get("/posts"))
			.andExpect(view().name("posts"))
			.andExpect(model().attributeExists("postList"))
			.andExpect(model().attribute("postList", hasItems(expectedPosts.toArray())));
		
	}
	
	private List<Post> createPostList(int count){
		List<Post> posts = new ArrayList<Post>();
		for (int i=0; i<count; i++) {
			posts.add(new Post("Post " + i,  new Date(),0.0,0.0));
		}
		return posts;
	}
}// 
