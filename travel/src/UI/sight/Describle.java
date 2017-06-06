/*
 * Created by JFormDesigner on Thu Apr 27 15:34:56 CST 2017
 */

package UI.sight;

import UI.around.Around;
import service.CollectionService;
import java.awt.event.*;
import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.GroupLayout;

import static service.UserService.user;


/**
 * @author xxx holic
 */
public class Describle extends JFrame {

    public Describle() {

        initComponents();
        System.out.println("描述表");

        //========================
        textArea1.append(MainInterface.sight.get(MainInterface.row).getS_NAME());
        textArea2.append(MainInterface.sight.get(MainInterface.row).getS_INTRODUCTION());
        textArea3.append(MainInterface.sight.get(MainInterface.row).getS_lEVEL());
        textArea4.append(MainInterface.sight.get(MainInterface.row).getS_LOC());
        textArea5.append(MainInterface.sight.get(MainInterface.row).getS_SUM_ESSAY());
        //换行:textArea5.getLineWrap();
        textArea1.setVisible(true);
        textArea2.setVisible(true);
        textArea3.setVisible(true);
        textArea4.setVisible(true);
        textArea5.setVisible(true);

        System.out.println("行row"+ MainInterface.row);
        System.out.println("图片"+ MainInterface.sight.get(MainInterface.row).getS_PIC());
        label1.setIcon(new ImageIcon(getClass().getResource(MainInterface.sight.get(MainInterface.row).getS_PIC())));

        //========================


    }

    public static void main(String[] args) {
        JFrame frame = new MainInterface();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here

        new MainInterface().setVisible(true);
        this.setVisible(false);
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        CollectionService collectionService = new CollectionService();

            //调用UserService user_id;
        try {
            collectionService.add(user.getU_ID(),
                    1,MainInterface.sight.get(MainInterface.row).getS_NAME());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        //JOptionPane.showMessageDialog(null,"收藏成功!");



    }

    private void button5ActionPerformed(ActionEvent e) {
        // TODO add your code here
        new Around().setVisible(true);
        this.setVisible(false);
    }

    //查看收藏信息
    private void button4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        new Collection().setVisible(true);

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - xxx holic
        layeredPane1 = new JLayeredPane();
        JPanel panel1 = new JPanel();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();
        textField7 = new JTextField();
        scrollPane3 = new JScrollPane();
        textArea3 = new JTextArea();
        scrollPane4 = new JScrollPane();
        textArea4 = new JTextArea();
        textField8 = new JTextField();
        scrollPane5 = new JScrollPane();
        textArea5 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();

        //======== this ========
        setFont(new Font("\u65b9\u6b63\u59da\u4f53", Font.PLAIN, 12));
        setFocusableWindowState(false);
        setFocusable(false);
        Container contentPane = getContentPane();

        //======== layeredPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setForeground(new Color(255, 255, 255, 0));

                // JFormDesigner evaluation mark
                panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new Font("Dialog", Font.BOLD, 12),
                        Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //---- label1 ----
                label1.setText("text");
                label1.setIcon(new ImageIcon(getClass().getResource("/pic/1.jpg")));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(10, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 31, Short.MAX_VALUE))
                );
            }
            layeredPane1.add(panel1, JLayeredPane.DEFAULT_LAYER);
            panel1.setBounds(0, 0, 475, 445);
        }

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }

        //---- textField4 ----
        textField4.setText("\u666f\u70b9\u8be6\u60c5:");

        //---- textField5 ----
        textField5.setText("\u666f\u70b9\u540d:");

        //---- textField6 ----
        textField6.setText("\u666f\u70b9\u4ecb\u7ecd:");

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(textArea2);
        }

        //---- textField7 ----
        textField7.setText("\u666f\u70b9\u4f4d\u7f6e:");

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(textArea3);
        }

        //======== scrollPane4 ========
        {
            scrollPane4.setViewportView(textArea4);
        }

        //---- textField8 ----
        textField8.setText("\u603b\u8bc4\u5206:");

        //======== scrollPane5 ========
        {
            scrollPane5.setViewportView(textArea5);
        }

        //---- button1 ----
        button1.setText("\u5230\u8fd9\u53bb");

        //---- button2 ----
        button2.setText("\u6536\u85cf");
        button2.addActionListener(e -> {
			button2ActionPerformed(e);
		});

        //---- button3 ----
        button3.setText("\u8fd4\u56de");
        button3.addActionListener(e -> button3ActionPerformed(e));

        //---- button4 ----
        button4.setText("\u67e5\u770b\u6536\u85cf");
        button4.addActionListener(e -> {
			button4ActionPerformed(e);
		});

        //---- button5 ----
        button5.setText("\u67e5\u770b\u5468\u8fb9");
        button5.addActionListener(e -> button5ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(layeredPane1, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollPane4)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addContainerGap(68, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(textField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrollPane5, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 68, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(0, 140, Short.MAX_VALUE)
                            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30))))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32)
                    .addComponent(button5, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                    .addGap(78, 78, 78)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                    .addGap(90, 90, 90))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane5, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addGap(54, 54, 54))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(button4)
                                    .addGap(2, 2, 2)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(layeredPane1, GroupLayout.PREFERRED_SIZE, 448, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button1)
                            .addComponent(button5)
                            .addComponent(button2))
                        .addComponent(button3))
                    .addContainerGap(33, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - xxx holic
    private JLayeredPane layeredPane1;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JScrollPane scrollPane2;
    private JTextArea textArea2;
    private JTextField textField7;
    private JScrollPane scrollPane3;
    private JTextArea textArea3;
    private JScrollPane scrollPane4;
    private JTextArea textArea4;
    private JTextField textField8;
    private JScrollPane scrollPane5;
    private JTextArea textArea5;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
