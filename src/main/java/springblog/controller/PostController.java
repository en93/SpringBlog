package springblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springblog.data.PostRepository;

@Controller
@RequestMapping("/posts")
public class PostController {
	
	private PostRepository postRepo;
	
	@Autowired
	public PostController(PostRepository postRepo) {
		this.postRepo = postRepo;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String posts(Model model) {
		model.addAttribute(postRepo.findPosts(Long.MAX_VALUE, 20));
		return "posts";
	}
}
