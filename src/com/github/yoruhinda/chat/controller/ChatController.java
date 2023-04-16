package com.github.yoruhinda.chat.controller;

import com.github.yoruhinda.chat.listener.SendListener;
import com.github.yoruhinda.chat.view.ChatFrame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class ChatController {
    private ChatFrame chatFrame;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public ChatController(ChatFrame chatFrame, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        this.chatFrame = chatFrame;
        this.bufferedReader = bufferedReader;
        this.bufferedWriter = bufferedWriter;
        receiveMessages();
        initializeListener();
    }

    private void initializeListener() {
        chatFrame.getChatInputPanel().getSendMessage().addActionListener(new SendListener(this));
    }

    public void sendMessage() {
        String prefix = "";
        if (chatFrame.getTitle().equalsIgnoreCase("server")) {
            prefix = "Server: ";
        } else if (chatFrame.getTitle().equalsIgnoreCase("client")) {
            prefix = "Client: ";
        }
        String message = prefix + chatFrame.getChatInputPanel().getMessage().getText() + "\n";
        chatFrame.getChatInputPanel().getMessage().setText("");
        try {
            bufferedWriter.write(message);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String log = chatFrame.getChatPanel().getChat().getText();
        chatFrame.getChatPanel().getChat().setText(log + message);
    }

    private void receiveMessages() {
        new Thread(() -> {
            while (true) {
                try {
                    String message = bufferedReader.readLine();
                    message += "\n";
                    String log = chatFrame.getChatPanel().getChat().getText();
                    chatFrame.getChatPanel().getChat().setText(log + message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
