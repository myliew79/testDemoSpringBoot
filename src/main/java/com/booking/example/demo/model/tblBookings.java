package com.booking.example.demo.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class tblBookings {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long bookingId;
    private int bookerNo;
    private int roomNo;

    public tblBookings() {
        bookingId=null;
        bookerNo=0;
        roomNo=0;
    }
    public tblBookings(Long bookingId, int bookerNo, int roomNo) {
        this.bookingId = bookingId;
        this.bookerNo = bookerNo;
        this.roomNo = roomNo;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public int getBookerNo() {
        return bookerNo;
    }

    public void setBookerNo(int bookerNo) {
        this.bookerNo = bookerNo;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
}
