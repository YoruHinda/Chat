package com.github.yoruhinda.chat.view;

import com.github.yoruhinda.chat.controller.ChatController;
import com.github.yoruhinda.chat.view.panel.ChatInputPanel;
import com.github.yoruhinda.chat.view.panel.ChatPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class ChatFrame extends JFrame {
    private ChatInputPanel chatInputPanel = new ChatInputPanel();
    private ChatPanel chatPanel = new ChatPanel();
    private Image chatImageIcon;
    private final int WIDTH = 640, HEIGHT = 520;

    public ChatFrame(BufferedReader bufferedReader, BufferedWriter bufferedWriter, String HostName) {
        new ChatController(this, bufferedReader, bufferedWriter);
        setTitle(HostName);
        initialize();
    }

    private void initialize() {
        try {
            chatImageIcon = ImageIO.read(new File("src/com/github/yoruhinda/chat/image/chat.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public ChatInputPanel getChatInputPanel() {
        return chatInputPanel;
    }

    public ChatPanel getChatPanel() {
        return chatPanel;
    }
}
