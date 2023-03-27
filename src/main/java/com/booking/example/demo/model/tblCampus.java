package com.booking.example.demo.model;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class tblCampus {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long campusNo;
    private String campusName;

    public tblCampus(){
        campusNo=null;
        campusName=null;
    }

    public tblCampus(Long campusNo, String campusName) {
        this.campusNo = campusNo;
        this.campusName = campusName;
    }

    public Long getCampusNo() {
        return campusNo;
    }

    public void setCampusNo(Long campusNo) {
        this.campusNo = campusNo;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }
}
