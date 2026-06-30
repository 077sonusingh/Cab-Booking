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

    @Override
    public void sendBookingEmail(Booking booking) {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo(booking.getEmail());

        mail.setSubject("Taxi Booking Confirmation");

        mail.setText(
                "Dear Customer,\n\n"
                + "Your taxi has been booked successfully.\n\n"
                + "Booking Details\n"
                + "---------------------------\n"
                + "Booking ID : " + booking.getBookingId() + "\n"
                + "Pickup City : " + booking.getPickupCity() + "\n"
                + "Drop City : " + booking.getDropCity() + "\n"
                + "Travel Date : " + booking.getTravelDate() + "\n"
                + "Cab Type : " + booking.getCabType() + "\n"
                + "Mobile : " + booking.getMobileNumber() + "\n\n"
                + "Thank you for choosing Abhishek Taxi Service.");

        sender.send(mail);
    }
}