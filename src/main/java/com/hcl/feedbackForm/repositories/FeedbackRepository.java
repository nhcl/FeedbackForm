package com.hcl.feedbackForm.repositories;

import org.springframework.data.repository.CrudRepository;
import com.hcl.feedbackForm.model.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer>{

}
