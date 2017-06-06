/*
 * Created by JFormDesigner on Mon Apr 24 14:28:05 CST 2017
 */

package UI.user;

import UI.manage.Manager;
import UI.sight.MainInterface;
import domain.Users;
import service.ManagerService;
import service.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 * @author xxx holic
 *
 */
public class LogIn extends JFrame {
    private UserService userService = new UserService();
    private ManagerService managerService = new ManagerService();
    public static Users user;
    public static String name;
    //用户可以修改和忘记密码
    private void radioButton2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        button2.setVisible(true);
        button4.setVisible(true);
    }

    //管理员不能忘记和修改密码
    private void radioButton3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        button2.setVisible(false);
        button4.setVisible(false);
    }

    public LogIn() {
        initComponents();
    }

    //登录按钮功能
    private void button1ActionPerformed(ActionEvent e) throws SQLException, ClassNotFoundException {
        // TODO add your code here 主界面
        UserService userService = new UserService();
        ManagerService managerService = new ManagerService();
        user = new Users();
        domain.Manager manager = new domain.Manager();
        int MorU = radioButton3.isSelected()?1:0; //1：管理员；0：用户
        System.out.println("MorN"+MorU);
        int judge = 0; //登录标识
        name = textField1.getText();
        String pass = textField2.getText();
        if(MorU == 1) { //管理员
            System.out.println("管理员登录");
            manager.setM_NAME(name);
            manager.setM_PASS_WORD(pass);
            System.out.println("管理员姓名："+manager.getM_NAME()+"密码："+manager.getM_PASS_WORD());
            try {
                try {
                    judge = managerService.loginIn(manager);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            if (judge == 1)
                JOptionPane.showMessageDialog(null, "没有管理员" + manager.getM_NAME(), "哦哦", JOptionPane.ERROR_MESSAGE);
            else if (judge == 3)
                JOptionPane.showMessageDialog(null, "密码错误,再想想", "哦哦", JOptionPane.ERROR_MESSAGE);
            else if (judge == 2) {
                new Manager().setVisible(true);
                this.setVisible(false);
            }
        }else{ //用户
            System.out.println("用户登录");
            user.setU_NAME(name);
            user.setU_PASS_WORD(pass);
            try {
                judge = userService.loginIn(user);
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            if (judge == 1)
                JOptionPane.showMessageDialog(null, "没有用户" + user.getU_NAME(), "哦哦", JOptionPane.ERROR_MESSAGE);
            else if (judge == 3)
                JOptionPane.showMessageDialog(null, "密码错误,再想想", "哦哦", JOptionPane.ERROR_MESSAGE);
            else if (judge == 2) {
                new MainInterface().setVisible(true);
                this.setVisible(false);
            }
        }
    }

    //注册按钮功能
    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here  注册
        new Regist().setVisible(true);
        this.setVisible(false);
    }

    //忘记密码按钮功能
    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here  忘记密码
        new FindPassword().setVisible(true);
        this.setVisible(false);
    }

    //修改密码按钮功能
    private void button4ActionPerformed(ActionEvent e) {
        // TODO add your code here 修改密码
        new ChangePassword().setVisible(true);
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - xxx holic
        dialogPane = new JPanel();
        buttonBar = new JPanel();
        contentPanel = new JPanel();
        label2 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        label3 = new JLabel();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        label1 = new JLabel();
        button3 = new JButton();
        button1 = new JButton();
        button4 = new JButton();
        button2 = new JButton();
        comboBox1 = new JComboBox();

        //======== this ========
        setTitle("\u7528\u6237  \u7ba1\u7406\u5458");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //======== contentPanel ========
                {

                    //---- label2 ----
                    label2.setText("  \u5bc6   \u7801   :");

                    //---- label3 ----
                    label3.setText("     ----------------\u6b22 \u8fce \u767b \u5f55 \u65c5 \u884c \u8005--------------");

                    //---- radioButton2 ----
                    radioButton2.setText("\u7528\u6237");
                    radioButton2.addActionListener(e -> radioButton2ActionPerformed(e));

                    //---- radioButton3 ----
                    radioButton3.setText("\u7ba1\u7406\u5458");
                    radioButton3.addActionListener(e -> {
			radioButton3ActionPerformed(e);
			radioButton3ActionPerformed(e);
		});

                    //---- label1 ----
                    label1.setText("  \u8d26   \u53f7   :");

                    //---- button3 ----
                    button3.setText("\u6ce8\u518c");
                    button3.addActionListener(e -> button3ActionPerformed(e));

                    //---- button1 ----
                    button1.setText("\u767b\u5f55");
                    button1.addActionListener(e -> {
                        try {
                            button1ActionPerformed(e);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        } catch (ClassNotFoundException e1) {
                            e1.printStackTrace();
                        }
                    });

                    //---- button4 ----
                    button4.setText("\u4fee\u6539\u5bc6\u7801");
                    button4.addActionListener(e -> {
			button2ActionPerformed(e);
			button4ActionPerformed(e);
		});

                    //---- button2 ----
                    button2.setText("\u5fd8\u8bb0\u5bc6\u7801");
                    button2.addActionListener(e -> button2ActionPerformed(e));

                    GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                    contentPanel.setLayout(contentPanelLayout);
                    contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(contentPanelLayout.createParallelGroup()
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(textField2))
                                            .addGroup(contentPanelLayout.createSequentialGroup()
                                                .addGroup(contentPanelLayout.createParallelGroup()
                                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(radioButton2))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(contentPanelLayout.createParallelGroup()
                                                    .addComponent(radioButton3)
                                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(button4, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                            .addComponent(button3, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(button2)))
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(13, Short.MAX_VALUE))
                    );
                    contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPanelLayout.createParallelGroup()
                                    .addComponent(radioButton2)
                                    .addComponent(radioButton3, GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField1)
                                    .addComponent(button3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(22, 22, 22)
                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(button1)
                                    .addComponent(button4))
                                .addContainerGap(14, Short.MAX_VALUE))
                    );
                    contentPanelLayout.linkSize(SwingConstants.VERTICAL, new Component[] {textField1, textField2});
                }
                buttonBar.add(contentPanel, new GridBagConstraints(0, 0, 3, 2, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton2);
        buttonGroup1.add(radioButton3);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - xxx holic
    private JPanel dialogPane;
    private JPanel buttonBar;
    private JPanel contentPanel;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label3;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JLabel label1;
    private JButton button3;
    private JButton button1;
    private JButton button4;
    private JButton button2;
    private JComboBox comboBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
