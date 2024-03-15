package service;

import Repository.CityRepository;
import Repository.HotelRepository;
import Model.City;
import Model.Hotel;
import com.example.hotelbookingservice.Exception.CityNotFoundException;
import com.example.hotelbookingservice.Exception.HotelNotFoundException;
import com.example.hotelbookingservice.Label.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
public class HotelSearchService {

    private CityRepository cityRepository = CityRepository.getInstance();
    public Hotel searchHotel(@NonNull String cityName,@NonNull String hotelName) throws HotelNotFoundException,CityNotFoundException {
        City currentCity = getCity(cityName);
        Hotel hotel = getHotel(currentCity.getHotelList(),hotelName);
        return hotel;
    }
    private Hotel getHotel(List<Hotel> hotelList,String hotelName) throws HotelNotFoundException{
        for(var hotel:hotelList) {
            if(hotel.getName().equals(hotelName)) {
                return hotel;
            }
        }
        throw new HotelNotFoundException(Message.hotelNotFoundException);
    }
    private City getCity(String cityName) throws CityNotFoundException{
        List<City> cityList = cityRepository.getCityList();
        for(var city:cityList) {
            if(city.getName().equals(cityName)) {
                return city;
            }
        }
        throw new CityNotFoundException(Message.cityNotFoundException);
    }
}
