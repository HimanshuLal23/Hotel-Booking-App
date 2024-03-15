package service;

import Repository.CityRepository;
import Model.City;
import Model.Hotel;
import com.example.hotelbookingservice.Exception.ExceptionType;
import com.example.hotelbookingservice.Exception.HotelBookingException;
import com.example.hotelbookingservice.Label.Message;
import org.springframework.lang.NonNull;

import java.util.List;
public class HotelSearchService {

    private CityRepository cityRepository = CityRepository.getInstance();
    public Hotel searchHotel(@NonNull String cityName,@NonNull String hotelName) throws HotelBookingException {
        City currentCity = getCity(cityName);
        Hotel hotel = getHotel(currentCity.getHotelList(),hotelName);
        return hotel;
    }
    private Hotel getHotel(List<Hotel> hotelList,String hotelName) throws HotelBookingException{
        for(var hotel:hotelList) {
            if(hotel.getName().equals(hotelName)) {
                return hotel;
            }
        }
        throw new HotelBookingException(ExceptionType.HotelNotFoundException,Message.hotelNotFoundException);
    }
    private City getCity(String cityName) throws HotelBookingException{
        List<City> cityList = cityRepository.getCityList();
        for(var city:cityList) {
            if(city.getName().equals(cityName)) {
                return city;
            }
        }
        throw new HotelBookingException(ExceptionType.CityNotFoundException,Message.cityNotFoundException);
    }
}
