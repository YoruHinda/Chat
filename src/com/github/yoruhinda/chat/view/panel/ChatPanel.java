package com.github.yoruhinda.chat.view.panel;

import javax.swing.*;
import java.awt.*;

public class ChatPanel extends JPanel {
    private JEditorPane chat = new JEditorPane();

    public ChatPanel(){
        initialize();
    }

    private void initialize(){
        chat.setPreferredSize(new Dimension(550,350));
        chat.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chat);
        chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(chatScrollPane);
    }

    public JEditorPane getChat() {
        return chat;
    }
}
