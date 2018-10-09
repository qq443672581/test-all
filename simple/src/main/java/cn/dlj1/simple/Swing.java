package cn.dlj1.simple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;

public class Swing {

    private JFrame frame = new JFrame("登录");
    private Container c = frame.getContentPane();
    private JTextField username = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JButton ok = new JButton("确定");
    private JButton cancel = new JButton("取消");

    public Swing() {
        frame.setSize(300, 200);
        c.setLayout(new BorderLayout());
        initFrame();
        action();
        frame.setVisible(true);
    }

    private void initFrame() {

        //顶部
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("系统管理员登录"));
        c.add(titlePanel, "North");

        //中部表单
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        JLabel l1 = new JLabel("用户名:");
        l1.setBounds(50, 20, 50, 20);
        JLabel l2 = new JLabel("密    码:");
        l2.setBounds(50, 60, 50, 20);
        fieldPanel.add(l1);
        fieldPanel.add(l2);
        username.setBounds(110, 20, 120, 20);
        password.setBounds(110, 60, 120, 20);
        fieldPanel.add(username);
        fieldPanel.add(password);
        c.add(fieldPanel, "Center");

        //底部按钮
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(ok);
        buttonPanel.add(cancel);
        c.add(buttonPanel, "South");
    }

    private void action() {
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    valida();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void valida() throws IOException {
        File file = new File("c:" + File.separator + "validater.properties");
        if (!file.exists()) {
            file.createNewFile();
            file = new File("c:" + File.separator + "validater.properties");
            String text = "username=admin\r\npassword=admin";
            OutputStream os = new FileOutputStream(file);
            os.write(text.getBytes());
            os.close();
            file = new File("c:" + File.separator + "validater.properties");
        }

        Properties p = new Properties();
        p.load(new FileInputStream(file));
        String userName = (String) p.get("username");
        String passWord = (String) p.get("password");
        if (username.getText().equals(userName) && new String(password.getPassword()).equals(passWord)) {
            System.out.println("Login Success!");
        } else {
            System.out.println("Login Error!");
        }
    }

    public static void main(String[] args) {
        new Swing();
    }

}
