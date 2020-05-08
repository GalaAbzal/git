package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminDeletePage extends Container {
    private JTable table;
    private JLabel label;
    private JTextField textField;
    private JButton delete;
    private JButton back;
    private JLabel labelDelete;
    public AdminDeletePage(){
        setLayout(null);
        setSize(700,700);

        labelDelete=new JLabel("*DELETE*");
        labelDelete.setBounds(340,10,100,30);
        add(labelDelete);
        label=new JLabel("INSERT ID:");
        label.setBounds(259,450,80,30);
        add(label);

        textField=new JTextField("");
        textField.setBounds(340,450,100,30);
        add(textField);

        delete=new JButton("DELETE");
        delete.setBounds(150,500,100,50);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long id;
                try{
                    id=Long.parseLong(textField.getText());

                    Admin.deleteWithId(id);

                    Admin.showMenuPage();
                    textField.setText("");

                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        add(delete);

        back=new JButton("BACK");
        back.setBounds(450,500,100,50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.showMenuPage();
            }
        });
        add(back);

    }


    public void updateArea(ArrayList<Rooms> rooms){

        String columnNames[] =new String[]{"ID", "RoomNumber", "TIME", "PRICE"};

        String data[][] = new String[rooms.size()][4];

        int i = 0;
        for(Rooms st : rooms){
            data[i][0] = String.valueOf(st.getId());
            data[i][1] = st.getRoomNumber();
            data[i][2] = st.getTime();
            data[i][3] = String.valueOf(st.getPrice());
            i++;
        }

        table = new JTable(data, columnNames);
        table.setBounds(150,50,400,400);

        add(table);
        repaint();
    }
}
