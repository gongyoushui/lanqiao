/*
 * Created by JFormDesigner on Mon Apr 24 14:47:13 CST 2017
 */

package UI.sight;

import UI.user.LogIn;
import domain.Sight;
import service.SightService;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

/**
 * @author xxx holic
 */
public class MainInterface extends JFrame {

    public static List<Sight> sight;
    public static int row;



    public void launch() {
        this.setTitle("TestImage");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);//JFrame最大化
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//让JFrame的关闭按钮起作用
        this.setVisible(true);//显示JFrame
    }


    //初始化加载推荐表格
    public MainInterface() {
        initComponents();

        DefaultTableModel dtm = new DefaultTableModel();
        table1.setModel(dtm);

            try {
                sight = SightService.commendAll();
                Object[][] data = new Object[sight.size()][];

                for (int i = 0; i < sight.size(); i++) {
                    data[i] = sight.get(i).toStringArray();
                    if (data[i] != null) {
                        String[] header = {"景点名", "评分", "介绍"};
                        dtm.setDataVector(data, header);
                    }
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        //给表格设置监听
        table1.getSelectionModel().addListSelectionListener(se->{
                    row = table1.getSelectedRow();
                    new Describle().setVisible(true);
                    System.out.println("main:"+row);
                }
        );

    }

    //搜索按钮
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here 搜索结果
        DefaultTableModel dtm = new DefaultTableModel();
        table1.setModel(dtm);

        try {
                sight = SightService.findSight(textField1.getText());
                Object[][] data = new Object[sight.size()][];
                for (int i = 0; i < sight.size(); i++) {
                    data[i] = sight.get(i).toStringArray();
                    if (data[i] != null) {
                        String[] header = {"景点名", "评分", "介绍"};
                        dtm.setDataVector(data, header);
                    }
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
    }


    //返回按钮功能
   private void button3ActionPerformed(ActionEvent e) {
       // TODO add your code here
       new MainInterface().setVisible(true);
   }

   //退出按钮功能
   private void button4ActionPerformed(ActionEvent e) {
       // TODO add your code here
       new LogIn().setVisible(true);
       this.setVisible(false);
   }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - xxx holic
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        buttonBar = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new CompoundBorder(
                new TitledBorder(new EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", TitledBorder.CENTER,
                    TitledBorder.BOTTOM, new Font("Dialog", Font.BOLD, 12),
                    Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText("\u666f\u70b9");

                //---- textField1 ----
                textField1.setText("\u53bb\u54ea");

                //---- button1 ----
                button1.setText("\u641c\u7d22");
                button1.addActionListener(e -> {
			    button1ActionPerformed(e);
		});

                //---- label2 ----
                label2.setText("\u63a8\u8350\u666f\u70b9:");

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table1);
                }

                //---- button2 ----
                button2.setText("\u67e5\u770b\u6536\u85cf");

                //---- button3 ----
                button3.setText("\u8fd4\u56de");
                button3.addActionListener(e -> button3ActionPerformed(e));

                //---- button4 ----
                button4.setText("\u9000\u51fa");
                button4.addActionListener(e -> button4ActionPerformed(e));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(31, 31, 31)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(button1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                                    .addComponent(button2)
                                    .addGap(20, 20, 20))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(button4)
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                                    .addComponent(button3)
                                    .addGap(68, 68, 68))))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label1)))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(button2)))
                            .addGap(6, 6, 6)
                            .addComponent(label2)
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button3)
                                .addComponent(button4))
                            .addGap(35, 35, 35))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.EAST);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        new LogIn();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - xxx holic
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel buttonBar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

