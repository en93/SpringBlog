package springblog.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springblog.Post;
import springblog.data.PostRepository;
import springblog.data.TempRepo;


@Controller
@RequestMapping("/posts")
public class PostController {
	
	private PostRepository postRepo;
	private static final String MAX_LONG_AS_STRING = "" + Long.MAX_VALUE;
	
	@Autowired
	public PostController(PostRepository postRepo) {		
		this.postRepo = postRepo;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String posts(Model model, 			
			@RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
			@RequestParam(value="count", defaultValue="20") int count){
		model.addAttribute("postList", postRepo.findPosts(max, count));
		return "posts";		
	}
}
