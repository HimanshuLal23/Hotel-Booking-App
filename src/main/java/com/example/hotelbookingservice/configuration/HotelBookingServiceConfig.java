package com.example.hotelbookingservice.configuration;


import com.example.hotelbookingservice.service.BillingService;
import com.example.hotelbookingservice.service.PaymentService;
import com.example.hotelbookingservice.service.BookingService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;


@Lazy
@Configuration
@Import({
        PaymentService.class,
        BillingService.class,
        BookingService.class
})
public class HotelBookingServiceConfig {
}
