package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import Model.Booking;

public class User {
    private UUID userId;
    private String name;
    private int phone;

    private List<Booking> bookingList;

    public User(String name, int phone) {
        this.userId = UUID.randomUUID();
        this.name = name;
        this.phone = phone;
        this.bookingList = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        this.bookingList.add(booking);
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }
}
