package com.github.yoruhinda.chat.view;

import com.github.yoruhinda.chat.view.panel.ChatInputPanel;
import com.github.yoruhinda.chat.view.panel.ChatPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ChatFrame extends JFrame {
    private final int WIDTH = 640, HEIGHT = 520;
    private ChatPanel chatPanel = new ChatPanel();
    private ChatInputPanel chatInputPanel = new ChatInputPanel();
    private Image chatImageIcon;

    public ChatFrame(){
        initialize();
    }

    private void initialize(){
        try {
            chatImageIcon = ImageIO.read(new File("src/com/github/yoruhinda/chat/image/chat.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTitle("Chat");
        setIconImage(chatImageIcon);
        setLayout(new BorderLayout());
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(chatPanel, BorderLayout.CENTER);
        add(chatInputPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
}
