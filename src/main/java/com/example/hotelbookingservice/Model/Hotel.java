package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import Model.Room;

public class Hotel {
    private UUID id;
    private String name;
    private String address;
    private int phoneNumber;
    private Map<Room,Integer> rooms;

    public UUID getHotelId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public Map<Room, Integer> getRooms() {
        return rooms;
    }

    public void addRooms(Room room,int count) {
        for(int i=0;i<count;i++) {
            room.setRoomAvailable();
            rooms.put(room,count);
        }
    }

    public Hotel(String name,String address,String phoneNumber,Map<Room,Integer> currentRoomStatus) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.address = address;
        this.phoneNumber = Integer.valueOf(phoneNumber);
        this.rooms = rooms;
    }

    public Hotel(String name,String address,String phoneNumber) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.address = address;
        this.phoneNumber = Integer.valueOf(phoneNumber);;
        this.rooms = new HashMap<>();
    }

}
