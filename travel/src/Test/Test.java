package Test;

import UI.user.LogIn;

import javax.swing.*;

/**
 * Created by Administrator on 2017/4/24.
 */
public class Test {
    public static void main(String[] args) throws Exception {
//        new UserDao().selectAll();
        JFrame frame = new LogIn();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
