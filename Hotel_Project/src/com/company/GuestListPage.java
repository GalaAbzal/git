package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.company.Admin.*;

public class GuestListPage extends Container {
        private JLabel label;
        private JButton btn;
        private JTextArea area;

        public GuestListPage(){
            setLayout(null);
            setSize(700,700);

            label=new JLabel("LIST");
            label.setBounds(10,10,50,20);

            area = new JTextArea();
            area.setSize(600,400);
            area.setLocation(50,50);
            add(area);

            btn = new JButton("BACK");
            btn.setLocation(210,550);
            btn.setSize(300,30);
            btn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Guest.frame.addReservs.setVisible(false);
                    Guest.frame.listReservs.setVisible(false);
                    Guest.frame.menu.setVisible(true);
                    Guest.frame.repaint();
                }
            });
            add(btn);
        }



        public void updateArea(ArrayList<Reservs> reservs){
            area.setText("");
            for (Reservs ts : reservs) {
                area.append(ts + "\n");
                repaint();
            }
        }
}
