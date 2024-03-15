package Model;

import java.util.UUID;
import Model.RoomType;

public class Room {
    private RoomType roomType;
    private boolean available;
    private int bedCount;
    private int sofaCount;
    private int almirahCount;
    private UUID roomId;
    private double price;

    public Room(RoomType roomType, int bedCount, int sofaCount, int almirahCount) {
        this.roomType = roomType;
        this.bedCount = bedCount;
        this.sofaCount = sofaCount;
        this.almirahCount = almirahCount;
        this.roomId = UUID.randomUUID();
    }

    public boolean getRoomAvailability() {
        return available;
    }
    public void setRoomAvailable() {
        this.available = true;
    }

    public void setRoomUnavailable() {
        this.available = false;
    }

    public UUID getRoomId() {
        return roomId;
    }
    public RoomType getRoomType() {
        return roomType;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public int getSofaCount() {
        return sofaCount;
    }

    public void setSofaCount(int sofaCount) {
        this.sofaCount = sofaCount;
    }

    public int getAlmirahCount() {
        return almirahCount;
    }

    public void setAlmirahCount(int almirahCount) {
        this.almirahCount = almirahCount;
    }
    public void setPrice() {
        this.price = 500;
    }

    public double getPrice() {
        return price;
    }
}
