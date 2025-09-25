package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JFrameDemo1 {
    public static void main(String[] args) {
        JFrame jf = new JFrame("登录窗口");//创建窗体
        JPanel jp = new JPanel();//创建面板
        jf.add(jp);//添加面板

        jf.setSize(400, 300);//设置窗体的宽高
        jf.setLocationRelativeTo(null);//设置窗体居中
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体关闭方式

        JButton jb = new JButton("登录");//创建按钮
        jp.add(jb);//添加按钮

        jb.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("登录");
                JOptionPane.showMessageDialog(jf,"登录成功");
            }
        });
        jf.setVisible(true);//设置窗体可见
    }
}
