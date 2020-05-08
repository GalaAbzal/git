package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuestMainMenu extends Container {

    public JButton addReservs;
    public JButton list;

    public JButton exit;

    public GuestMainMenu() {
        setSize(700, 700);
        setLayout(null);

        addReservs = new JButton("Add Reservs");
        addReservs.setLocation(200, 150);
        addReservs.setSize(300, 30);
        addReservs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Guest.frame.menu.setVisible(false);
                Guest.frame.listReservs.setVisible(false);
                Guest.frame.addReservs.setVisible(true);
                Guest.frame.repaint();
            }
        });
        add(addReservs);

        list = new JButton("List_Reservs");
        list.setLocation(200, 190);
        list.setSize(300, 30);
        list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Guest.showListPage();
            }
        });
        add(list);


        exit = new JButton("EXIT");
        exit.setBounds(200, 270, 300, 30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);

    }
}
