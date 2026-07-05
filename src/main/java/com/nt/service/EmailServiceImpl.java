package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.nt.entity.Booking;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender sender;

    private final String ADMIN_EMAIL = "077.sonusingh@gmail.com";

    @Override	
    public void sendBookingEmail(Booking booking) {

        // ==========================
        // Customer Mail
        // ==========================
        SimpleMailMessage customerMail = new SimpleMailMessage();

        customerMail.setTo(booking.getEmail());

        customerMail.setSubject("Taxi Booking Confirmation");

        customerMail.setText(
                "Dear Customer,\n\n"
                + "Your taxi has been booked successfully.\n\n"
                + "Booking Details\n"
                + "-------------------------\n"
                + "Booking ID : " + booking.getBookingId() + "\n"
                + "Pickup City : " + booking.getPickupCity() + "\n"
                + "Drop City : " + booking.getDropCity() + "\n"
                + "Travel Date : " + booking.getTravelDate() + "\n"
                + "Cab Type : " + booking.getCabType() + "\n"
                + "Trip Type : " + booking.getTripType() + "\n"
                + "Mobile : " + booking.getMobileNumber() + "\n\n"
                + "Thank you for choosing SwiftRide.");

        sender.send(customerMail);



        // ==========================
        // Admin Mail
        // ==========================
        SimpleMailMessage adminMail = new SimpleMailMessage();

        adminMail.setTo(ADMIN_EMAIL);

        adminMail.setSubject("🚖 New Taxi Booking Received");

        adminMail.setText(
                "A new taxi booking has been received.\n\n"
                + "Booking ID : " + booking.getBookingId() + "\n"
                + "Customer Email : " + booking.getEmail() + "\n"
                + "Customer Mobile : " + booking.getMobileNumber() + "\n"
                + "Pickup : " + booking.getPickupCity() + "\n"
                + "Drop : " + booking.getDropCity() + "\n"
                + "Travel Date : " + booking.getTravelDate() + "\n"
                + "Trip Type : " + booking.getTripType() + "\n"
                + "Cab Type : " + booking.getCabType());

        sender.send(adminMail);
    }
}