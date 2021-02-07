package com.hcl.feedbackForm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.feedbackForm.repositories.FeedbackRepository;
import com.hcl.feedbackForm.model.Feedback;

@Controller
public class FeedbackController {
	
	@Autowired
	private FeedbackRepository feedbackRepo; 
	public Feedback fb = new Feedback();
    
	@GetMapping("/")
	public String showService() {
		return "form";
	}
	
	@GetMapping("/feedback/{id}")
	public String showFeedbackById(@PathVariable Integer id, Model model) {
		Optional<Feedback> fb1 = feedbackRepo.findById(id);
		if(fb1.isPresent()) {
			Feedback f = fb1.get();
			model.addAttribute("name", f.getUser());
			model.addAttribute("comment", f.getComments());
		}else {
			model.addAttribute("error", "The item with this ID number does not exist.");
		}
		return "searchById";
	}

	@PostMapping("/submitFeedback")
	public String addFeedback(@RequestParam String user, @RequestParam int rating, @RequestParam String comments, Model model) {
		fb.setUser(user);
		fb.setRating(rating);
		fb.setComments(comments);
		
		feedbackRepo.save(fb);
		
		model.addAttribute("successMessage", "The feedback was successfully added");
		return "form";
	}
}
