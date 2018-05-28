package springblog.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springblog.Post;
import springblog.data.PostRepository;
import springblog.data.TempRepo;

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
		model.addAttribute("postList", postRepo.findPosts(Long.MAX_VALUE, 20));
		return "posts";
	}
}
