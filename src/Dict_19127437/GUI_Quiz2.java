package Dict_19127437;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GUI_Quiz2 extends javax.swing.JFrame {

    ButtonGroup btgroup;
    static String trl;
    public GUI_Quiz2() {
        initComponents();
        start();
    }

    private void initComponents() {

        btgroup = new ButtonGroup();
        btgroup.add(jRadioButton1);
        btgroup.add(jRadioButton2);
        btgroup.add(jRadioButton3);
        btgroup.add(jRadioButton4);

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel1 = new java.awt.Panel();
        textField1 = new java.awt.TextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        button1 = new java.awt.Button();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        textField1.setText("textField1");

        jRadioButton1.setText("jRadioButton1");

        jRadioButton2.setText("jRadioButton2");

        jRadioButton3.setText("jRadioButton3");

        jRadioButton4.setText("jRadioButton4");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jRadioButton4)
                                                        .addComponent(jRadioButton3)
                                                        .addComponent(jRadioButton2)
                                                        .addComponent(jRadioButton1))
                                                .addGap(0, 465, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton4)
                                .addContainerGap(32, Short.MAX_VALUE))
        );

        button1.setLabel("submit");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(226, 226, 226)
                                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {
        repaint();
        jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
        jRadioButton3.setEnabled(true);
        jRadioButton4.setEnabled(true);
        if(btgroup.getSelection() == null){
            String checkq  = "";
            System.out.print(checkq);
        }else {
            String check =  btgroup.getSelection().getActionCommand();
            if(check.equals(trl)){
                JOptionPane.showMessageDialog(this, " Chúc mừng bạn đẽ trả lời đúng");

                int option = JOptionPane.showConfirmDialog(this, "Bạn muốn tiếp tục câu khác không ?"  );
                if (option == 0){
                    start();
                }
            }
            else{
                JOptionPane.showMessageDialog(this, " Ohhhno bạn trả lời sai rồi ");

                int option = JOptionPane.showConfirmDialog(this, "Bạn muốn tiếp tục câu khác không ?"  );
                if (option == 0){
                    start();
                }
            }
        }

    }
    public void start(){
        slangmanager.Load_Data_Slangword();
        String random=slangmanager.getrandom();
        Random r = new Random();
        List<String> Ans= slangmanager.list.get(random);

        int index = r.nextInt(Ans.size());
        String Answer = Ans.get(index);
        String ques =  Ans.get(index);
        String Answer1= random;
        trl = Answer1;

        List<String> list_question=new ArrayList<>();
        int check=0;
        while(check<3){
            String slangnew = slangmanager.getrandom();
            if(!slangnew.equals(random)) {
                check=check+1;
                list_question.add(slangnew);
            }
            if(check==3)
                break;
        }
        list_question.add(Answer1);
        Collections.shuffle(list_question);
        textField1.setText("-Đâu là slang của  câu sau ( " + ques +" ) mời bạn chọn 1 trong 4 đáp án");
        jRadioButton1.setLabel(list_question.get(0));
        jRadioButton1.setActionCommand(list_question.get(0));

        btgroup.add(jRadioButton1);
        jRadioButton1.setSelected(true);

        jRadioButton2.setLabel(list_question.get(1));
        jRadioButton2.setActionCommand(list_question.get(1));

        btgroup.add(jRadioButton2);
        jRadioButton2.setSelected(true);

        jRadioButton3.setLabel(list_question.get(2));
        jRadioButton3.setActionCommand(list_question.get(2));

        btgroup.add(jRadioButton3);
        jRadioButton3.setSelected(true);

        jRadioButton4.setLabel(list_question.get(3));
        jRadioButton4.setActionCommand(list_question.get(3));
        btgroup.add(jRadioButton4);
        jRadioButton4.setSelected(true);

        btgroup.clearSelection();
    }



    private java.awt.Button button1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private java.awt.Panel panel1;
    private java.awt.TextField textField1;

}
