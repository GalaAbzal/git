package com.company;

import java.io.*;
import java.util.ArrayList;

public class PackageData implements Serializable {
    String operationType;
    ArrayList<Reservs> reservs;
    ArrayList<Rooms> rooms;
    Reservs reserv;
    Rooms room;
    Long id;

    public PackageData(){}

    public PackageData(String operationType, ArrayList<Reservs> reservs, ArrayList<Rooms> rooms, Reservs reserv, Rooms room, Long id) {
        this.operationType = operationType;
        this.reservs = reservs;
        this.rooms = rooms;
        this.reserv = reserv;
        this.room = room;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<Reservs> getReservs() {
        return reservs;
    }

    public void setReservs(ArrayList<Reservs> reservs) {
        this.reservs = reservs;
    }

    public ArrayList<Rooms> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Rooms> rooms) {
        this.rooms = rooms;
    }

    public Reservs getReserv() {
        return reserv;
    }

    public void setReserv(Reservs reserv) {
        this.reserv = reserv;
    }

    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }
}
