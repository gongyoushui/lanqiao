/*
 * Created by JFormDesigner on Mon May 01 14:04:10 GMT+08:00 2017
 */

package UI.manage;

import java.awt.event.*;

import service.ManagerService;

import java.awt.*;
import java.beans.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author xxx holic
 */
public class AddManager extends JFrame {
    public AddManager() {
        initComponents();
    }

    //保存新管理员
    private void button1ActionPerformed(ActionEvent e)  throws SQLException, ClassNotFoundException {
        ManagerService ms = new ManagerService();
        domain.Manager m = new domain.Manager();
        //获得文本框数据
        m.setM_NAME(textField1.getText());
        m.setM_PASS_WORD(textField2.getText()); //密码类型得改
        if (ms.loadIn(m) > 0) {//新建成功
            JOptionPane.showMessageDialog(null, "新建管理员" + m.getM_NAME() + "成功", "嘿嘿", JOptionPane.ERROR_MESSAGE);
            this.dispose();
            new Manager().setVisible(true);
        }
        else //新建失败
            JOptionPane.showMessageDialog(null, "出错了，换个名称再试一次吧~", "哦哦", JOptionPane.ERROR_MESSAGE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - xxx holic
        textField1 = new JTextField();
        textField2 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();

        //======== this ========
        addPropertyChangeListener("save", e -> thisPropertyChange(e));
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u7ba1\u7406\u5458\u540d\u79f0\uff1a");

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");

        //---- button1 ----
        button1.setText("\u4fdd\u5b58");
        button1.addActionListener(e -> {
            try {
                button1ActionPerformed(e);
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(49, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
                    .addGap(36, 36, 36))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(51, 51, 51)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                    .addGap(33, 33, 33)
                    .addComponent(button1)
                    .addGap(26, 26, 26))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    //没搞懂是什么
    private void thisPropertyChange(PropertyChangeEvent e) {
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - xxx holic
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
