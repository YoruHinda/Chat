package com.github.yoruhinda.chat.listener;

import com.github.yoruhinda.chat.controller.ChatController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendListener implements ActionListener {
    private ChatController chatController;

    public SendListener(ChatController chatController) {
        this.chatController = chatController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        chatController.sendMessage();
    }
}
