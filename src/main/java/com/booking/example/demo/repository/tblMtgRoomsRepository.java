package com.booking.example.demo.repository;

import java.util.List;
import java.util.UUID;

import com.booking.example.demo.model.tblMtgRooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tblMtgRoomsRepository extends JpaRepository<tblMtgRooms, Integer> {
    List<tblMtgRooms> findRoomByRoomNo (Integer roomNo);
}
