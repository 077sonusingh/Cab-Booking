package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Booking;
import com.nt.repository.BookingRepository;


@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository repository;
    
    @Autowired
    private EmailService emailService;

    @Override
    public Booking saveBooking(Booking booking) {
    	
    	Booking saved = repository.save(booking);

        emailService.sendBookingEmail(saved);

        //booking.setFare(calculateFare(booking));

        return saved;
    }

	/*
	 * @Override public double calculateFare(Booking booking) {
	 * 
	 * double fare = 0;
	 * 
	 * switch (booking.getCabType()) {
	 * 
	 * case "Sedan Cab": fare = 12; break;
	 * 
	 * case "SUV Cab": fare = 18; break;
	 * 
	 * case "Luxury Cab": fare = 25; break;
	 * 
	 * default: fare = 10; }
	 * 
	 * // Example calculation return fare * 100; }
	 */

}