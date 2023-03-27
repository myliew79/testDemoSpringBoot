package com.booking.example.demo.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class tblBookers {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long bookerNo;
    private String emailAddr;
    private String name;
    private String phoneNum;

    public tblBookers() {
        bookerNo=null;
        emailAddr=null;
        name=null;
        phoneNum=null;
    }

    public tblBookers(Long bookerNo, String emailAddr, String name, String phoneNum) {
        this.bookerNo = bookerNo;
        this.emailAddr = emailAddr;
        this.name = name;
        this.phoneNum = phoneNum;
    }
    public Long getBookerNo() {
        return bookerNo;
    }

    public void setBookerNo(Long bookerNo) {
        this.bookerNo = bookerNo;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
