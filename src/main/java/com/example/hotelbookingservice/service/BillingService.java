package com.example.hotelbookingservice.service;

import Model.Payment;
import Model.Bill;
import Model.User;
import Model.Hotel;
import Model.Booking;
import org.springframework.stereotype.Component;

@Component
public class BillingService {
    public Bill createBill(Payment payment,User user,Hotel hotel,Booking booking) {
        Bill bill = new Bill(payment.getPaymentId(),user.getUserId(),hotel.getHotelId(),booking.getBookingId());
        return bill;
    }
}
