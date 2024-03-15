package Repository;

import Model.Hotel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class HotelRepository {

    private static List<Hotel> hotelList;

    private HotelRepository() {
        hotelList = new ArrayList<>();
    }

    private static class Holder {
        private static HotelRepository hotelRepository = new HotelRepository();
    }

    public static HotelRepository getInstance() {
        return Holder.hotelRepository;
    }

    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }
}
