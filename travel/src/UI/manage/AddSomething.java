package UI.manage;

import service.ColumnService;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import javax.swing.*;

class AddSomething extends JFrame{
    private static final long serialVersionUID = 1L;
    private String[] labelName; //列名
    private String[] textValueTemp; //内容
    private String tableName;
    private ColumnService cs = new ColumnService();

    private JPanel jPanel;
    private JLabel jLabel;
    private JTextField jTextField;
    private JButton jButton;

    public AddSomething(){
        super();
        initFrame();
    }

    //产生框
    public void initFrame(){
        JPanel panel = new JPanel();
        jButton=new JButton("提交");
        tableName = Manager.getTableName();
        labelName = Manager.getHeader();
        System.out.println("tableName:"+tableName);
        System.out.println("labelName.length:"+labelName.length);
        textValueTemp = new String[labelName.length];
        if(tableName == null)
            return;
        //框架
        myFrame(panel);
    }

    //框
    private void myFrame(JPanel panel) {
        setTitle("填写：");
        setSize(350,222);
        jPanel=new JPanel();
        jPanel.setBorder((BorderFactory.createTitledBorder("按照列名填入要新增加给"+tableName+"的数据")));
        jPanel.setLayout(new GridLayout(labelName.length-1,2));
        //动态追加JLabel和JTextField
        for(int i=1;i<labelName.length;i++){
            //一个JLabel和JTextField
            jLabel=new JLabel(labelName[i], SwingConstants.LEFT);
            jTextField=new JTextField(null, SwingConstants.RIGHT);

            //让动态追加的JLabel和JTextField相互匹配
            jTextField.setName(labelName[i]);

            //给动态追加的JTextField绑定值变更事件
            jTextField.addFocusListener(new FocusListener(){
                String valChangedBef = "";
                String valChangedAft = "";
                String focusName = "";
                JTextField focusValue;
                @Override
                //焦点离开的时候传值
                public void focusLost(FocusEvent e){
                    focusValue = (JTextField)e.getComponent();
                    valChangedAft = focusValue.getText();
                    if(!valChangedBef.equals(valChangedAft)){
                        focusName = e.getComponent().getName().toString();
                        /*测试*/System.out.println("focusName:"+focusName);
                        for(int j = 1;j<labelName.length;j++){
                            if(focusName.equals(labelName[j])){
                                System.out.println("labelName:"+labelName[j]);
                                textValueTemp[j] = valChangedAft;
                            }
                        }
                        System.out.println("textValueTemp.length:"+textValueTemp.length);
                    }
                }
                @Override
                public void focusGained(FocusEvent e){
                    focusValue=(JTextField)e.getComponent();
                    valChangedBef = focusValue.getText();
                }
            });
            jPanel.add(jLabel);
            jPanel.add(jTextField);
            add(jPanel,BorderLayout.CENTER);
        }

        jButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //发送数据
                try {
                    sendData();
                } catch (SQLException e1) {
                    throw new RuntimeException(e1);
                } catch (ClassNotFoundException e1) {
                    throw new RuntimeException(e1);
                }
            }
        });
        panel.add(jButton);
        add(panel,BorderLayout.SOUTH);
        JPanel panelN= new JPanel();
        add(panelN,BorderLayout.NORTH);
        JPanel panelW = new JPanel();
        add(panelW,BorderLayout.WEST);
        JPanel panelE= new JPanel();
        add(panelE,BorderLayout.EAST);
        //给JPanel追加垂直滚动条
        addScroll();
    }

    //插入数据
    public void sendData() throws SQLException, ClassNotFoundException {
        System.out.println("sendData_labelName.length:"+labelName.length);
        System.out.println("taxtVT:"+textValueTemp.length);
        int result = cs.insert(tableName, labelName, textValueTemp);
        if(result > 0){
            JOptionPane.showConfirmDialog(null, "添加成功", "提示", JOptionPane.OK_OPTION);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else{
            JOptionPane.showConfirmDialog(null, "添加失败", "提示", JOptionPane.OK_OPTION);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    public void addScroll(){
        Container scrollPanel = getContentPane();
        JScrollPane jScrollPane = new JScrollPane(jPanel);
        scrollPanel.setPreferredSize(new Dimension(400,280));
        scrollPanel.add(jScrollPane);
        scrollPanel.setVisible(true);
    }
}