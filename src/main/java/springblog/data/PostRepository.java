package springblog.data;

import springblog.Post;
import java.util.List;

public interface PostRepository {
	List<Post> findPosts(long max, int count);
}
