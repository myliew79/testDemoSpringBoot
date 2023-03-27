package com.booking.example.demo.controller;
import com.booking.example.demo.model.tblBookers;
import com.booking.example.demo.model.tblBookings;
import com.booking.example.demo.model.tblCampus;
import com.booking.example.demo.model.tblMtgRooms;
import com.booking.example.demo.repository.tblBookingsRepository;
import com.booking.example.demo.repository.tblBookersRepository;
import com.booking.example.demo.repository.tblMtgRoomsRepository;
import com.booking.example.demo.repository.tblCampusRepository;

import org.apache.catalina.Store;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class tblBookingsController {

    @Autowired
    private tblBookingsRepository tblBookingsRepository;

    @Autowired
    private tblBookersRepository tblBookersRepository;

    @Autowired
    private tblMtgRoomsRepository tblMtgRoomsRepository;

    @Autowired
    private tblCampusRepository tblCampusRepository;

    @GetMapping("/bookings")
    public ResponseEntity<List<tblBookings>> getAllBookings() {
        try {
            List<tblBookings> bookings = new ArrayList<tblBookings>();
            bookings.addAll(tblBookingsRepository.findAll());
            //System.out.println ("bookings.size = "+bookings.size());
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.println (e.getStackTrace());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bookingBookerNo")
    public ResponseEntity<tblBookings> getBookingsByBookerNo(@RequestParam(value="bookerNo", required=false) Integer bookerNo) throws JpaSystemException {
        System.out.println(bookerNo);
        try {
            List<tblBookings> bookings = tblBookingsRepository.findByBookerNo(bookerNo);
            if (bookings.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(bookings.get(0), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @GetMapping("/bookingRoomNo")
    public ResponseEntity<tblBookings> getBookingsByRoomNo(@RequestParam(value="roomNo", required=true) Integer roomNo) {
        List<tblBookings> bookings = tblBookingsRepository.findByRoomNo(roomNo);

        if (bookings.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(bookings.get(0), HttpStatus.OK);
    }

    @PostMapping("/addBooking")
    public ResponseEntity<tblBookings> createBooking(@RequestBody tblBookings booking) {
        try {
            tblBookings _booking = tblBookingsRepository.save(new tblBookings(generateUniqueId(), booking.getBookerNo(), booking.getRoomNo()));
            return new ResponseEntity<>(_booking, HttpStatus.CREATED);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/addBooker")
    public ResponseEntity<tblBookers> createBooker(@RequestBody tblBookers booker) {
        try {
            tblBookers _booker = tblBookersRepository.save(new tblBookers(generateUniqueId(), booker.getEmailAddr(), booker.getName(), booker.getPhoneNum()));
            return new ResponseEntity<>(_booker, HttpStatus.CREATED);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/addRoom")
    public ResponseEntity<tblMtgRooms> createRoom(@RequestBody tblMtgRooms room) {
        try {
            tblMtgRooms _room = tblMtgRoomsRepository.save(new tblMtgRooms(generateUniqueId(), room.getRoomLocation(), room.getRoomName()));
            return new ResponseEntity<>(_room, HttpStatus.CREATED);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/addCampus")
    public ResponseEntity<tblCampus> createCampus(@RequestBody tblCampus campus) {
        try {
            tblCampus _campus = tblCampusRepository.save(new tblCampus(generateUniqueId(), campus.getCampusName()));
            return new ResponseEntity<>(_campus, HttpStatus.CREATED);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PutMapping("/bookings/{id}")
    public ResponseEntity<tblBookings> updateBooking(@PathVariable("id") Long bookingId, @RequestBody tblBookings booking) {
        Optional<tblBookings> bookings = tblBookingsRepository.findById(bookingId);

        if (bookings.isPresent()) {
            tblBookings _booking = bookings.get();
            _booking.setRoomNo(booking.getRoomNo());
            _booking.setBookerNo(booking.getBookerNo());
            return new ResponseEntity<>(tblBookingsRepository.save(_booking), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<HttpStatus> deleteBookingByRoomNo(@PathVariable("id") Long id) {
        try {
            tblBookingsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static Long generateUniqueId() {
        Long val = -1L;
        final UUID uid = UUID.randomUUID();
        final ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
        buffer.putLong(uid.getLeastSignificantBits());
        buffer.putLong(uid.getMostSignificantBits());
        final BigInteger bi = new BigInteger(buffer.array());
        val = bi.longValue() & Long.MAX_VALUE;
        return val;
    }
}
