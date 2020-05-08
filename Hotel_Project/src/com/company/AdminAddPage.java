package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAddPage extends Container {
    private JLabel labelRoomNumber;
    private JTextField textRoomNumber;
    private JLabel labelTime;
    private JTextField textTime;
    private JLabel labelPrice;
    private JTextField textPrice;
    private JButton addRooms;
    private JButton back;

    public AdminAddPage() {
        setLayout(null);
        setSize(700, 700);

        labelRoomNumber = new JLabel("RoomNumber:");
        labelRoomNumber.setBounds(250, 150, 80, 40);
        add(labelRoomNumber);
        textRoomNumber = new JTextField();
        textRoomNumber.setBounds(340, 150, 100, 40);
        add(textRoomNumber);

        labelTime = new JLabel("Time:");

        labelTime.setBounds(250, 300, 80, 40);
        add(labelTime);

        textTime = new JTextField();
        textTime.setBounds(340, 300, 100, 40);
        add(textTime);

        labelPrice = new JLabel("Price:");
        labelPrice.setBounds(250, 350, 80, 40);
        add(labelPrice);

        textPrice = new JTextField();
        textPrice.setBounds(340, 350, 100, 40);
        add(textPrice);

        addRooms = new JButton("Add");
        addRooms.setBounds(250, 400, 100, 50);
        addRooms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int price = 0;

                try {
                    price = Integer.parseInt(textPrice.getText());
                    Rooms rooms = new Rooms(null, textRoomNumber.getText(), textTime.getText(), price);
                    Admin.addRooms(rooms);

                    textRoomNumber.setText("");
                    textTime.setText("");
                    textPrice.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(addRooms);

        back = new JButton("Back");
        back.setBounds(360, 400, 100, 50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.frame.addRooms.setVisible(false);
                Admin.frame.listRooms.setVisible(false);
                Admin.frame.deletePage.setVisible(false);
                Admin.frame.menu.setVisible(true);
                Admin.frame.repaint();
            }
        });
        add(back);
    }
}
