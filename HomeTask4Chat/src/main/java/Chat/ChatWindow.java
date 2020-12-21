package Chat;

import javax.swing.*;
import java.awt.*;

public class ChatWindow extends JFrame {

    private int width = 500;
    private int sizeX = 150;
    private int sizeY = 250;

    public ChatWindow() {
        setTitle("Chat Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        JPanel desk = new JPanel();

        JTextArea dialogField = new JTextArea();
        dialogField.setBackground(Color.GREEN);
        dialogField.setEditable(false);
        dialogField.setLineWrap(true);
        dialogField.setWrapStyleWord(true);
        dialogField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        JScrollPane jsp = new JScrollPane(dialogField,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JTextField textField = new JTextField();
        textField.addActionListener(action -> {
            sendMessage(textField, dialogField);
        });

        JButton sendMessage = new JButton("\u27A4");
        sendMessage.setBackground(Color.BLUE);
        sendMessage.addActionListener(action -> {
            sendMessage(textField, dialogField);
        });

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
        controlPanel.add(textField);
        controlPanel.add(sendMessage);
        controlPanel.setSize(width - sizeX, sizeY);

        desk.setLayout(new BoxLayout(desk, BoxLayout.X_AXIS));
        desk.add(jsp);
        desk.setSize(sizeX, sizeY);

        getContentPane().add(controlPanel, BorderLayout.SOUTH);
        getContentPane().add(desk, BorderLayout.CENTER);

        setVisible(true);
    }

    private void sendMessage(JTextField textField, JTextArea dialogField) {
        if (textField.getText().equals("")) {
            return;
        }

        dialogField.append("\n" + textField.getText());
        textField.setText("");


        setVisible(true);
    }
}
