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
			.setSingleView(new InternalResourceView("WEB-INF/views/posts.jsp"))
			.build();
		mockMvc.perform(get("/posts"))
			.andExpect(view().name("posts"))
			.andExpect(model().attributeExists("postList"))
			.andExpect(model().attribute("postList", hasItems(expectedPosts.toArray())));		
	}
	
	@Test
	public void shouldShowPagedPosts() throws Exception{
		List<Post> expectedPosts = createPostList(50);
		PostRepository mockRepository = mock(PostRepository.class);
		when(mockRepository.findPosts(238900, 50)).thenReturn(expectedPosts);
		PostController controller = new PostController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller)
			.setSingleView(new InternalResourceView("WEB-INF/views/posts.jsp"))
			.build();
		mockMvc.perform(get("/posts?max=238900&count=50"))
			.andExpect(view().name("posts"))
			.andExpect(model().attributeExists("postList"))
			.andExpect(model().attribute("postList", hasItems(expectedPosts.toArray())));
		
	}
	
	@Test
	public void testPost() throws Exception{
		Post expectedPost = new Post("Hello", new Date(), 0.0, 0.0);
		PostRepository mockRepository = mock(PostRepository.class);
		when(mockRepository.findOne(12345)).thenReturn(expectedPost);
		PostController controller = new PostController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/posts/12345"))
			.andExpect(view().name("post"))
			.andExpect(model().attributeExists("post"))
			.andExpect(model().attribute("post", expectedPost));
	}
	
	private List<Post> createPostList(int count){
		List<Post> posts = new ArrayList<Post>();
		for (int i=0; i<count; i++) {
			posts.add(new Post("Post " + i,  new Date(),0.0,0.0));
		}
		return posts;
	}
}// 
