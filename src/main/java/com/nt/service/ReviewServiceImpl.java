package com.nt.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.entity.Review;
import com.nt.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements IReviewService {

	@Autowired
	private ReviewRepository repo;

	@Override
	public void saveReview(Review review) {

		review.setReviewDate(LocalDate.now());

		review.setApproved(true);

		repo.save(review);
	}

	@Override
	public Page<Review> getAllReviews(Pageable pageable) {

		return repo.findAll(pageable);

	}

	@Override
	public Review getImageId(Integer id) {
		return repo.findById(id).orElseThrow();
	}

}