//package springblog.data;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import springblog.Post;
//
//public class TempRepo implements PostRepository {
//
//	public List<Post> findPosts(long max, int count) {
//		List<Post> posts = new ArrayList<Post>();
//		for (int i=0; i<20; i++) {
//			posts.add(new Post("Post " + i,  new Date(),0.0,0.0));
//		}
//		return posts;
//	}
//
//}
