package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.entity.Booking;
import com.nt.entity.Review;
import com.nt.service.BookingService;
import com.nt.service.IReviewService;

@Controller
public class BookingController {

    @Autowired
    private BookingService service;
    
    @Autowired
    private IReviewService reviewService;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("booking", new Booking());

        model.addAttribute("reviews",
                reviewService.getAllReviews());

        return "index";
    }
    
//    @PostMapping("/checkFare")
//    public String checkFare(@ModelAttribute Booking booking,
//                            Model model) {
//
//        double fare = service.calculateFare(booking);
//
//        booking.setFare(fare);
//
//        model.addAttribute("booking", booking);
//
//        model.addAttribute("fare", fare);
//
//        return "index";
//    }

    @PostMapping("/bookCab")
    public String bookCab(@ModelAttribute Booking booking,
                          Model model) {

        Booking saved = service.saveBooking(booking);

        model.addAttribute("message",
                "Booking Successful. Booking Id : " + saved.getBookingId());

        return "success";
    }
    
    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
    
    @GetMapping("/review")
    public String reviewForm(Model model){

        model.addAttribute("review", new Review());

        return "review";
    }
    
    @PostMapping("/saveReview")
    public String saveReview(@ModelAttribute Review review){

        reviewService.saveReview(review);

        return "redirect:/";
    }
   
}
