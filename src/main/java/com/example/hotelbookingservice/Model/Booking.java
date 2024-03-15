package Model;

import java.util.UUID;
import Model.Bill;

public class Booking {

    private UUID bookingId;
    private UUID userId;
    private UUID hotelId;
    private Bill bill;
    private UUID roomId;

    public Booking( UUID userId, UUID hotelId,UUID roomId) {
        this.bookingId = UUID.randomUUID();
        this.userId = userId;
        this.hotelId = hotelId;
        this.roomId = roomId;
    }


    public Bill getBill() {
        return bill;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getHotelId() {
        return hotelId;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
