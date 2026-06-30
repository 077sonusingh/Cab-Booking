package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Review;
import com.nt.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements IReviewService{

    @Autowired
    private ReviewRepository repo;

    @Override
    public void saveReview(Review review) {
        repo.save(review);
    }

    @Override
    public List<Review> getAllReviews() {
        return repo.findAll();
    }

}