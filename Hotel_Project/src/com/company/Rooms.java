package com.company;

import java.io.Serializable;

public class Rooms implements Serializable {
    private Long id;
    private String roomNumber;
    private String time;
    private int price;

    public Rooms(){}

    public Rooms(Long id, String roomNumber, String time, int price) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.time = time;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getTime() {
        return time;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "id=" + getId() +
                ", roomNumber='" + getRoomNumber() + '\'' +
                ", time='" + getTime() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
