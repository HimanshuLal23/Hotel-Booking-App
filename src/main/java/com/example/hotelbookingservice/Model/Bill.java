package Model;

import java.util.UUID;

public class Bill {
    private UUID billId;
    private UUID paymentId;
    private UUID userId;
    private UUID hotelId;

    public Bill(UUID paymentId, UUID userId, UUID hotelId,UUID bookingId) {
        this.billId = UUID.randomUUID();
        this.paymentId = paymentId;
        this.userId = userId;
        this.hotelId = hotelId;
    }

    public UUID getBillId() {
        return billId;
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getHotelId() {
        return hotelId;
    }
}
