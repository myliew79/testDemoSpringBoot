package com.booking.example.demo.repository;

import java.util.List;
import java.util.UUID;

import com.booking.example.demo.model.tblBookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface tblBookingsRepository extends JpaRepository<tblBookings, Long> {
    List<tblBookings> findByBookerNo (Integer bookerNo);
    List<tblBookings> findByRoomNo (Integer roomNo);

}

