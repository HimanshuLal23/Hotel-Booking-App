package com.example.hotelbookingservice.service;

import Model.Hotel;
import Model.Payment;
import Model.PaymentType;
import Model.Room;
import Model.User;
import Model.Bill;
import Model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    @Autowired
    private BillingService billingService;

    public Payment makePayment(User user,PaymentType paymentType,Hotel hotel,Room room,Booking booking) {
        Payment payment = new Payment(paymentType,room.getPrice(),true);
        return payment;
    }
}
