package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.entity.Review;

public interface IReviewService {

    void saveReview(Review review);

    //List<Review> getAllReviews();
    
    Page<Review> getAllReviews(Pageable pageable);
    
    Review getImageId(Integer id);

}