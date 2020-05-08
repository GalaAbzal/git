package com.company;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Guest {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static GuestMainFrame frame;
    public static Socket  socket;

    public static void connectToServer(){
        try{
            socket=new Socket("localhost",3306);
            outputStream=new ObjectOutputStream(socket.getOutputStream());
            inputStream=new ObjectInputStream((socket.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addReservs(Reservs reservs){
        PackageData pd=new PackageData();
        ArrayList<Reservs> reservs1 = new ArrayList<>();
        reservs1.add(reservs);
        pd.setOperationType("Add_Reservs");
        pd.setReservs(reservs1);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Reservs> listReservs(){
        ArrayList<Reservs> reservs=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Reservs");
        pd.setReservs(reservs);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                reservs =pd.getReservs();
            }
        }catch (Exception e){e.printStackTrace();}
        return reservs;
    }

    public static ArrayList<Rooms> listRooms(){
        ArrayList<Rooms> rooms=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Rooms");
        try {
            outputStream.writeObject(pd);
            if((pd=(PackageData)inputStream.readObject())!=null){
                rooms=pd.getRooms();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return rooms;
    }


    public static void showListPage(){
        Guest.frame.menu.setVisible(false);
        Guest.frame.addReservs.setVisible(false);
        Guest.frame.listReservs.setVisible(true);
        ArrayList<Reservs>list=listReservs();
        frame.listReservs.updateArea(list);
        Guest.frame.repaint();
    }
    public static void main(String[] args){
        connectToServer();
        frame = new GuestMainFrame();
        frame.setVisible(true);
    }
}
