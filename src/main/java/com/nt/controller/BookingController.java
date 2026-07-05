package com.nt.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.Booking;
import com.nt.entity.City;
import com.nt.entity.Review;
import com.nt.service.BookingService;
import com.nt.service.ICityService;
import com.nt.service.IReviewService;

@Controller
public class BookingController {

    @Autowired
    private BookingService service;
    
    @Autowired
    private IReviewService reviewService;
    
    @Autowired
    private ICityService cityService;

    @GetMapping("/")
    public String home(
            @RequestParam(defaultValue = "0") int page,
            Model model) {

        model.addAttribute("booking", new Booking());

        Pageable pageable = PageRequest.of(page, 3); // 3 reviews per page

        Page<Review> reviewPage = reviewService.getAllReviews(pageable);

        model.addAttribute("reviews", reviewPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", reviewPage.getTotalPages());

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
    public String saveReview(@ModelAttribute Review review,
                             @RequestParam("imageFile") MultipartFile file) throws IOException {
    	
    	System.out.println("File Name : " + file.getOriginalFilename());
        System.out.println("File Size : " + file.getSize());
        System.out.println("Content Type : " + file.getContentType());
    	
    	if (!file.isEmpty()) {
    	    review.setImage(file.getBytes());
    	}

        reviewService.saveReview(review);

        return "redirect:/";
    }
    
    
    @GetMapping("/review/image/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable Integer id) {

        Review review = reviewService.getImageId(id);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // or detect the type
                .body(review.getImage());
    }
    
    
    @GetMapping("/cities")
    @ResponseBody
    public List<City> searchCity(@RequestParam String keyword){

        return cityService.searchCity(keyword);

    }
   
}
