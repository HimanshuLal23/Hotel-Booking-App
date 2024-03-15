package Model;

import java.util.ArrayList;
import java.util.List;
import Model.Hotel;

public class City {

    private String name;
    private int pinCode;

    private String state;
    private List<Hotel> hotelList;

    public City(String name, int pinCode, String state) {
        this.name = name;
        this.pinCode = pinCode;
        this.state = state;
        this.hotelList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPinCode() {
        return pinCode;
    }

    public String getState() {
        return state;
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void addHotel(Hotel hotel) {
        this.hotelList.add(hotel);
    }
}
