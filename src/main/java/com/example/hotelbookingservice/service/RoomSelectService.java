package com.example.hotelbookingservice.service;

import Model.Hotel;
import Model.Room;
import Model.RoomType;

import com.example.hotelbookingservice.Exception.RoomUnavailableException;
import com.example.hotelbookingservice.Label.Message;

import java.util.Map;

public class RoomSelectService {
    public static Room selectHotelRoom(Hotel hotel,RoomType roomType) throws RoomUnavailableException {
        Map<Room,Integer> roomsStatus = hotel.getRooms();
        for(var roomCount:roomsStatus.entrySet()) {
            Room room = roomCount.getKey();
            if(room.getRoomType().equals(roomType) && room.getRoomAvailability()) {
                room.setRoomUnavailable();
                return room;
            }
        }
        throw new RoomUnavailableException(Message.hotelRoomUnavailable);
    }
}
