import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static void main(String[] args) {
        // Create a JFrame for the GUI
        // 创建用于GUI的JFrame
        JFrame frame = new JFrame("Hex String Processor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLayout(new BorderLayout());

        // Create a text area for input
        // 创建输入文本区域
        JTextArea inputArea = new JTextArea(20, 50);
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        JScrollPane inputScrollPane = new JScrollPane(inputArea);

        // Create a text area for output
        // 创建输出文本区域
        JTextArea outputArea = new JTextArea(20, 50);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputArea);

        // Create a button to process the input
        // 创建处理输入的按钮
        JButton processButton = new JButton("Process Hex String");
        Dimension buttonSize = new Dimension(200, 50); // Set desired button size
        processButton.setPreferredSize(buttonSize);
        processButton.setMinimumSize(buttonSize);
        processButton.setMaximumSize(buttonSize);

        // Center the button within a panel
        // 将按钮置于面板中央
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.add(processButton);

        // Add action listener to the button
        // 为按钮添加事件监听器
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputArea.getText();
                String[] sArray = input.split(" ");

                StringBuilder output = new StringBuilder();
                output.append("length: ").append(sArray.length).append("\n\n");

                for (int i = 0; i < sArray.length; i++) {
                    sArray[i] = "0x" + sArray[i];
                    output.append(sArray[i]).append(" ");

                    if ((i + 1) % 30 == 0) {
                        output.append("\n");
                    }
                }

                outputArea.setText(output.toString());
            }
        });

        // Add components to the frame
        // 将组件添加到JFrame中
        frame.add(inputScrollPane, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(outputScrollPane, BorderLayout.SOUTH);

        // Make the frame visible
        // 使JFrame可见
        frame.setVisible(true);
    }
}
