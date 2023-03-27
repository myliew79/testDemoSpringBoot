package com.booking.example.demo.repository;
import java.util.List;

import com.booking.example.demo.model.tblBookers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tblBookersRepository extends JpaRepository<tblBookers, Integer> {
    List<tblBookers> findBookerByBookerNo(Integer bookerNo);

}
