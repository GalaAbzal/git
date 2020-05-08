package com.company;
import javax.swing.*;
import java.awt.*;

public class GuestMainFrame extends JFrame {
    public GuestAddPage addReservs;
    public GuestListPage listReservs;
    public GuestMainMenu menu;

    public GuestMainFrame(){
        setTitle("GUEST");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLayout(null);
        setLocationRelativeTo(null);
        menu = new GuestMainMenu();
        menu.setLocation(0,0);
        menu.setVisible(true);
        add(menu);

        addReservs = new GuestAddPage();
        addReservs.setLocation(0,0);
        addReservs.setVisible(false);
        add(addReservs);

        listReservs= new GuestListPage();
        listReservs.setLocation(0,0);
        listReservs.setVisible(false);
        add(listReservs);

        repaint();
    }

}

