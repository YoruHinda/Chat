package com.github.yoruhinda.chat.view.panel;

import javax.swing.*;
import java.awt.*;

public class ChatInputPanel extends JPanel {
    private JEditorPane message = new JEditorPane();
    private JScrollPane messageScrollPane = new JScrollPane(message);
    private JButton sendMessage = new JButton();

    public ChatInputPanel(){
        initialize();
    }

    private void initialize(){
        sendMessage.setText("Send");
        sendMessage.setPreferredSize(new Dimension(100,50));
        sendMessage.setFocusPainted(false);
        message.setPreferredSize(new Dimension(500,100));
        messageScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(messageScrollPane);
        add(sendMessage);
    }

    public JEditorPane getMessage() {
        return message;
    }

    public JButton getSendMessage() {
        return sendMessage;
    }
}
