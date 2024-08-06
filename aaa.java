package aaamain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * 类e是用于创建和展示一个包含文本字段和按钮的窗口的Swing应用
 * 当用户点击按钮时，会触发一个操作事件，该事件由handleClick方法处理
 */
public class aaa {
    // 定义主窗口
    private JFrame frame;
    // 定义文本字段，用于用户输入
    private JTextField textField;
    // 定义按钮，用于触发操作
    private JButton button;

    /**
     * 构造函数，初始化窗口、文本字段和按钮，并将它们添加到窗口中
     */
    public aaa() {
        // 初始化窗口
        frame = new JFrame("强密码生成器");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 135));
        frame.setLayout(new FlowLayout());
        frame.setBackground(Color.BLACK);

        // 初始化文本字段
        textField = new JTextField(17);
        textField.setBackground(Color.WHITE);
        textField.setForeground(Color.BLACK);
        textField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        // 设置文本字段大小
        textField.setPreferredSize(new Dimension(200, 28));
        // 在面板中添加文字
        frame.add(new JLabel("请输入生成密码的长度"));
        // 设置面板文字大小
        textField.setFont(new Font("Arial", Font.PLAIN, 17));


        // 初始化按钮
        button = new JButton("生成");
        button.addActionListener(this::handleClick);
        // 设置按钮大小
        button.setPreferredSize(new Dimension(100, 30));
        // 将按钮颜色改为浅蓝色
        button.setBackground(new Color(100, 180, 190));

        // 将组件添加到窗口
        frame.add(textField);
        frame.add(button);

        // 准备窗口显示
        frame.pack();
        frame.setVisible(true);
    }
    //

    /**
     * 处理按钮点击事件的方法
     * 验证文本字段中的输入，并根据输入执行相应操作
     *
     * @param e 触发事件的ActionEvent对象
     */
    public void handleClick(ActionEvent e) {

        // 移除文本字段两端的空白字符
        String input = textField.getText().trim();
        if (input.isEmpty()) {
            // 如果输入为空，显示提示信息
            JOptionPane.showMessageDialog(frame, "不能为空", "错误" , JOptionPane.ERROR_MESSAGE);

        } else if (input.matches("[0-9]+")) {
            String input2 = test(Integer.parseInt(input));
            JTextArea textArea = new JTextArea(input2);
            textArea.setEditable(false); // 设置为只读

            // 创建JScrollPane包装JTextArea
            JScrollPane scrollPane = new JScrollPane(textArea);

            // 显示带有滚动面板的消息对话框
            JOptionPane.showMessageDialog(null, scrollPane, "生成的密码", JOptionPane.INFORMATION_MESSAGE);

        } else {
            // 如果输入既不是纯数字也不是纯字母，弹出提示框
            JOptionPane.showMessageDialog(frame, "不是数字", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }


    /**
     * 生成指定长度的随机代码
     *
     * @param n 生成代码的长度
     * @return 生成的随机代码
     */
    public static String test(int n) {
        String code = "";
        for (int i = 0; i < n; i++) {
            int type = (int) (Math.random() * 3);

            switch (type) {
                case 0:
                    int num = (int) (Math.random() * 10);
                    code += num;
                    break;

                case 1:
                    int num2 = (int) (Math.random() * 26);
                    char ch = (char) ('A' + num2);
                    code += ch;
                    break;

                case 2:
                    int num3 = (int) (Math.random() * 26);
                    char ch2 = (char) ('a' + num3);
                    code += ch2;
                    break;
            }
        }
        return code;
    }

    /**
     * 主方法，程序的入口点
     * 使用SwingUtilities.invokeLater确保GUI在事件调度线程(EDT)上被创建和显示
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new aaa(); // 确保在EDT上创建和显示GUI
        });
    }
}
