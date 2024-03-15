package com.example.hotelbookingservice.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HotelBookingException extends Exception{
    private ExceptionType exceptionType;
    private String message;
}
