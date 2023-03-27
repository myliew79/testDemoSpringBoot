package com.booking.example.demo.repository;
import java.util.List;

import com.booking.example.demo.model.tblCampus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface tblCampusRepository extends JpaRepository<tblCampus, Integer> {
    List<tblCampus> findCampusByCampusNo(Integer CampusNo);
}
