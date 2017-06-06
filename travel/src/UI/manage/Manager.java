/*
 * Created by JFormDesigner on Thu Apr 27 10:39:04 GMT+08:00 2017
 */

package UI.manage;//其实没用到COL的值

import service.ColumnService;

import java.sql.SQLException;
import java.util.List;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Manager extends JFrame {

    public static String tableName;
    public static String[] header = null;
    private int row;
    ColumnService cs = new ColumnService();

    public Manager() throws SQLException, ClassNotFoundException {
        List<String> cName = cs.showTableName();
        //表格初始化
        initComponents();
        thisTable(cName);

    }

    private void thisTable(List<String> cName) throws SQLException, ClassNotFoundException {
        //下拉菜单加入表名
        for(int i=0; i<cName.size(); i++)
            comboBox2.addItem(cName.get(i));
        tableName = (String) comboBox2.getItemAt(0);
        //显示表格
        showTables(tableName);
        //给表格设置监听
        table1.getSelectionModel().addListSelectionListener(se->{
                    row = table1.getSelectedRow();
                    if(row > 0) {
                        int position = Integer.parseInt((String) table1.getValueAt(row, 0));
                        System.out.println("选中第:" + row + "行，ID为：" + position);
                    }
                }
        );
    }

    //添加管理员按钮功
    private void addManager(ActionEvent e) {
        new AddManager().setVisible(true);
    }

    //添加信息按钮功能
    private void button4ActionPerformed(ActionEvent e) throws SQLException, ClassNotFoundException {
        JFrame j = new AddSomething();
        j.setVisible(true);
        j.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                    System.out.println("添加窗口关闭");
                try {
                    showTables(tableName);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    //删除信息按钮功能
    private void button5ActionPerformed(ActionEvent e) throws SQLException, ClassNotFoundException {
        System.out.println("删除按钮功能：");
        if(row < 0) return; //没有选中
        if(table1.getRowCount() == 0 ) {
            System.out.println("表是空的");
            return; //表是空的就不看了
        }
        //得到选中行的第一个内容
        String columnName = (String) table1.getColumnName(0);
        System.out.println("删除按钮：column-"+columnName);
        int position = Integer.parseInt((String) table1.getValueAt(row, 0));
        int n = JOptionPane.showConfirmDialog(null, "确定删除"+tableName+"表"+columnName+"="+position+"的列吗？", "删除表项",JOptionPane.YES_NO_OPTION);
        if(n == 1) return;
        if(cs.delete(tableName, columnName, position) > 0)
            JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.OK_OPTION);
        else
            JOptionPane.showMessageDialog(null, "没成功", "提示", JOptionPane.ERROR_MESSAGE);
        showTables(tableName);
    }

    //下拉列表有变化
    private void comboBox2ItemStateChanged(ItemEvent e) throws SQLException, ClassNotFoundException {
        if(comboBox2.getSelectedItem() != null) {
            tableName = (String) comboBox2.getSelectedItem();
        }
        showTables(tableName);
    }

    //用来显示表格的方法
    private void showTables(String tableName) throws SQLException, ClassNotFoundException {
        row = -1; //行数清理
        System.out.println("showTables:");
        System.out.println("tableName:"+tableName);
        //模版
        DefaultTableModel dtm = new DefaultTableModel();
        table1.setModel(dtm);
        //得到表头和表项
        List<String> all = cs.showTables(tableName);
        header = null;
        Object[][] body = new Object[all.size()-1][];
        //标题栏
        header = all.get(0).split(",");
        //没有传至返回
        if(header == null) return;
        System.out.println("header.length:"+header.length);
        //信息栏
        for(int i=1; i<all.size(); i++){
            body[i-1] = all.get(i).split(","); //拆分字符为","
            if (body[i-1] != null) {
                dtm.setDataVector(body, header);
            }
        }
    }

    public static String[] getHeader() {
        return header;
    }

    //获得表名
    public static String getTableName() {
        return tableName;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - xxx holic
        button1 = new JButton();
        label1 = new JLabel();
        comboBox2 = new JComboBox();
        button4 = new JButton();
        button5 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        Container contentPane = getContentPane();

        //---- button1 ----
        button1.setText("\u6dfb\u52a0\u7ba1\u7406\u5458");
        button1.addActionListener(e -> addManager(e));

        //---- label1 ----
        label1.setText("-------------------\u7ba1\u7406\u5458\u754c\u9762-----------------------");

        //---- comboBox2 ----
        comboBox2.addItemListener(e -> {
            try {
                comboBox2ItemStateChanged(e);
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        });

        //---- button4 ----
        button4.setText("\u6dfb\u52a0\u4fe1\u606f");
        button4.addActionListener(e -> {
            try {
                button4ActionPerformed(e);
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        });

        //---- button5 ----
        button5.setText("\u5220\u9664\u4fe1\u606f ");
        button5.addActionListener(e -> {
            try {
                button5ActionPerformed(e);
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        });

        //======== scrollPane1 ========
        scrollPane1.setViewportView(table1);


        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(226, Short.MAX_VALUE)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                    .addGap(202, 202, 202))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(button5, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(450, Short.MAX_VALUE))))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(38, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 613, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(48, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(button1)
                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button4)
                        .addComponent(button5))
                    .addGap(59, 59, 59))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - xxx holic
    private JButton button1;
    private JLabel label1;
    private JComboBox comboBox2;
    private JButton button4;
    private JButton button5;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JFrame jFrame = new Manager();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
