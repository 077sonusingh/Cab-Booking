package com.nt.service;

import com.nt.entity.Booking;

public interface EmailService {

    void sendBookingEmail(Booking booking);

}