package Repository;

import Model.City;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class CityRepository {
    private static List<City> cityList;

    private CityRepository() {
        cityList = new ArrayList<>();
    }

    private static class Holder {
        private static CityRepository cityRepository = new CityRepository();
    }

    public static CityRepository getInstance() {
        return Holder.cityRepository;
    }

    public void addCity(City city) {
        cityList.add(city);
    }

    public List<City> getCityList() {
        return cityList;
    }
}
