package com.booking.example.demo.model;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class tblMtgRooms {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long roomNo;
    private int roomLocation;
    private String roomName;

    public tblMtgRooms(){
        roomNo=null;
        roomLocation=0;
        roomName=null;
    }
    public tblMtgRooms(Long roomNo, int roomLocation, String roomName) {
        this.roomNo = roomNo;
        this.roomLocation = roomLocation;
        this.roomName = roomName;
    }

    public Long getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Long roomNo) {
        this.roomNo = roomNo;
    }

    public int getRoomLocation() {
        return roomLocation;
    }

    public void setRoomLocation(int roomLocation) {
        this.roomLocation = roomLocation;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
