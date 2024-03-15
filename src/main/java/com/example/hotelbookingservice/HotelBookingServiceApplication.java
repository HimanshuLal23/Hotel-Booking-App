package com.example.hotelbookingservice;

import Model.City;
import Model.Hotel;
import Model.Room;
import Model.RoomType;
import Model.PaymentType;
import Model.User;
import com.example.hotelbookingservice.Exception.BookingFailureException;
import com.example.hotelbookingservice.Exception.CityNotFoundException;
import com.example.hotelbookingservice.Exception.HotelNotFoundException;
import com.example.hotelbookingservice.Exception.RoomUnavailableException;
import com.example.hotelbookingservice.Label.Message;
import com.example.hotelbookingservice.service.BookingService;
import com.example.hotelbookingservice.service.RoomSelectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import service.HotelSearchService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import Repository.UserRepository;
import Repository.CityRepository;
import Repository.HotelRepository;



@SpringBootApplication
public class HotelBookingServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HotelBookingServiceApplication.class,args);
        Hotel hotel = new Hotel("Taj","Gateway of India,Mumbai","123456789");
        Room room = new Room(RoomType.DELUXE,1,2,2);
        hotel.addRooms(room,3);
        User user = new User("xyz",213456789);
        City city = new City("Delhi",231076,"MH");
        city.addHotel(hotel);
        HotelSearchService hotelSearchService = new HotelSearchService();
        UserRepository userRepository = UserRepository.getInstance();
        userRepository.addUser(user);

        CityRepository cityRepository = CityRepository.getInstance();
        cityRepository.addCity(city);

        HotelRepository hotelRepository = HotelRepository.getInstance();
        hotelRepository.addHotel(hotel);
        Logger logger = LoggerFactory.getLogger(HotelBookingServiceApplication.class);
        try {
            Hotel searchedHotel = hotelSearchService.searchHotel("Delhi","Taj");
            Room currentRoom = RoomSelectService.selectHotelRoom(searchedHotel,RoomType.DELUXE);
            BookingService bookingService = context.getBean(BookingService.class);
            bookingService.bookRoom(user,searchedHotel,currentRoom, PaymentType.UPI);
            logger.info(Message.hotelBookedSuccessfully);
        }catch (HotelNotFoundException hotelNotFoundException) {
            logger.error(hotelNotFoundException.getMessage());
        }catch (CityNotFoundException cityNotFoundException) {
            logger.error(cityNotFoundException.getMessage());
        }catch (RoomUnavailableException roomUnavailableException) {
            logger.error(roomUnavailableException.getMessage());
        }catch (BookingFailureException bookingFailureException) {
            logger.error(bookingFailureException.getMessage());
        }
    }

}
