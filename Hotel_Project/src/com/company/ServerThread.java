package com.company;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class ServerThread extends Thread {
    private Connection connection;
    private Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;

    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void run() {
        try {
            PackageData pd=null;
            while ((pd = (PackageData) inputStream.readObject())!=null) {

                if (pd.getOperationType().equals("Add_Room")) {
                    try {
                        Rooms rooms = pd.getRoom();
                        addRoomsToDb(rooms);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("Add_Reservs")){
                    try {
                        Reservs reservs= pd.getReservs().get(0);
                        addResevsToDb(reservs);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else if(pd.getOperationType().equals("List_Rooms")){
                    ArrayList<Rooms> rooms = getRooms();
                    PackageData resp = new PackageData();
                    resp.setRooms(rooms);
                    outputStream.writeObject(resp);
                }
                else if(pd.getOperationType().equals("List_Reservs")){
                    ArrayList<Reservs>reservs=getReservs();
                    PackageData pd2=new PackageData();
                    pd2.setReservs(reservs);
                    outputStream.writeObject(pd2);
                }
                else if(pd.getOperationType().equals("Delete_Rooms")){
                    Long id=pd.getId();
                    deleteRoomsToDB(id);
                }
                else{
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addRoomsToDb(Rooms rooms) {
        try {
            PreparedStatement ps=connection.prepareStatement("insert into rooms(id,roomNumber,time,price) values(null,?,?,?)");

            ps.setString(1,rooms.getRoomNumber());
            ps.setString(2,rooms.getTime());
            ps.setInt(3,rooms.getPrice());
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  void addResevsToDb(Reservs reservs) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into reservs(id,roomsId,name,surname,passwordNumber) values(null,?,?,?,?)");

            ps.setInt(1,reservs.getRoomsId());
            ps.setString(2,reservs.getName());
            ps.setString(3,reservs.getSurname());
            ps.setString(4,reservs.getPasswordNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Rooms> getRooms() {
        ArrayList<Rooms> rooms = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM rooms";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                rooms.add(new Rooms(res.getLong("id"), res.getString("roomNumber"),res.getString("time"),res.getInt("price")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }
    public ArrayList<Reservs> getReservs() {
        ArrayList<Reservs> reservs = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM reservs";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                reservs.add(new Reservs(res.getLong("id"), res.getInt("roomsId"), res.getString("name"), res.getString("surname"),res.getString("passwordNumber")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservs;
    }



    public void deleteRoomsToDB(Long id){
        try{
            PreparedStatement ps=connection.prepareStatement("DELETE FROM rooms WHERE id=?");
            ps.setLong(1,id);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
