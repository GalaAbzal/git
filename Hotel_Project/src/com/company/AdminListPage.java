package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class AdminListPage extends Container {
    //private JTable table;
    private JLabel label;
    private JButton btn;
    private JTextArea area;

    public AdminListPage(){
        setLayout(null);
        setSize(700,700);

        label=new JLabel("List");
        label.setBounds(320,10,150,60);
        add(label);

        btn = new JButton("Back");
        btn.setLocation(210,600);
        btn.setSize(300,30);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Admin.showMenuPage();
            }
        });
        add(btn);

        area = new JTextArea();
        area.setSize(600,400);
        area.setLocation(50,50);
        add(area);
    }

    public void updateArea(ArrayList<Rooms> rooms){
        area.setText("");
        for(Rooms ts: rooms){
            area.append(ts+"\n");
        }
        repaint();
    }

}
