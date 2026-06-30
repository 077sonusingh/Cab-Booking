package com.nt.service;

import java.util.List;

import com.nt.entity.Review;

public interface IReviewService {

    void saveReview(Review review);

    List<Review> getAllReviews();

}