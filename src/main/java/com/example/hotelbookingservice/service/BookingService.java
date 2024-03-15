package com.example.hotelbookingservice.service;

import Model.Booking;
import Model.Hotel;
import Model.Room;
import Model.User;
import Model.Bill;
import Model.PaymentType;
import Model.Payment;

import com.example.hotelbookingservice.Exception.BookingFailureException;
import com.example.hotelbookingservice.Label.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BookingService {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private BillingService billingService;
    private Bill bill;
    public Booking bookRoom(User user, Hotel hotel, Room room, PaymentType paymentType) throws BookingFailureException {
        Booking booking = new Booking(user.getUserId(),hotel.getHotelId(),room.getRoomId());
        Payment payment = paymentService.makePayment(user,paymentType,hotel,room,booking);
        if(payment.isSuccess()) {
            bill = billingService.createBill(payment,user,hotel,booking);
            booking.setBill(bill);
            user.addBooking(booking);
            return booking;
        }
        throw new BookingFailureException(Message.bookingFailure);
    }
}
