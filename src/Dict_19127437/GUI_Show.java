package Dict_19127437;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.List;

public class GUI_Show extends javax.swing.JFrame {
    DefaultTableModel tableModel;

    public GUI_Show() {
        initComponents();
        tableModel = (DefaultTableModel) jTable1.getModel();
        slangmanager.Load_Data_Slangword();
        HashMap<String, List<String>> list=new HashMap<String,List<String>>();
        list= slangmanager.list;
        for (String i: list.keySet())
        {
            List<String> defLis = list.get(i);
            for(String j: defLis) {
                tableModel.addRow(new Object[]{i,j});
            }
        }
    }


    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GUI_Show_19127437");
        setLocationRelativeTo(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Slang word", "Definition"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}
