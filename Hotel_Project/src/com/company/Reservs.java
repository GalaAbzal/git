package com.company;

import java.io.Serializable;

public class Reservs implements Serializable {
    private Long id;
    private int roomsId;
    private String name;
    private String surname;
    private String passwordNumber;

    public Reservs() {
    }

    public Reservs(Long id, int roomsId, String name, String surname, String passwordNumber) {
        this.id = id;
        this.roomsId = roomsId;
        this.name = name;
        this.surname = surname;
        this.passwordNumber = passwordNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoomsId() {
        return roomsId;
    }

    public void setRoomsId(int roomsId) {
        this.roomsId = roomsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPasswordNumber() {
        return passwordNumber;
    }

    public void setPasswordNumber(String passwordNumber) {
        this.passwordNumber = passwordNumber;
    }

    @Override
    public String toString() {
        return "Reservs{" +
                "id=" + getId() +
                ", roomsId=" + getRoomsId() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", passwordNumber='" + getPasswordNumber() + '\'' +
                '}';
    }
}

