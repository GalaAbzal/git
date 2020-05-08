package com.company;
import javax.swing.*;

public class AdminMainFrame extends JFrame {
    public AdminAddPage addRooms;
    public AdminListPage listRooms;
    public AdminDeletePage deletePage;
    public AdminMainMenu menu;
    public AdminMainFrame(){
        setTitle("ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLayout(null);
        setLocationRelativeTo(null);


        menu = new AdminMainMenu();
        menu.setLocation(0,0);
        menu.setVisible(true);
        add(menu);

        addRooms = new AdminAddPage();
        addRooms.setLocation(0,0);
        addRooms.setVisible(false);
        add(addRooms);

        listRooms = new AdminListPage();
        listRooms.setLocation(0,0);
        listRooms.setVisible(false);
        add(listRooms);

        deletePage=new AdminDeletePage();
        deletePage.setLocation(0,0);

        deletePage.setVisible(false);
        add(deletePage);

        repaint();
    }
}
