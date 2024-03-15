package com.example.hotelbookingservice.service;

import Model.Booking;
import Model.Hotel;
import Model.Room;
import Model.User;
import Model.Bill;
import Model.PaymentType;
import Model.Payment;

import com.example.hotelbookingservice.Exception.ExceptionType;
import com.example.hotelbookingservice.Exception.HotelBookingException;
import com.example.hotelbookingservice.Label.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingService {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private BillingService billingService;
    private Bill bill;
    public Booking bookRoom(User user, Hotel hotel, Room room, PaymentType paymentType) throws HotelBookingException {
        Booking booking = new Booking(user.getUserId(),hotel.getHotelId(),room.getRoomId());
        Payment payment = paymentService.makePayment(user,paymentType,hotel,room,booking);
        if(payment.isSuccess()) {
            bill = billingService.createBill(payment,user,hotel,booking);
            booking.setBill(bill);
            user.addBooking(booking);
            return booking;
        }
        throw new HotelBookingException(ExceptionType.BookingFailureException,Message.bookingFailure);
    }
}
