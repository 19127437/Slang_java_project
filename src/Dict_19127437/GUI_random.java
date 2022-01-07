package Dict_19127437;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class GUI_random extends javax.swing.JFrame {

    public static int timer = 5;
    public static int ans_given = 0;


    public GUI_random() {
        initComponents();
        start();
    }


    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GUI_Random_19127437");
        setLocationRelativeTo(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20));
        jLabel2.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }
    public void start(){
        slangmanager.Load_Data_Slangword();
        SimpleDateFormat dt= new SimpleDateFormat();
        Date dNow = new Date();
        var today_local = LocalDateTime.now();
        var d_m_y = today_local.getDayOfYear();
        var m = today_local.getMonth();
        var m_m =0;
        if(m.equals("JANUARY") || m.equals("MARCH") || m.equals("MAY") || m.equals("JULY") || m.equals("SEPTEMBER") || m.equals("NOVEMBER")){
            m_m=5;
        }else{
            m_m=10;
        }
        var slang_new = (d_m_y + m_m) % slangmanager.list.size();
        var slang = slangmanager.list.keySet().toArray(new String[0])[slang_new];
        jLabel1.setText("Từ slang ngày " + dt.format(dNow) +" sẽ là:");

        for(String j: slangmanager.list.get(slang) ){
            jLabel2.setText( "Sang word: " + slang + " Definition: " + j  );
        }

    }



    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;

}
