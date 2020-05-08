package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuestAddPage extends Container  {
    private JLabel labelRoomsId;
    private JLabel labelName;
    private JTextField textName;
    private JLabel labelSurname;
    private JTextField textSurname;
    private JLabel labelPasswordNumber;
    private JTextField textPasswordNumber;
    private JButton addReservs;
    private JButton back;

    public GuestAddPage(){
        setLayout(null);
        setSize(700,700);

        labelRoomsId=new JLabel("Room_Id:");
        labelRoomsId.setBounds(100,150,120,40);
        add(labelRoomsId);

        Rooms []rooms=null;
        ArrayList<Rooms> list = Guest.listRooms();
        rooms = list.toArray(new Rooms[list.size()]);

        JComboBox comboBox=new JComboBox(rooms);
        comboBox.setBounds(230,150,250,40);
        add(comboBox);
        labelName=new JLabel("Name:");
        labelName.setBounds(100,200,120,40);
        add(labelName);

        textName=new JTextField();
        textName.setBounds(230,200,250,40);
        add(textName);

        labelSurname=new JLabel("Surname:");
        labelSurname.setBounds(100,250,120,40);
        add(labelSurname);

        textSurname=new JTextField();
        textSurname.setBounds(230,250,250,40);
        add(textSurname);

        labelPasswordNumber=new JLabel("PasswordNumber");
        labelPasswordNumber.setBounds(100,300,120,40);
        add(labelPasswordNumber);

        textPasswordNumber=new JTextField();
        textPasswordNumber.setBounds(230,300,250,40);
        add(textPasswordNumber);

        addReservs=new JButton("ADD");
        addReservs.setBounds(100,400,120,50);
        addReservs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Rooms myRooms = (Rooms) comboBox.getSelectedItem();
                    Reservs reservs=new Reservs(null,myRooms.getId().intValue(),textName.getText(),textSurname.getText(),textPasswordNumber.getText());
                    Guest.addReservs(reservs);

                    textName.setText("");
                    textSurname.setText("");
                    textPasswordNumber.setText("");

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        add(addReservs);

        back=new JButton("BACK");
        back.setBounds(360,400,120,50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Guest.frame.addReservs.setVisible(false);
                Guest.frame.listReservs.setVisible(false);
                Guest.frame.menu.setVisible(true);
                Guest.frame.repaint();
            }
        });
        add(back);
    }

}
