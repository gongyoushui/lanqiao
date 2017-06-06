/*
 * Created by JFormDesigner on Sat Apr 29 09:47:24 CST 2017
 */

package UI.around;

import java.awt.event.*;
import UI.sight.MainInterface;
import domain.FoodCommend;
import service.FoodsService;

import java.sql.SQLException;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

/**
 * @author xxx holic
 */
public class Around extends JFrame {
    public static int row;
    public static List<FoodCommend> foods;
    public Around() {
        initComponents();
        //加载推荐美食列表
        DefaultTableModel dtm = new DefaultTableModel();
        table1.setModel(dtm);

        try {
            foods = FoodsService.recommendAll(MainInterface.sight.get(MainInterface.row).getS_ID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Object [][] data = new Object[foods.size()][];
        for (int i = 0;i < foods.size();i++){
            data[i] = foods.get(i).toStringArray();
            if(data[i] != null) {
                String[] header = {"菜名", "价格/元", "折扣"};
                dtm.setDataVector(data, header);
            }
        }
      //选中推荐行 提示美食详细信息
        table1.getSelectionModel().addListSelectionListener(se->{
            row = table1.getSelectedRow();
            new FoodDetail().setVisible(true);
        });

    }

    private void button4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        DefaultTableModel dtm = new DefaultTableModel();
        table1.setModel(dtm);

        try {
            foods = FoodsService.findFood(textField2.getText());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        Object [][] data = new Object[foods.size()][];
        for (int i = 0;i < foods.size();i++){
            data[i] = foods.get(i).toStringArray();
            if(data[i] != null) {
                String[] header = {"菜名", "价格/元", "折扣"};
                dtm.setDataVector(data, header);
            }
        }
    }

    //按美食类型搜索:
    private void type(String type){
        DefaultTableModel dtm = new DefaultTableModel();
        table1.setModel(dtm);

        try {
            foods = FoodsService.findType(type);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        Object [][] data = new Object[foods.size()][];
        for (int i = 0;i < foods.size();i++){
            data[i] = foods.get(i).toStringArray();
            if(data[i] != null) {
                String[] header = {"菜名", "价格/元", "折扣"};
                dtm.setDataVector(data, header);
            }
        }
    }
  //中餐类型美食显示
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        type("中餐");
    }
//搜索小吃美食类型
    private void button2ActionPerformed(ActionEvent e) {
        type("小吃");
    }
//搜索其他美食类型
    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        type("其他");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - xxx holic
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        textField2 = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button6 = new JButton();
        label2 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("    \u7f8e\u98df ");

        //---- button1 ----
        button1.setText("\u4e2d\u9910");
        button1.addActionListener(e -> {
			button1ActionPerformed(e);
			button1ActionPerformed(e);
		});

        //---- button2 ----
        button2.setText("\u5c0f\u5403");
        button2.addActionListener(e -> button2ActionPerformed(e));

        //---- button3 ----
        button3.setText("\u5176\u4ed6");
        button3.addActionListener(e -> button3ActionPerformed(e));

        //---- button4 ----
        button4.setText("\u641c\u7d22");
        button4.addActionListener(e -> button4ActionPerformed(e));

        //---- button5 ----
        button5.setText("\u67e5\u770b\u4f4f\u5bbf");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- button6 ----
        button6.setText("\u8fd4\u56de");

        //---- label2 ----
        label2.setText("   \u5468\u8fb9\u8be6\u60c5 :");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button1))
                                .addComponent(button3)
                                .addComponent(button2)
                                .addComponent(label2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                            .addGap(127, 127, 127)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(button4))
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 101, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button5)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 441, Short.MAX_VALUE)
                            .addComponent(button6)
                            .addGap(55, 55, 55))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button4)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addComponent(button1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(button2)
                                    .addGap(27, 27, 27)
                                    .addComponent(button3))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(55, 55, 55)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button5)
                                .addComponent(button6))
                            .addGap(75, 75, 75))))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - xxx holic
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JTextField textField2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button6;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
